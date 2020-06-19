package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Utils.DBConnection;

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
        DBConnection connec = new DBConnection();
        String id = null;
        String nama = null;
        String usrnm = null;
        String pass = null;
        String mail= null;
        String nohp= null;
        String tgl = null;
        try {
            Psikolog.setUsrname(username.getText());
            PreparedStatement ps = connec.connection().prepareStatement("SELECT * from psikolog where Username='"+username.getText()+"'");
            ResultSet set = ps.executeQuery();
            while (set.next()){
                id = set.getString("IdPsikolog");
                nama=set.getString("NamaLengkap");
                usrnm=set.getString("Username");
                pass=set.getString("Password");
                mail=set.getString("Email");
                nohp=set.getString("NoHp");
                tgl=set.getString("TanggalLahir");
            }
            Psikolog.setIdPsi(id);
            Psikolog.setNamaLengkap(nama);
            Psikolog.setUsrname(usrnm);
            Psikolog.setPass(pass);
            Psikolog.setMail(mail);
            Psikolog.setNoHandphone(nohp);
            Psikolog.setTglLahir(tgl);

            PreparedStatement pre = connec.connection().prepareStatement("SELECT * FROM psikolog where Username=? && Password=? ");
            pre.setString(1,username.getText());
            pre.setString(2,password.getText());
            ResultSet resultSet = pre.executeQuery();

            if (username.getText().equals("")&&password.getText().equals("")){
                Alert a = new Alert(Alert.AlertType.WARNING,"Username dan Password tidak boleh kosong !");
                a.showAndWait();
            } else if (resultSet.next()){
                changePage(event,"psikolog_curhat");
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR,"Maaf Username atau Password salah");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void back(ActionEvent event) { changePage(event,"login");}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
