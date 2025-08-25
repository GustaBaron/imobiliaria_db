package imobiliaria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/ImobDataBase";
    private static final String USER = "root";
    private static final String PASSWORD = "senha20013"; // ajuste se necessário

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
