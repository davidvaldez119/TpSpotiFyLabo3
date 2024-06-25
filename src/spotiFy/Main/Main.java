package spotiFy.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga de login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/spotiFy/Main/Resources/login.fxml"));
        Parent root = loader.load();

        // Crear escena de 800x600
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Spotify Javita");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}