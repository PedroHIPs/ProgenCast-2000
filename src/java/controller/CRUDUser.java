/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import model.CBanco;
import model.CUser;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

/**
 *
 * @author aluno
 */
public class CRUDUser {

    public ResultSet listar() throws Exception {
        CBanco bb;
        try {
            bb = new CBanco();
            LargeObjectManager lobj = ((org.postgresql.PGConnection)CBanco.conexao).getLargeObjectAPI();
            bb.comando = CBanco.conexao.prepareStatement("Select * from uuser where uadmin = true");
            bb.tabela = bb.comando.executeQuery();
            CBanco.conexao.close();
            return (bb.tabela);
        } catch (Exception ex) {
            throw new Exception("Erro ao listar Administradores: " + ex.getMessage());
        }
    }
    
    public CUser login(String login, String senha) throws Exception
    {
        CBanco bb;
        CUser obj = null;
        try
        {
            bb = new CBanco();
            bb.comando = CBanco.conexao.prepareStatement("Select * from uuser where ulogin=? and pass=?");
            bb.comando.setString(1, login);
            bb.comando.setString(2, senha);
            bb.tabela = bb.comando.executeQuery();
            if (bb.tabela.next())
            {
                obj = new CUser();
                obj.setCodigo(bb.tabela.getInt(1));
                /*returningcod = String.valueOf(bb.tabela.getInt(1));*/
                obj.setCodigo(bb.tabela.getInt(1));
                obj.setUname(bb.tabela.getString(2));
                obj.setUadmin(bb.tabela.getBoolean(3));
                obj.setUlogin(bb.tabela.getString(4));
                obj.setPass(bb.tabela.getString(5));
                obj.setArq(bb.tabela.getBytes(6));
                obj.setNomeArq(bb.tabela.getString(7));
                obj.setEmail(bb.tabela.getString(8));
                obj.setNumero(bb.tabela.getString(9));
            }
            CBanco.conexao.close();
            return(obj);
        }
        catch (Exception ex)
        {
            throw new Exception ("Erro ao logar: " + ex.getMessage());
        }   
    }

}
