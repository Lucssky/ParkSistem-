package dao;

import database.DatabaseConnection;
import model.Atracao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtracaoDAO {

    public static List<Atracao> listarAtracoes() {
        List<Atracao> atracoes = new ArrayList<>();
        String sql = "SELECT nome, descricao, horario_inicio, horario_fim, capacidade FROM atracao";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String horarioInicio = rs.getString("horario_inicio");
                String horarioFim = rs.getString("horario_fim");
                String capacidade = rs.getString("capacidade");

                Atracao atracao = new Atracao(nome, descricao, horarioInicio, horarioFim, capacidade);
                atracoes.add(atracao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atracoes;
    }
}
