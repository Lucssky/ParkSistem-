package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Cliente;
import util.Session;

public class CadastroController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSenha;

    @FXML
    private void cadastrar(ActionEvent event) {
        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Preencha todos os campos!").show();
            return;
        }

        Cliente cliente = new Cliente(nome, email, senha);
        Session.setUsuario(cliente);

        new Alert(Alert.AlertType.INFORMATION, "Cadastro realizado com sucesso!").show();

        // Redireciona para a tela principal
        Session.changeSceneFromButton(event, "main.fxml");
    }

    @FXML
    private void voltarLogin(ActionEvent event) {
        Session.changeSceneFromButton(event, "Login.fxml");
    }
}
