package controller;

import dao.UsuarioDAO;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Cliente;
import java.net.URL;


public class CadastroController {

    @FXML private TextField txtNome;
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtTelefone;
    @FXML private StackPane root;

    @FXML
    public void initialize() {
        FadeTransition fade = new FadeTransition(Duration.seconds(1), root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    public void cadastrar() {
        String nome = txtNome.getText().trim();
        String email = txtEmail.getText().trim();
        String senha = txtTelefone.getText().trim();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Preencha todos os campos!");
            return;
        }

        Cliente novoCliente = new Cliente(nome, email, senha);
        boolean sucesso = UsuarioDAO.salvar(novoCliente);

        if (sucesso) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Cadastro realizado com sucesso!");
            limparCampos();
            voltarLogin();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro ao cadastrar. Tente novamente.");
        }
    }

    @FXML
    public void voltarLogin() {
        try {
            URL fxml = getClass().getResource("/fxml/Login.fxml");
            System.out.println("🔍 Caminho encontrado: " + fxml);

            if (fxml == null) {
                throw new RuntimeException("Login.fxml não encontrado no classpath!");
            }

            Parent login = FXMLLoader.load(fxml);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.setTitle("Login");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Não foi possível carregar a tela de login.");
        }
    }
    private void mostrarAlerta(Alert.AlertType tipo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void limparCampos() {
        txtNome.clear();
        txtEmail.clear();
        txtTelefone.clear();
    }
}
