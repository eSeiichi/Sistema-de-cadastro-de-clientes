package VIEW;

import DAO.ClienteDAO;
import DAO.ConexaoDAO;
import DAO.UsuarioDAO;
import DTO.ClienteDTO;
import DTO.UsuarioDTO;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conexao = new ConexaoDAO().getConexao();

        String opc = "1", cargo = "";

        while (true){
            try {
                System.out.println("0 - Sair");
                System.out.println("1 - Fazer Login");
                System.out.println("2 - Criar conta");
                int opcLogin = sc.nextInt();
                sc.nextLine();
                if (opcLogin == 1){
                    System.out.println("Digite o username: ");
                    String username = sc.nextLine();
                    System.out.println("Digite a senha: ");
                    String senha = sc.nextLine();

                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    UsuarioDAO usuarioDAO = new UsuarioDAO();

                    usuarioDTO.setUsername(username);
                    usuarioDTO.setSenha(senha);
                    cargo = usuarioDAO.login(usuarioDTO);

                    if (!(cargo.equals("admin")|| cargo.equals("user"))){
                        System.out.println(cargo);
                    } else {
                        break;
                    }
                }else if (opcLogin == 2){
                    System.out.println("Username: ");
                    String username = sc.nextLine();
                    System.out.println("Senha: ");
                    String senha = sc.nextLine();
                    System.out.println("Cargo (admin/user): ");
                    String cargo1 = sc.nextLine();

                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    UsuarioDAO usuarioDAO = new UsuarioDAO();

                    usuarioDTO.setUsername(username);
                    usuarioDTO.setSenha(senha);
                    usuarioDTO.setCargoDTO(cargo1);
                    System.out.println(usuarioDAO.cadastrarUsuario(usuarioDTO));
                } else if (opcLogin == 0){
                    System.exit(0);
                }
            }catch (InputMismatchException e){
                System.out.println("Entrada de dados inválida");
                System.out.println("Class: Main");
                System.out.println("Error: " + e.getMessage());
            }
        }

        if (cargo.equals("admin")){
            do {
                try {
                    System.out.println("Menu de opções do programa de cadastro de clientes");
                    System.out.println("0 - Sair");
                    System.out.println("1 - Registrar cliente");
                    System.out.println("2 - Listar clientes");
                    System.out.println("3 - Atualizar clientes");
                    System.out.println("4 - Deletar clientes");
                    System.out.println("Selecione a opção desejada: ");
                    opc = sc.nextLine();
                    System.out.println("===========================");
                    switch (opc) {
                        case "0": {
                            System.out.println("Encerrando o programa!");
                            break;
                        }
                        case "1":{
                            System.out.println("Digite o nome do cliente: ");
                            String nome = sc.nextLine();
                            System.out.println("Digite a cidade do cliente: ");
                            String cidade = sc.nextLine();

                            ClienteDTO clienteDTO = new ClienteDTO();
                            clienteDTO.setNome(nome);
                            clienteDTO.setCidade(cidade);

                            ClienteDAO clienteDAO = new ClienteDAO();
                            System.out.println(clienteDAO.cadastrarCliente(clienteDTO));
                            System.out.println("===========================");
                            break;
                        }
                        case "2": {
                            listarClientes();
                            break;
                        }
                        case "3": {
                            listarClientes();

                            System.out.println("Digite o id do cliente a ser atualizado [0 - cancelar]: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            if (id == 0){
                                System.out.println("Cancelando..");
                                System.out.println("===========================");
                                break;
                            }else {
                                System.out.println("Digite o novo nome do cliente: ");
                                String nome = sc.nextLine();
                                System.out.println("Digite a nova cidade do cliente: ");
                                String cidade = sc.nextLine();

                                ClienteDTO clienteDTO = new ClienteDTO(id,nome,cidade);
                                ClienteDAO clienteDAO = new ClienteDAO();
                                System.out.println(clienteDAO.atualizarCliente(clienteDTO));
                                System.out.println("===========================");
                                break;
                            }
                        }
                        case "4":{
                            listarClientes();
                            System.out.println("Digite o id do cliente a ser deletado [0 - cancelar]: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            if (id==0){
                                System.out.println("Cancelando..");
                                System.out.println("===========================");
                                break;
                            }else{
                                ClienteDTO clienteDTO = new ClienteDTO();
                                clienteDTO.setId(id);
                                ClienteDAO clienteDAO = new ClienteDAO();
                                System.out.println(clienteDAO.deletarCliente(id,clienteDTO));
                                System.out.println("===========================");
                                break;
                            }
                        }
                        default: {
                            System.out.println("Escolha uma opção válida");
                            System.out.println("===========================");
                        }
                    }
                }catch (InputMismatchException e){
                    System.out.println("Valor de entrada inválido");
                    System.out.println("Class: Main");
                    System.out.println("Error: "+e.getMessage());
                }
            }while (!opc.equals("0"));

        }else if (cargo.equals("user")) {

            do {
                System.out.println("Menu de opções do programa de cadastro de clientes");
                System.out.println("0 - Sair");
                System.out.println("1 - Registrar cliente");
                System.out.println("2 - Listar clientes");
                System.out.println("Selecione a opção desejada: ");
                opc = sc.nextLine();
                System.out.println("===========================");
                switch (opc) {
                    case "0": {
                        System.out.println("Encerrando o programa!");
                        break;
                    }
                    case "1": {
                        System.out.println("Digite o nome do cliente: ");
                        String nome = sc.nextLine();
                        System.out.println("Digite a cidade do cliente: ");
                        String cidade = sc.nextLine();

                        ClienteDTO clienteDTO = new ClienteDTO();
                        clienteDTO.setNome(nome);
                        clienteDTO.setCidade(cidade);

                        ClienteDAO clienteDAO = new ClienteDAO();
                        System.out.println(clienteDAO.cadastrarCliente(clienteDTO));
                        System.out.println("===========================");
                        break;
                    }
                    case "2": {
                        listarClientes();
                        break;
                    }
                    default: {
                        System.out.println("Escolha uma opção válida");
                        System.out.println("===========================");
                    }
                }
            } while (!opc.equals(0));
        }else{
            System.out.println("Usuário com cargo inválido");
        }
    }

    public static void listarClientes(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<ClienteDTO> lista = clienteDAO.listarCliente();
        for (int i=0; i<lista.size();i++ ){
            System.out.println("Id: "+ lista.get(i).getId());
            System.out.println("Nome: "+ lista.get(i).getNome());
            System.out.println("Cidade: "+lista.get(i).getCidade());
            System.out.println("===========================");
        }
    }
}
