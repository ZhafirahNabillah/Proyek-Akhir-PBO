package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import powerpuffgirls.Models.Admin;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;

import javax.swing.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminLoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;


    @FXML
    private Button btnback;


    @FXML
    void LogInClick(ActionEvent event) {
        DBConnection connec  = new DBConnection();
        String id1=null;
        try {
            Admin.setUsrnm(username.getText());
            PreparedStatement ps = connec.connection().prepareStatement("Select * from admin where Username ='"+username.getText()+"'");
            ResultSet st =ps.executeQuery();
            while (st.next()){
                id1= st.getString("IdAdmin");
            }
            Admin.setIdAdmin(id1);

            PreparedStatement pre = connec.connection().prepareStatement("SELECT * FROM admin where Username=? and Password=?");
            pre.setString(1, username.getText());
            pre.setString(2, password.getText());
            ResultSet result = pre.executeQuery();


            if (username.getText().equals("") && password.getText().equals("")) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Username dan Password yang anda masukkan tidak lengkap");
                a.showAndWait();
            } else if (result.next()){
                changePage(event,"admin_Dashboard");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Maaf Username Password salah");
                alert.showAndWait();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) {changePage(event,"login"); }
}


