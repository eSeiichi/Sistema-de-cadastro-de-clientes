package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    public Connection getConexao(){
        Connection conexao =null;
        String host = "jdbc:mysql://localhost/lpcy";
        String user = "root";
        String password = "";

        try {
            conexao = DriverManager.getConnection(host,user,password);
        } catch (SQLException e){
            System.out.println("Erro ao conectar no Banco de dados");
            System.out.println("Class: ConexaoDAO; Metodo: getConexao");
            System.out.println("Error: "+e.getMessage());
        }
        return conexao;
    }
}
