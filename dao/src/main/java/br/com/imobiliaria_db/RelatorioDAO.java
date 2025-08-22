package br.com.imobiliaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioDAO extends BaseDAO {

    /**
     * Exemplo: quantidade de clientes cadastrados
     */
    public int contarClientes() {
        String sql = "SELECT COUNT(*) AS total FROM cliente";

        try (Connection con = getConnection();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Exemplo: quantidade de imóveis cadastrados
     */
    public int contarImoveis() {
        String sql = "SELECT COUNT(*) AS total FROM imovel";

        try (Connection con = getConnection();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Exemplo: quantidade de contratos ativos
     */
    public int contarContratosAtivos() {
        String sql = "SELECT COUNT(*) AS total FROM contrato WHERE dataFinal >= CURDATE()";

        try (Connection con = getConnection();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Exemplo: valor total em contratos
     */
    public double somarValorContratos() {
        String sql = "SELECT SUM(valorMensal) AS soma FROM contrato";

        try (Connection con = getConnection();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("soma");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
