package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static sample.Main.Helper.changePage;


public class Register {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnLogin;

    @FXML
    void LogInClick(ActionEvent event) {
        changePage(event, "login");
    }

    @FXML
    void RegisterClick(ActionEvent event) {
        changePage(event, "login");
    }

}
