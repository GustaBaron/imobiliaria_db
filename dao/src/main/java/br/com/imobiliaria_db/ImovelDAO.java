package br.com.imobiliaria_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImovelDAO extends BaseDAO {
    public void deletarPeloId(long id) {
        String sql = "delete from pessoa where id_Imovel = ? ";
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

    public void inserir(Imovel imovel) {
        String sql = "insert into imovel (id,endereco, tipo, quartos, banheiros, area_m2, preco_base, status ) values (?,?)";

        try {
            Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setLong(1, imovel.getId());
            pre.setString(2, imovel.getEndereco());
            pre.setString(3, imovel.getTipo());
            pre.setString(4, imovel.getQuartos());
            pre.setString(5, imovel.getBanheiro());
            pre.setString(6, imovel.getArea_m2());
            pre.setString(7, imovel.getPreco_base());
            pre.setInt(8, imovel.getStatus().ordinal());

            pre.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public Optional<Imovel> obterPeloId(long id){
        String sql = "select id_Imovel, endereco, from pessoa where id_Imovel = ? ";
        Imovel imovel = null;
        // try-with-resources
        // fecha automaticamente o recurso aberto.
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setLong(1,id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                imovel = new Imovel();
                imovel.setId(rs.getInt("id"));
                imovel.setEndereco("endereco");


                return Optional.of(imovel);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

