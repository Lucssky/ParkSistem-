package controller;

import dao.UsuarioDAO;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Cliente;
import util.Session;

import java.io.IOException;

public class LoginController {

    @FXML private TextField nomeField;
    @FXML private TextField emailField;
    @FXML private StackPane root;

    @FXML
    public void initialize() {
        FadeTransition fade = new FadeTransition(Duration.seconds(1), root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    public void handleLogin(ActionEvent event) throws IOException {
        String nome = nomeField.getText();
        String email = emailField.getText();

        // Verifica se os campos estão preenchidos
        if (nome.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha o nome e o e-mail!");
            alert.showAndWait();
            return;
        }

        // Cria o cliente com os dados inseridos
        Cliente cliente = new Cliente(nome, email, "");

        // Define na sessão
        Session.setUsuario(cliente);

        // Alerta de sucesso
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login");
        alert.setHeaderText(null);
        alert.setContentText("Login realizado com sucesso!");
        alert.showAndWait();

        // Abre a tela principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        Parent mainRoot = loader.load();
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(mainRoot));
        stage.show();
    }
}

