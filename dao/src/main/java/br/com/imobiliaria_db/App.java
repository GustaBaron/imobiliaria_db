package imobiliaria.model;

import imobiliaria.database.DatabaseCreator;
import imobiliaria.dao.ClienteDAO;
import imobiliaria.dao.ImovelDAO;
import imobiliaria.dao.ContratoDAO;

import java.sql.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Criar o banco de dados e tabelas
        DatabaseCreator.createDatabase();

        // Criar DAOs
        ClienteDAO clienteDAO = new ClienteDAO();
        ImovelDAO imovelDAO = new ImovelDAO();
        ContratoDAO contratoDAO = new ContratoDAO();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema Imobiliário ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Imóvel");
            System.out.println("3. Cadastrar Contrato");
            System.out.println("4. Sair");
            System.out.println("5. Gerar Relatório");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email do cliente: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    clienteDAO.inserir(nome, email, telefone, cpf);

                    break;
                case 2:
                    System.out.print("Endereço do imóvel: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Valor do imóvel: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer
                    imovelDAO.inserir(endereco, valor);
                    break;
                case 3:
                    System.out.print("ID do cliente: ");
                    int clienteId = scanner.nextInt();
                    System.out.print("ID do imóvel: ");
                    int imovelId = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Data do contrato (YYYY-MM-DD): ");
                    String dataStr = scanner.nextLine();
                    Date dataContrato = Date.valueOf(dataStr);
                    contratoDAO.inserir(clienteId, imovelId, dataContrato);
                    break;
                case 4:
                    System.out.println("Encerrando sistema...");
                    break;
                case 5:
                    System.out.println("\n--- Clientes ---");
                    clienteDAO.listar();

                    System.out.println("\n--- Imóveis ---");
                    imovelDAO.listar();

                    System.out.println("\n--- Contratos ---");
                    contratoDAO.listar();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
