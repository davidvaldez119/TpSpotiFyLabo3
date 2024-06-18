package spotiFy.ClientesServ.Main;
import javafx.application.Application;
import spotiFy.ClientesServ.Cliente;
import spotiFy.ClientesServ.ClienteArchi;
import spotiFy.ClientesServ.ClienteService;

public class Main {
    public static void main(String[] args) {


        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        public class Main extends Application {

            @Override
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
                primaryStage.setTitle("Music Player App");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

    }
}
