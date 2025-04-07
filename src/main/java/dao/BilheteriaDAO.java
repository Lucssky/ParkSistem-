package dao;

import database.DatabaseConnection;
import model.Bilheteria;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BilheteriaDAO {

    public List<Bilheteria> listarBilheterias() {
        List<Bilheteria> bilheterias = new ArrayList<>();
        String sql = "SELECT * FROM atracao";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                double preco = 20.00; // Valor fixo por agora, já que a tabela atracao não tem preço
                int quantidade = rs.getInt("capacidade");
                LocalTime fechamento = rs.getTime("horario_fim").toLocalTime();

                bilheterias.add(new Bilheteria(nome, preco, quantidade, fechamento));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bilheterias;
    }

    public void atualizarQuantidade(String nomeAtracao, int novaQuantidade) {
        String sql = "UPDATE atracao SET capacidade = ? WHERE nome = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setString(2, nomeAtracao);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
