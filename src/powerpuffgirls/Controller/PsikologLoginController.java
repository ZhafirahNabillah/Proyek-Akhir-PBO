package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Models.User1;
import powerpuffgirls.Utils.DBConnection;

import javax.swing.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PsikologLoginController implements Initializable {

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
        String temp =null;
        String tampung=null;
        try {
            Psikolog.setUsrname(username.getText());
            PreparedStatement ps = connec.connection().prepareStatement("Select NamaLengkap from psikolog where Username ='"+username.getText()+"'");
            ResultSet st =ps.executeQuery();
            while (st.next()){
                temp=st.getString( "NamaLengkap");
                tampung=st.getString("NoHP");
            }
            Psikolog.setNamaLengkap(temp);
            Psikolog.setNoHandphone(tampung);

            PreparedStatement pre = connec.connection().prepareStatement("SELECT * FROM psikolog where Username=? and Password=?");
            pre.setString(1, username.getText());
            pre.setString(2, password.getText());
            ResultSet result = pre.executeQuery();

            if (username.getText().equals("") && password.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "username dan password kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
                Alert a = new Alert(Alert.AlertType.WARNING, "Username dan Password yang anda masukkan tidak lengkap");
                a.showAndWait();
            } else if (result.next()){
                changePage(event,"psikolog_saran");
            } else {
//                JOptionPane.showMessageDialog(null, "username atau password salah", "Error", JOptionPane.ERROR_MESSAGE);
                Alert alert = new Alert(Alert.AlertType.ERROR,"Maaf Username atau Password salah");
                alert.showAndWait();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void back(ActionEvent event) { changePage(event,"login");}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
