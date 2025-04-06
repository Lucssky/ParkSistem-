package controller;

import dao.UsuarioDAO;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Cliente;
import util.Session;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private VBox root;

    @FXML
    public void initialize() {
        FadeTransition fade = new FadeTransition(Duration.seconds(1), root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    public void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Cliente cliente = UsuarioDAO.autenticar(username, password);

        if (username.equals("admin") && password.equals("1234")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Login realizado com sucesso!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Usuário ou senha incorretos!");
            alert.showAndWait();
        }

    }
}



