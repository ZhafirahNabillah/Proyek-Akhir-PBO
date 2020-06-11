package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.*;

import static powerpuffgirls.Utils.Helper.changePage;

public class PsikologLoginController {

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
            changePage(event, "psikolog_saran");
        }
    }
}
