package br.com.imobiliaria_db;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO extends BaseDAO {
    public void deletarPeloId(long id){
        String sql = "delete from pessoa where id_pessoa = ? ";
        // try-with-resources
        // fecha automaticamente o recurso aberto.
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setLong(1,id);
            pre.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // TODO
    public void inserir(Cliente cliente){
        String sql = "insert into cliente (id,nome,cpf,telefone, email ) values (?,?)";

        try{
            Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);

            pre.setInt(1, cliente.getId());
            pre.setString(2, cliente.getNome());
            pre.setString(3, cliente.getCpf());
            pre.setString(4, cliente.getTelefone());
            pre.setString(5, cliente.getEmail());

            pre.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    // TODO
    public List<Cliente> obterTodos(){

        String sql = "select * from cliente";
        List<Cliente> client = new ArrayList<>();

        try{
            Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();

            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));

                client.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Optional evita ponto nulo
    public Optional<Cliente> obterPeloId(long id){
        String sql = "select id_pessoa, nome, cpf from pessoa where id_pessoa = ? ";
        Cliente cliente = null;
        // try-with-resources
        // fecha automaticamente o recurso aberto.
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)){
            pre.setLong(1,id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome("nome");
                cliente.setCpf("cpf");
                cliente.setTelefone("telefone");
                cliente.setEmail("email");

                return Optional.of(cliente);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
