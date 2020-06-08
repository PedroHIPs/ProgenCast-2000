/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CRUDUser;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CUser;

/**
 *
 * @author aluno
 */
public class SContactAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FileOutputStream fos;
        FileDescriptor fd;
        String appPath = getServletConfig().getServletContext().getRealPath("/").replaceAll("/$", "");
        request.setCharacterEncoding("UTF-8");
        ResultSet tabela;
        CRUDUser objCRUD;
        CUser obj;
        int i = 1;
        String estilo;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            obj = new CUser();
            objCRUD = new CRUDUser();
            tabela = objCRUD.listar();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<link rel='stylesheet' type='text/css' href='CSS/myCSS.css'>");
            out.println("<head>");
            out.println("<title>Servlet SMenu</title>");
            out.println("</head>");
            out.println("<body class='bwhite'>");
            if (tabela != null) {
                while (tabela.next()) {
                    obj.setCodigo(tabela.getInt(1));                    
                    obj.setUname(tabela.getString(2));                                     
                    obj.setUadmin(tabela.getBoolean(3));      
                    obj.setUlogin(tabela.getString(4)); 
                    obj.setPass(tabela.getString(5)); 
                    obj.setArq(tabela.getBytes(6));
                    obj.setNomeArq(tabela.getString(7));
                    obj.setEmail(tabela.getString(8)); 
                    obj.setNumero(tabela.getString(9)); 
                    fos = new FileOutputStream(appPath + "IMGS" + obj.getNomeArq());
                    fos.write(obj.getArq()); //tabela.getByte("arq"));  
                    fd = fos.getFD();
                    fos.flush();
                    fd.sync();
                    fos.close();
                    if (i % 2 == 0) {
                        estilo = "whitef1";
                    } else {
                        estilo = "grayf1";
                    }
                    out.println("<div align='center'>");
                    out.println("<img src='IMGS/"+obj.getNomeArq()+"' width='200' height='200'/>");
                    out.println("<h1 class='" + estilo + "'>" + tabela.getString(2) + "</h1>");
                    out.println("<h1 class='" + estilo + "'>" + tabela.getString(8) + "</h1>");
                    out.println("<h1 class='" + estilo + "'> __________________________</h1>");
                    out.println("<br>");
                    out.println("</div>");
                    i++;
                }
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SContactAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Erro at servlet SContactAdmin: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
