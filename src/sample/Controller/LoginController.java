package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

import static sample.Main.Helper.changePage;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label account;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnPsikolog;

    @FXML
    void LogInClick(ActionEvent event) {
        if (username.getText().equals("user")&&password.getText().equals("user")){
            changePage(event,"Dashboard");
        }else {
            JOptionPane.showMessageDialog (null, "username dan password salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
//            JOptionPane.showMessageDialog (null, "Isi terlebih dahulu", "PERINGATAN", JOptionPane.INFORMATION_MESSAGE);
//            JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.WARNING_MESSAGE);
//            JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void RegisterClick(ActionEvent event) { changePage(event, "Register");
    }

    @FXML
    void clickBtnAdmin(ActionEvent event)  { changePage(event, "admin_login");

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) { changePage(event, "psikolog_login");

    }
}
