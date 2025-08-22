package br.com.imobiliaria_db;

public class Relatorio {
    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio();

        System.out.println("📊 Relatórios:");
        System.out.println("Total de clientes: " + relatorio.contarClientes());
        System.out.println("Total de imóveis: " + relatorio.contarImoveis());
        System.out.println("Contratos ativos: " + relatorio.contarContratosAtivos());
        System.out.println("Valor total em contratos: R$ " + relatorio.somarValorContratos());
    }
}
}
