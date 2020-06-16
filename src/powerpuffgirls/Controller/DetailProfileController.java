package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import powerpuffgirls.Models.User;

import java.net.URL;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;


public class DetailProfileController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnLogOut;

    @FXML
    private Text txt_Name;

    @FXML
    private Text txt_Username;

    @FXML
    private TextField nama;

    @FXML
    private TextField tanggal;

    @FXML
    private TextField noHP;

    @FXML
    private TextField email;

    @FXML
    private TextField usrname;

    @FXML
    private TextField pass;

    @FXML
    private Button simpan;

    @FXML
    private Button hapus;

    @FXML
    private Button reset;

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
    void clickBtnPsikolog(ActionEvent event) {changePage(event, "page_curhat");

    }

    @FXML
    void clickHapus(ActionEvent event) {

    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");

    }

    @FXML
    void clickReset(ActionEvent event) {

    }

    @FXML
    void clickSimpan(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_Name.setText(User.getNamalengkap());
        txt_Username.setText(User.getUsrname());
        nama.setText(User.getNamalengkap());
        usrname.setText(User.getUsrname());
        pass.setText(User.getPasswrd());
        email.setText(User.getMail());
        noHP.setText(User.getNoHP());
        tanggal.setText(User.getTgllahir());
    }
}
