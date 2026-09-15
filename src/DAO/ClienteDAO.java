package DAO;

import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    Connection conexao;
    PreparedStatement stmt;
    ResultSet rs;
    ArrayList<ClienteDTO> lista = new ArrayList<>();

    public String cadastrarCliente(ClienteDTO clienteDTO) {
        String sql = "INSERT INTO clientes (nome,cidade) VALUES (?,?)";
        try {
            conexao = new ConexaoDAO().getConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, clienteDTO.getNome());
            stmt.setString(2, clienteDTO.getCidade());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir os dados");
            System.out.println("Class: ClienteDAO; Metodo: cadastrarCliente");
            return "Error: "+ e.getMessage();
        }
        return "Cliente cadastrado com sucesso!";
    }

    public ArrayList<ClienteDTO> listarCliente() {
        String sql = "SELECT * FROM clientes";
        try {
            conexao = new ConexaoDAO().getConexao();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setId(rs.getInt("id"));
                clienteDTO.setNome(rs.getString("nome"));
                clienteDTO.setCidade(rs.getString("cidade"));

                lista.add(clienteDTO);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes");
            System.out.println("Class: ClienteDAO; Metodo: listarCliente");
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    public String atualizarCliente(ClienteDTO clienteDTO){
        String sql = "UPDATE clientes set nome = (?), cidade = (?) WHERE id = (?)";
        try {
            conexao=new ConexaoDAO().getConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,clienteDTO.getNome());
            stmt.setString(2,clienteDTO.getCidade());
            stmt.setInt(3,clienteDTO.getId());
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar cliente");
            System.out.println("Class: ClienteDAO; Metodo: atualizarCliente");
            return "Error: "+ e.getMessage();

        }
        return "Cliente atualizado com sucesso!";
    }
    public String deletarCliente(int id, ClienteDTO clienteDTO){
        String sql = "DELETE FROM clientes WHERE id = (?)";
        try{
            conexao = new ConexaoDAO().getConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,clienteDTO.getId());
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            System.out.println("Erro ao deletar cliente");
            System.out.println("Class: ClienteDAO; Metodo: deletarCliente");
            return "Error: "+ e.getMessage();
        }
        return "Cliente deletado com sucesso!";
    }
}