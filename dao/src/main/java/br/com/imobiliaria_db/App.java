package br.com.imobiliaria_db;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== SISTEMA IMOBILIÁRIA =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Imóvel");
            System.out.println("3 - Cadastrar Contrato");
            System.out.println("4 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarImovel();
                case 3 -> cadastrarContrato();
                case 4 -> menuRelatorios();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // ==== MÉTODOS DE CADASTRO ==== //
    private static void cadastrarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        Cliente client = new Cliente();
        client.setNome(nome);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.salvar(client);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarImovel() {
        System.out.print("Descrição do Imóvel: ");
        String descricao = scanner.nextLine();

        Imovel imov = new Imovel();
        imovel.setDescricao(descricao);
        imovel.setDisponivel(true);

        ImovelDAO imovelDAO = new ImovelDAO();
        imovelDAO.salvar(imovel);

        System.out.println("Imóvel cadastrado com sucesso!");
    }

    private static void cadastrarContrato() {
        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("ID do Imóvel: ");
        int idImovel = scanner.nextInt();

        Contrato contrato = new Contrato();
        contrato.setIdCliente(idCliente);
        contrato.setIdImovel(idImovel);
        contrato.setDataInicio(LocalDate.now());
        contrato.setDataFim(LocalDate.now().plusMonths(12));

        ContratoDAO contratoDAO = new ContratoDAO();
        contratoDAO.salvar(contrato);

        System.out.println("Contrato cadastrado com sucesso!");
    }

    // ==== RELATÓRIOS ==== //
    private static void menuRelatorios() {
        int opcao;
        System.out.println("\n--- Relatórios ---");
        System.out.println("1 - Listar imóveis disponíveis para aluguel");
        System.out.println("2 - Listar contratos ativos");
        System.out.println("3 - Clientes com mais contratos");
        System.out.println("4 - Contratos expirando nos próximos 30 dias");
        System.out.print("Escolha: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> listarImoveisDisponiveis();
            case 2 -> listarContratosAtivos();
            case 3 -> clientesComMaisContratos();
            case 4 -> contratosExpirando();
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void listarImoveisDisponiveis() {
        ImovelDAO dao = new ImovelDAO();
        List<Imovel> imoveis = dao.buscarDisponiveis();
        imoveis.forEach(System.out::println);
    }

    private static void listarContratosAtivos() {
        ContratoDAO dao = new ContratoDAO();
        List<Contrato> contratos = dao.buscarAtivos();
        contratos.forEach(System.out::println);
    }

    private static void clientesComMaisContratos() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.buscarComMaisContratos();
        clientes.forEach(System.out::println);
    }

    private static void contratosExpirando() {
        ContratoDAO dao = new ContratoDAO();
        List<Contrato> contratos = dao.buscarExpirandoEm30Dias();
        contratos.forEach(System.out::println);
    }
}
