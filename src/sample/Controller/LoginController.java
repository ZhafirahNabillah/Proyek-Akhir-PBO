package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    void LogInClick(ActionEvent event) { changePage(event, "Dashboard");

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
