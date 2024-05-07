package Pasta_conexao_Banco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
   
    public Connection conectaBD(){
        Connection conn = null;
        
        try {
            String url= "jdbc:mysql://localhost:3306/db_cicero?user=root&password=1234";
            
            conn=DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Conexao DAO tá dando erro" + erro.getMessage());
        }
        return conn;
    }
    
}
