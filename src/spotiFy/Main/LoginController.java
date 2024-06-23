package spotiFy.Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import spotiFy.ClientesServ.ClienteService;
import spotiFy.ClientesServ.Cliente;
import spotiFy.ClientesServ.ClienteArchi;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private TextField cajaMail;
    @FXML
    private PasswordField cajaClave;


    private ClienteService clienteService;


    public LoginController() {
        ClienteArchi clienteArchi = new ClienteArchi("clientes.txt");
        this.clienteService = new ClienteService(clienteArchi);
    }

    public void handleLogin() {
        String email = cajaMail.getText();
        String contrasena = cajaClave.getText();
        Cliente cliente = clienteService.listarClientes().stream()
                .filter(c -> c.getCorreo().equals(email) && c.getContrasena().equals(contrasena))
                .findFirst()
                .orElse(null);

        if (cliente != null) {
            // Load the music player scene
            try {
                Stage escena = (Stage) cajaMail.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/musicplayer.fxml"));
                escena.setScene(new Scene(root));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error al iniciar sesion");
        }
    }

    public void handleRegister() {
        try {
            Stage escena = (Stage) cajaMail.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/register.fxml"));
            escena.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
