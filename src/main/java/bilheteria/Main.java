package bilheteria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Cadastro.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cadastro de Cliente");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
