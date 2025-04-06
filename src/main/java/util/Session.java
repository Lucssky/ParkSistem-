package util;

import model.Atracao;
import model.Cliente;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public static void changeScene(Stage stage, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(Session.class.getResource("/" + fxmlFile));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Novo método utilitário para trocar de cena diretamente de um botão
    public static void changeSceneFromButton(javafx.event.ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(Session.class.getResource("/" + fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
