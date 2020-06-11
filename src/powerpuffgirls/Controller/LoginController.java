package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import powerpuffgirls.Utils.DBConnection;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

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
        if (txtusername.getText().equals("")&&txtpassword.getText().equals("")){
            JOptionPane.showMessageDialog(null,"username dan password tidak terisi", "Peringatan",JOptionPane.WARNING_MESSAGE);
        }else {
            changePage(event,"Dashboard");

//            JOptionPane.showMessageDialog (null, "Isi terlebih dahulu", "PERINGATAN", JOptionPane.INFORMATION_MESSAGE);
//            JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.WARNING_MESSAGE);
//            JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.ERROR_MESSAGE);
        }

        String username= txtusername.getText();
        String password=txtpassword.getText();


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

    @FXML
    void SignIn(MouseEvent event) {
    }

    @FXML
    void SignUp(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
