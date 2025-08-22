package br.com.imobiliaria_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContratoDAO extends BaseDAO {
    public void deletarPeloId(long id) {
        String sql = "delete from contrato where id_imovel or id_cliente = ? ";
        // try-with-resources
        // fecha automaticamente o recurso aberto.
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setLong(1, id);
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Contrato contrato) {
        String sql = "insert into contrato (id, imovel_id, cliente_id, valor_mensal, data_inicial, data_final) values (?,?)";

        try {
            Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setLong(1, contrato.getId());
            pre.setLong(2, contrato.getImovel_id());
            pre.setLong(3, contrato.getCliente_id());
            pre.setDouble(4, contrato.getValor_mensal());
            pre.setDate(5, new java.sql.Date(contrato.getData_inicial().getTime()));
            pre.setDate(6, new java.sql.Date(contrato.getData_final().getTime()));
            pre.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    // TODO
    public List<Contrato> obterTodos(){

        String sql = "select * from contrato";
        List<Contrato> contrat = new ArrayList<>();

        try{
            Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();

            while(rs.next()){
                Contrato contrato = new Contrato();
                contrato.setId(rs.getInt("id"));
                contrato.setImovel_id(rs.getInt("id_imovel"));
                contrato.setCliente_id(rs.getInt("id_cliente"));
                contrato.setValor_mensal(rs.getDouble("valor_mensal"));
                contrato.setData_inicial(rs.getDate("data_inicial"));
                contrato.setData_final(rs.getDate("data_final"));

                contrat.add(contrato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Optional evita ponto nulo
    public Optional<Contrato> obterPeloId(long id){
        String sql = "select id, imovel_id, cliente_id, from contrato where contrato_id = ? ";
        Contrato contrato = null;
        // try-with-resources
        // fecha automaticamente o recurso aberto.
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setLong(1,id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                contrato = new Contrato();
                contrato.setId(rs.getInt("id"));
                contrato.setImovel_id(rs.getInt("imovel_id"));
                contrato.setCliente_id(rs.getInt("cliente_id"));


                return Optional.of(contrato);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

