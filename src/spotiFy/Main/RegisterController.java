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

public class RegisterController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;

    private ClienteService clienteService;

    public RegisterController() {
        ClienteArchi clienteArchi = new ClienteArchi("clientes.txt");
        this.clienteService = new ClienteService(clienteArchi);
    }

    public void handleRegister() {

        String email = emailField.getText();
        String name = nameField.getText();
        String password = passwordField.getText();
        int newId = clienteService.listarClientes().size() + 1;
        Cliente cliente = new Cliente(newId, name, email, password);
        clienteService.registrarCliente(cliente);

        try {
            Stage stage = (Stage) emailField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/login.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleBack() {
        try {
            Stage stage = (Stage) emailField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/spotiFy/Main/Resources/login.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
