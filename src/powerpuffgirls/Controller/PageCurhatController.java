package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Utils.DBConnection;

import javax.swing.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PageCurhatController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnSend;

    @FXML
    private Text namaPsi;

    @FXML
    private Text noHP;

    @FXML
    private TextField nama;

    @FXML
    private Button kirim;

    @FXML
    private TextField usia;

    @FXML
    private DatePicker tgl;

    @FXML
    private TextArea isiCurhat;

    @FXML
    private Button batal;


    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event, "Dashboard");

    }

    @FXML
    void clickBtnPost(ActionEvent event) {changePage(event, "page_post");

    }

    @FXML
    void clickBtnProfile(ActionEvent event) {changePage(event, "page_profile");

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {
        changePage(event, "page_curhat");
    }


    @FXML
    void klikBatal(ActionEvent event) {

    }

    @FXML
    void klikKirim(ActionEvent event) {

    }

    @FXML
    void clickLogout(ActionEvent event) {
        changePage(event,"login");
    }

    private void Psi(){
        DBConnection connec = new DBConnection();
        String name = null;
        String nohp= null;
        try {
            PreparedStatement pre = connec.connection().prepareStatement("SELECT * FROM psikolog where IdPsikolog=1");
            ResultSet rt = pre.executeQuery();
            while (rt.next()){
                name= rt.getString("NamaLengkap");
                nohp=rt.getString("NoHp");
            }
            namaPsi.setText(name);
            noHP.setText(nohp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Psi();
    }
}
