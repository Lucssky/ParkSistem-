package dao;

import database.DatabaseConnection;
import model.Cliente;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public static boolean autenticar(Usuario usuario) {
        String sql = "SELECT * FROM cliente WHERE nome = ? AND senha = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Cliente autenticar(String username, String password) {
        return null;
    }
}
