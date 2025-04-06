package bilheteria;

import database.DatabaseConnection;
import java.sql.Connection;

public class DatabaseTest {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.connect()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}
