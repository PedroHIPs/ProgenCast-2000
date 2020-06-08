
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class CBanco {
    
    public static Connection conexao;
    public PreparedStatement comando;
    public ResultSet tabela;

    public CBanco() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:" + "postgresql://127.0.0.1:5432/PGC", "postgres", "1771");
            }
        } catch (Exception ex) {
            throw new Exception("Erro de conexâo: " + ex.getMessage());
        }
    }
    
}
