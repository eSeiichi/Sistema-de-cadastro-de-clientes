package DAO;

import DTO.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//classe destinada à feature de login
//status: em elaboração
public class UsuarioDAO {
    Connection conexao;
    PreparedStatement stmt;
    ResultSet rs;

    public String cadastrarUsuario(UsuarioDTO usuarioDTO){
        String sql = "insert into usuario (username,senha,cargo) values (?,?,?)";
        try{
            conexao = new ConexaoDAO().getConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,usuarioDTO.getUsername());
            stmt.setString(2,usuarioDTO.getSenha());
            stmt.setString(3,usuarioDTO.getCargo());
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            System.out.println("Erro ao inserir os dados");
            System.out.println("Class: UsuarioDAO; Metodo: cadastrarUsuario");
            return "Error: "+ e.getMessage();
        }
        return "Usuario cadastrado com sucesso";
    }
    public String login(UsuarioDTO usuarioDTO){
        String sql = "select cargo from usuario where (username =  (?) and senha = (?))";
        try{
            conexao = new ConexaoDAO().getConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,usuarioDTO.getUsername());
            stmt.setString(2,usuarioDTO.getSenha());
            rs = stmt.executeQuery();
            if (rs.next()) {
                String cargo = rs.getString("cargo");

                rs.close();
                stmt.close();

                return cargo;
            } else {
                rs.close();
                stmt.close();
                return "Usuário ou senha inválidos";
            }
        }
        catch (SQLException e){
        System.out.println("Erro ao realizar login");
        System.out.println("Class: UsuarioDAO; Metodo: login");
        return "Error: "+ e.getMessage();
    }
    }
}
