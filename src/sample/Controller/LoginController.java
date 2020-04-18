package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private CheckBox checkBox;

    @FXML
    void LogInClick(ActionEvent event) {
        if (username.getText().equals("")&&password.getText().equals("")){
            JOptionPane.showMessageDialog(null,"username dan password kosong", "Peringatan",JOptionPane.WARNING_MESSAGE);
        }else {
            changePage(event,"Dashboard");

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
