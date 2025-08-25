package imobiliaria.dao;

import java.sql.*;
import imobiliaria.database.ConnectionFactory;

public class ClienteDAO {

    public void inserir(String nome, String email, String telefone, String cpf) {
        String sql = "INSERT INTO Cliente (nome, email, telefone, cpf) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.setString(4, cpf);
            stmt.executeUpdate();

            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("--------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
