package util;

import model.Atracao;
import model.Cliente;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private static Cliente clienteAtual;
    private static Cliente usuario;
    private static List<Atracao> atracoes = new ArrayList<>();

    public static Cliente getCliente() {
        return clienteAtual;
    }

    public static void setCliente(Cliente cliente) {
        clienteAtual = cliente;
    }

    public static Cliente getUsuario() {
        return usuario;
    }

    public static void setUsuario(Cliente u) {
        usuario = u;
    }

    public static List<Atracao> getAtracoes() {
        return atracoes;
    }

    public static void addAtracao(Atracao atracao) {
        atracoes.add(atracao);
    }

    // Troca de cena usando Stage direto
    public static void changeScene(Stage stage, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(Session.class.getResource("/fxml/" + fxmlFile));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo FXML: /fxml/" + fxmlFile);
            e.printStackTrace();
        }
    }

    // Troca de cena usando evento (ex: clique de botão)
    public static void changeSceneFromButton(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(Session.class.getResource("/fxml/" + fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo FXML: /fxml/" + fxmlFile);
            e.printStackTrace();
        }
    }
}

