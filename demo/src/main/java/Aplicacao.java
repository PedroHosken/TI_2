import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Listar Usuários");
            System.out.println("2 - Inserir Usuário");
            System.out.println("3 - Atualizar Usuário");
            System.out.println("4 - Excluir Usuário");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    listarUsuarios(usuarioDAO);
                    break;
                case 2:
                    inserirUsuario(usuarioDAO, scanner);
                    break;
                case 3:
                    atualizarUsuario(usuarioDAO, scanner);
                    break;
                case 4:
                    excluirUsuario(usuarioDAO, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    // Função para listar todos os usuários
    private static void listarUsuarios(UsuarioDAO usuarioDAO) {
        Usuario[] usuarios = usuarioDAO.getUsuarios();
        if (usuarios != null && usuarios.length > 0) {
            System.out.println("\n========== LISTA DE USUÁRIOS ==========");
            for (Usuario usuario : usuarios) {
                System.out.println("Código: " + usuario.getCode() + ", Login: " + usuario.getLogin() + ", Sexo: " + usuario.getSexo());
            }
        } else {
            System.out.println("Nenhum usuário encontrado.");
        }
    }

    // Função para inserir um novo usuário (sem solicitar código se autoincrementado)
    private static void inserirUsuario(UsuarioDAO usuarioDAO, Scanner scanner) {
        System.out.println("\n========== INSERIR USUÁRIO ==========");

        System.out.print("Digite o login do usuário: ");
        String login = scanner.nextLine();

        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();

        System.out.print("Digite o sexo do usuário (M/F): ");
        char sexo = scanner.nextLine().charAt(0);

        Usuario usuario = new Usuario(0, login, senha, sexo); 

        if (usuarioDAO.inserirUsuario(usuario)) {
            System.out.println("Usuário inserido com sucesso!");
        } else {
            System.out.println("Erro ao inserir o usuário.");
        }
    }

    // Função para atualizar um usuário existente
    private static void atualizarUsuario(UsuarioDAO usuarioDAO, Scanner scanner) {
        System.out.println("\n========== ATUALIZAR USUÁRIO ==========");
        System.out.print("Digite o código do usuário a ser atualizado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite o novo login: ");
        String login = scanner.nextLine();

        System.out.print("Digite a nova senha: ");
        String senha = scanner.nextLine();

        System.out.print("Digite o novo sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);

        Usuario usuario = new Usuario(codigo, login, senha, sexo);

        if (usuarioDAO.atualizarUsuario(usuario)) {
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar o usuário.");
        }
    }

    // Função para excluir um usuário
    private static void excluirUsuario(UsuarioDAO usuarioDAO, Scanner scanner) {
        System.out.println("\n========== EXCLUIR USUÁRIO ==========");
        System.out.print("Digite o código do usuário a ser excluído: ");
        int codigo = scanner.nextInt();

        if (usuarioDAO.excluirUsuario(codigo)) {
            System.out.println("Usuário excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir o usuário.");
        }
    }
}
