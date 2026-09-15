package DTO;

public class UsuarioDTO {
    private int id;
    private String username, senha, cargo;

    public UsuarioDTO(int id, String username, String senha, String cargo){
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.cargo = cargo;
    }

    public UsuarioDTO() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String  getCargo() {
        return cargo;
    }

    public void setCargoDTO(String cargo) {
        this.cargo = cargo;
    }
}
