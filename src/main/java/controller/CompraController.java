package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Atracao;
import model.Cliente;
import model.Ingresso;
import util.Session;
import dao.AtracaoDAO;

public class CompraController {

    @FXML
    private ComboBox<Atracao> comboAtracoes;

    @FXML
    private TextField nomeClienteField;

    @FXML
    private TextField quantidadeField;

    @FXML
    private VBox atracaoInfoBox; // VBox para mostrar info extra da atração

    @FXML
    private ComboBox<String> comboPagamento;

    @FXML
    public void initialize() {
        AtracaoDAO atracaoDAO = new AtracaoDAO();
        comboAtracoes.getItems().addAll(atracaoDAO.listarAtracoes());
        comboPagamento.getItems().addAll("Pix", "Crédito", "Débito", "Dinheiro");
    }

    @FXML
    private void confirmarCompra() {
        String nomeCliente = nomeClienteField.getText();
        String quantidadeStr = quantidadeField.getText();
        Atracao atracao = comboAtracoes.getValue();

        if (nomeCliente.isEmpty() || quantidadeStr.isEmpty() || atracao == null) {
            mostrarAlerta("Preencha todos os campos.");
            return;
        }

        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("Quantidade inválida.");
            return;
        }

        Cliente cliente = new Cliente(nomeCliente, "email@exemplo.com", "senha123");
        Session.setCliente(cliente);

        Ingresso ingresso = new Ingresso(atracao, cliente, quantidade);

        System.out.println("Ingresso comprado: " + ingresso);
        mostrarAlerta("Ingresso comprado com sucesso!");
    }

    @FXML
    private void voltar() {
        Stage stage = (Stage) comboAtracoes.getScene().getWindow();
        Session.changeScene(stage, "Main.fxml"); // garante o caminho certo
    }

    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensagem");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void atualizarInfoAtracao(Atracao atracao) {
        atracaoInfoBox.getChildren().clear();
        if (atracao != null) {
            Label nome = new Label("Nome: " + atracao.getNome());
            Label local = new Label("Local: " + atracao.getDescricao());


            atracaoInfoBox.getChildren().addAll(nome, local);
        }
    }
}
