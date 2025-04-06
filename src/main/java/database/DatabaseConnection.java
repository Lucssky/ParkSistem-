package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/Parque_De_Diversoes";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Carrega o driver manualmente
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do PostgreSQL não encontrado!", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
