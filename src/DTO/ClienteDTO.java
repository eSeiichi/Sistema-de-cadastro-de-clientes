package DTO;

public class ClienteDTO {
    private int id;
    private String nome, cidade;

    public ClienteDTO(int id, String nome, String cidade){
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }
    public ClienteDTO(){};

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public String getNome(){return this.nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCidade(){return this.cidade;}
    public void setCidade(String cidade){this.cidade = cidade;}

}
