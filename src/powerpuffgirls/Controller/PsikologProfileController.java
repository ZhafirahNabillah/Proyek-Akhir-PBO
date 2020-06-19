package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Psikolog;

import java.net.URL;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;


public class PsikologProfileController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnProfile;

    @FXML
    private Text nama;

    @FXML
    private Text username;

    @FXML
    private Text pass;

    @FXML
    private Text tanggal;

    @FXML
    private Text noHP;

    @FXML
    private Text email;


    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event,"psikolog_curhat");

    }

    @FXML
    void clickBtnProfile(ActionEvent event) {changePage(event,"psikolog_profile");

    }

    @FXML
    void clickLogout(ActionEvent event){
        changePage(event,"login");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nama.setText(Psikolog.getNamaLengkap());
        username.setText(Psikolog.getUsrname());
        pass.setText(Psikolog.getPass());
        email.setText(Psikolog.getMail());
        noHP.setText(Psikolog.getNoHandphone());
        tanggal.setText(Psikolog.getTglLahir());
    }
}
