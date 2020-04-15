package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Login {

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
//       (pakek helper) main.Helper.changePage(event, "dashboard");
    }

    @FXML
    void RegisterClick(ActionEvent event) {
//        main.Helper.changePage(event, "register");

    }

    @FXML
    void clickBtnAdmin(ActionEvent event) {

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {

    }

    public void LogInClick(javafx.event.ActionEvent event) {ShowDashboard();

    }

    public void RegisterClick(javafx.event.ActionEvent event) {ShowRegister();
    }

    public void clickBtnAdmin(javafx.event.ActionEvent event) {ShowDashboardAdmin();
    }

    public void clickBtnPsikolog(javafx.event.ActionEvent event) {
    }
    void ShowDashboard(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/dashboard.fxml"));
            Parent root = loader.load();

            Dashboard dashboard = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    void ShowRegister(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/register.fxml"));
            Parent root = loader.load();

            Register register = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    void ShowDashboardAdmin(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/admin_Dashboard.fxml"));
            Parent root = loader.load();

            Admin_Dashboard admin_dashboard = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
