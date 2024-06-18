package spotiFy.Main;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import spotiFy.ClientesServ.ClienteService;
import spotiFy.ClientesServ.Cliente;
import spotiFy.ClientesServ.ClienteArchi;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    private ClienteService clienteService;

    public LoginController() {
        ClienteArchi clienteArchi = new ClienteArchi("clientes.txt");
        this.clienteService = new ClienteService(clienteArchi);
    }

    public void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        Cliente cliente = clienteService.listarClientes().stream()
                .filter(c -> c.getCorreo().equals(email) && c.getContrasena().equals(password))
                .findFirst()
                .orElse(null);

        if (cliente != null) {
            // Load the music player scene
            try {
                Stage stage = (Stage) emailField.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/musicplayer.fxml"));
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login failed");
        }
    }

    public void handleRegister() {
        try {
            Stage stage = (Stage) emailField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/register.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
