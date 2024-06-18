package spotiFy.ClientesServ.Main;

package main;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class RegisterController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    public void handleRegister() {
        String email = emailField.getText();
        String password = passwordField.getText();
        UserManager.register(new User(email, password));
        // After registration, go back to login screen
        try {
            Stage stage = (Stage) emailField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
