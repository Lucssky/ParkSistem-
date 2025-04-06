package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Atracao;
import util.Session;

public class AtracaoController {
    @FXML
    private TableView<Atracao> tableAtracoes;
    @FXML
    private TableColumn<Atracao, String> colNome;
    @FXML
    private TableColumn<Atracao, String> colDescricao;
    @FXML
    private Button btnVoltar;

    @FXML
    private void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableAtracoes.getItems().addAll(Session.getAtracoes()); // lista fictícia por enquanto
    }

    @FXML
    private void voltar() {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        Session.changeScene(stage, "Main.fxml");
    }
}


