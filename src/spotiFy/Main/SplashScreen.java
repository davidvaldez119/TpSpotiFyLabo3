package spotiFy.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/splash.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            javafx.application.Platform.runLater(() -> {
                try {
                    Parent mainRoot = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/login.fxml"));
                    Stage mainStage = new Stage();
                    mainStage.setScene(new Scene(mainRoot));
                    mainStage.setTitle("SpotiJava");

                    mainStage.show();
                    primaryStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
