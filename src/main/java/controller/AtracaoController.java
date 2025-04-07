package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Atracao;
import util.Session;
import dao.AtracaoDAO;

import java.util.List;

public class AtracaoController {

    @FXML
    public ScrollPane scrollPane;
    @FXML
    private VBox vboxAtracoes;

    @FXML
    private Button btnVoltar;

    @FXML
    public void initialize() {
        carregarAtracoes();
    }

    private void carregarAtracoes() {
        AtracaoDAO dao = new AtracaoDAO();
        List<Atracao> atracoes = dao.listarAtracoes();

        vboxAtracoes.getChildren().clear();

        for (Atracao atracao : atracoes) {
            VBox card = new VBox();
            card.setStyle("""
            -fx-background-color: linear-gradient(to bottom right, #ffffff, #a6a6a6);
            -fx-border-color: #d0d0d0;
            -fx-border-radius: 10;
            -fx-background-radius: 10;
            -fx-padding: 15;
            -fx-spacing: 8;
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 2, 2);
            """);

            Label nome = new Label("Nome: " + atracao.getNome());
            nome.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

            Label descricao = new Label("Descrição: " + atracao.getDescricao());
            descricao.setStyle("-fx-font-size: 14px;");

            Label preco = new Label("Preço: R$ " + String.format("%.2f", atracao.getPreco()));
            preco.setStyle("-fx-font-size: 14px; -fx-text-fill: #2b9348;");

            Label horario = new Label("Horário: " + atracao.getHorarioInicio() + " até " + atracao.getHorarioFim());
            horario.setStyle("-fx-font-size: 14px;");

            Label capacidade = new Label("Capacidade: " + atracao.getCapacidade() + " pessoas");
            capacidade.setStyle("-fx-font-size: 14px;");

            card.getChildren().addAll(nome, descricao, preco, horario, capacidade);
            vboxAtracoes.getChildren().add(card);
        }
    }

    @FXML
    private void voltar() {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        Session.changeScene(stage, "Main.fxml");
    }
}



