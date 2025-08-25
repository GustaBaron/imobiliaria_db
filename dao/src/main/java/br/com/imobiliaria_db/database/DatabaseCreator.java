package imobiliaria.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {
    public static void createDatabase() {
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            // Criar tabelas
            String sqlCliente = "CREATE TABLE IF NOT EXISTS Cliente (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nome VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(100) NOT NULL, " +
                    "telefone VARCHAR(100) NOT NULL, " +
                    "cpf VARCHAR(14) NOT NULL)";


            String sqlImovel = "CREATE TABLE IF NOT EXISTS Imovel (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "endereco VARCHAR(200) NOT NULL, " +
                    "valor DECIMAL(10,2) NOT NULL)";

            String sqlContrato = "CREATE TABLE IF NOT EXISTS Contrato (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "cliente_id INT, " +
                    "imovel_id INT, " +
                    "data DATE, " +
                    "FOREIGN KEY (cliente_id) REFERENCES Cliente(id), " +
                    "FOREIGN KEY (imovel_id) REFERENCES Imovel(id))";

            stmt.execute(sqlCliente);
            stmt.execute(sqlImovel);
            stmt.execute(sqlContrato);

            System.out.println("Banco de dados criado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
