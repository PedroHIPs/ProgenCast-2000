/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CRUDUser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CUser;
import org.json.simple.JSONObject;

/**
 *
 * @author Pedro HIPs
 */
public class SLogin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        CUser obj;
        CRUDUser objCRUD;
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String log = "";
        HttpSession sessao;
        PrintWriter out = response.getWriter();
        try {
            objCRUD = new CRUDUser();
            obj = objCRUD.login(login, pass);
            if (obj == null) {
                JSONObject objson = new JSONObject();
                objson.put("Name", "Erro");
                out.print(objson.toJSONString());
            } else {
                JSONObject objson = new JSONObject();
                objson.put("Name", obj.getUname());
                objson.put("Log", log);
                
                sessao = request.getSession(true);
                sessao.setAttribute("user", obj);
                sessao.setAttribute("cod", obj.getCodigo());
                out.print(objson.toJSONString());
            }
        } catch (Exception ex) {
            JSONObject objson = new JSONObject();
            objson.put("Name", ex.getMessage());
            out.print(objson.toJSONString());
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
