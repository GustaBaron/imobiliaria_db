package imobiliaria.dao;

import java.sql.*;
import imobiliaria.database.ConnectionFactory;

public class ContratoDAO {
    public void inserir(int clienteId, int imovelId, Date data) {
        String sql = "INSERT INTO Contrato (cliente_id, imovel_id, data) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, clienteId);
            stmt.setInt(2, imovelId);
            stmt.setDate(3, data);
            stmt.executeUpdate();

            System.out.println("Contrato inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void listar() {
        String sql = "SELECT c.id, cl.nome AS cliente_nome, i.endereco AS imovel_endereco, c.data " +
                "FROM Contrato c " +
                "JOIN Cliente cl ON c.cliente_id = cl.id " +
                "JOIN Imovel i ON c.imovel_id = i.id";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID do Contrato: " + rs.getInt("id"));
                System.out.println("Cliente: " + rs.getString("cliente_nome"));
                System.out.println("Imóvel: " + rs.getString("imovel_endereco"));
                System.out.println("Data: " + rs.getDate("data"));
                System.out.println("--------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

