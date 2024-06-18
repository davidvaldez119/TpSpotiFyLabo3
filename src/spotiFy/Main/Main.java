package spotiFy.Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/spotiFy/Main/Resources/login.fxml").openStream());

        // Crear la escena
        Scene scene = new Scene(root, 800, 600);

        // Configurar el escenario principal
        primaryStage.setTitle("Spotify Javita");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}






