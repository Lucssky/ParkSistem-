package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.Session;

public class MainController {
    public Button btnCompraIngresso;
    public Button btnAtracoes;
    public Button btnLogout;


    @FXML
    private void irParaCompra() {
        Stage stage = (Stage) btnCompraIngresso.getScene().getWindow();
        Session.changeScene(stage, "compraIngresso.fxml");
    }

    @FXML
    private void irParaAtracoes() {
        Stage stage = (Stage) btnAtracoes.getScene().getWindow();
        Session.changeScene(stage, "atracao.fxml");
    }

    @FXML
    private void logout() {
        Session.setUsuario(null);
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        Session.changeScene(stage, "Login.fxml");
    }

}

