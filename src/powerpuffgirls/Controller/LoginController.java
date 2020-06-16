package powerpuffgirls.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;
import java.net.URL;
import java.sql.*;
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
        DBConnection connec  = new DBConnection();
        String nama = null;
        String usr = null;
        String pass = null;
        String email = null;
        String nohp = null;
        String tgl = null;
        try {
            User.setUsrname(txtusername.getText());
            PreparedStatement ps = connec.connection().prepareStatement("Select * from user where Username ='"+txtusername.getText()+"'");
            ResultSet st =ps.executeQuery();
            while (st.next()){
                nama=st.getString( "NamaLengkap");
                usr=st.getString("Username");
                pass=st.getString("Password");
                email=st.getString("Email");
                nohp=st.getString("NoHP");
                tgl=st.getString("TanggalLahir");
            }
            User.setNamalengkap(nama);
            User.setUsrname(usr);
            User.setPasswrd(pass);
            User.setMail(email);
            User.setNoHP(nohp);
            User.setTgllahir(tgl);

            PreparedStatement pre = connec.connection().prepareStatement("SELECT * FROM user where Username=? and Password=?");
            pre.setString(1, txtusername.getText());
            pre.setString(2, txtpassword.getText());
            ResultSet result = pre.executeQuery();


            if (txtusername.getText().equals("") && txtpassword.getText().equals("")) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Username dan Password yang anda masukkan tidak lengkap");
                a.showAndWait();
            } else if (result.next()){
                changePage(event,"Dashboard");
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Maaf Username Password salah");
                alert.showAndWait();
            }
        }catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
