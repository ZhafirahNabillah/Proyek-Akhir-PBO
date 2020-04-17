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
    void clickBtnAdmin(ActionEvent event)  { changePage(event, "AdminDashboard2");

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) { changePage(event, "");

    }

//    void ShowDashboard(){
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/dashboard.fxml"));
//            Parent root = loader.load();
//
//            Dashboard dashboard = loader.getController();
//
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        }catch (Exception e){
//            System.err.println(e);
//        }
//    }
//    void ShowRegister(){
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/register.fxml"));
//            Parent root = loader.load();
//
//            Register register = loader.getController();
//
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        }catch (Exception e){
//            System.err.println(e);
//        }
//    }
//    void ShowDashboardAdmin(){
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/AdminDashboard.fxml"));
//            Parent root = loader.load();
//
//            Admin_Dashboard admin_dashboard = loader.getController();
//
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        }catch (Exception e){
//            System.err.println(e);
//        }
//    }
}
