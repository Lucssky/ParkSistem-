package dao;

import database.DatabaseConnection;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    // Autentica cliente pelo nome e email
    public static Cliente autenticar(String nome, String email) {
        String sql = "SELECT * FROM cliente WHERE nome = ? AND email = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone")
                );
                cliente.setId(rs.getInt("id"));
                return cliente;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Verifica se o cliente já está cadastrado pelo nome e email
    public static boolean clienteExiste(String nome, String email) {
        String sql = "SELECT 1 FROM cliente WHERE nome = ? AND email = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true se já existir

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Salva um novo cliente, se não existir
    public static boolean salvar(Cliente cliente) {
        if (clienteExiste(cliente.getNome(), cliente.getEmail())) {
            return false; // já existe, não salva
        }

        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

