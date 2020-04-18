package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

import static sample.Main.Helper.changePage;

public class AdminLoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void LogInClick(ActionEvent event) {
        if (username.getText().equals("") && password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "username dan password kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            changePage(event, "admin_Dashboard");
        }
    }
}


