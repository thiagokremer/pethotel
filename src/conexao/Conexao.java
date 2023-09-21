
package conexao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexao {
    
    
    public Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pethotel ","root", "senac@23");
            
            return conn;
           }
        
        catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }

    }
    
    

    
}
