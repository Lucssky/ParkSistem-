package controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Session;

public class MainController {

    @FXML private VBox root;
    @FXML private Button btnCompraIngresso;
    @FXML private Button btnAtracoes;
    @FXML private Button btnLogout;
    @FXML private Button btnVerBilheterias;


    @FXML
    public void initialize() {
        FadeTransition fade = new FadeTransition(Duration.seconds(1), root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void irParaCompra() {
        Stage stage = (Stage) btnCompraIngresso.getScene().getWindow();
        Session.changeScene(stage, "Compra.fxml");
    }

    @FXML
    private void irParaAtracoes() {
        Stage stage = (Stage) btnAtracoes.getScene().getWindow();
        Session.changeScene(stage, "Atracao.fxml");
    }

    @FXML
    private void logout() {
        Session.setUsuario(null);
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        Session.changeScene(stage, "Login.fxml");
    }

    @FXML
    private void irParaBilheterias() {
        Stage stage = (Stage) btnVerBilheterias.getScene().getWindow();
        Session.changeScene(stage, "Billheteria.fxml");
    }
}
