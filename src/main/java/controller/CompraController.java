package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Atracao;
import model.Cliente;
import model.Ingresso;
import util.Session;

public class CompraController {
    @FXML
    private ComboBox<Atracao> comboAtracoes;
    @FXML
    private TextField txtQuantidade;

    @FXML
    public void initialize() {
        // Simulação de atrações disponíveis (idealmente viria do banco)
        comboAtracoes.getItems().addAll(
                new Atracao("Show do João", "Palco Principal", 100),
                new Atracao("Teatro", "Auditório", 50)
        );
    }

    @FXML
    private void comprarIngresso() {
        Atracao atracao = comboAtracoes.getValue();
        int quantidade = Integer.parseInt(txtQuantidade.getText());

        Cliente cliente = (Cliente) Session.getUsuario();

        Ingresso ingresso = new Ingresso(atracao, cliente, quantidade);

        System.out.println("Ingresso comprado: " + ingresso);
    }
}
