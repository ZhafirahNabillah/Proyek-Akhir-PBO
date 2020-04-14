package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Register {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnLogin;

    @FXML
    void LogInClick(ActionEvent event) {

    }

    @FXML
    void RegisterClick(ActionEvent event) {

    }

    void ShowLogin(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/login.fxml"));
            Parent root = loader.load();

            Login login = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    public void RegisterClick(javafx.event.ActionEvent event) {
       ShowLogin();
    }

    public void LogInClick(javafx.event.ActionEvent event) {
        ShowLogin();
    }

}
