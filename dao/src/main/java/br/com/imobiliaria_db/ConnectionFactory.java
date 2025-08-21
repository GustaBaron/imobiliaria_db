package br.com.imobiliaria_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //Singleton -> garante que tenha apenas um objeto global
    // da classe
    // static -> altera para o escopo de classe.
    private static ConnectionFactory instance;

    private ConnectionFactory(){}

    public static ConnectionFactory getInstance(){
        if(instance == null) instance = new ConnectionFactory();
        return instance;
    }

    // Method Factory
    public Connection get() throws SQLException {
        // Não deixem fixos os parâmetros em um produto
        // de produção
        String url = "jdbc:mysql://localhost:3306/imobiliaria_db";
        String user = "root";
        String password = "34372704";
        return DriverManager.getConnection(url,user,password);
    }
}
