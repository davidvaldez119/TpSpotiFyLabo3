package spotiFy.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/spotiFy/Main/Resources/login.fxml").openStream());

        Scene scene = new Scene(root, 800, 600);


        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/spotiFy/Main/Resources/logo.ico")));
        primaryStage.setTitle("Spotify Javita");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}