package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import static sample.Main.Helper.changePage;


public class DetailProfileController {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Text txt_Name;

    @FXML
    private Text txt_Username;

    @FXML
    private Button btnName;

    @FXML
    private Button btnBirth;

    @FXML
    private Button btnHandphone;

    @FXML
    private Button btnEmail;

    @FXML
    private Button btnUsername;

    @FXML
    private Button btnPassword;

    @FXML
    private Button btnDetail;

    @FXML
    private Button btnChangephoto;

    @FXML
    private Button btnLogOut;

    @FXML
    void clickBtnBirth(ActionEvent event) {

    }

    @FXML
    void clickBtnChangephoto(ActionEvent event) {

    }

    @FXML
    void clickBtnEmail(ActionEvent event) {

    }

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event, "Dashboard");

    }

    @FXML
    void clickBtnName(ActionEvent event) {

    }

    @FXML
    void clickBtnPassword(ActionEvent event) {

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
    void clickBtnDetail(ActionEvent event) {changePage(event, "detail_Profile");

    }
    @FXML
    void clickBtnHandphone(ActionEvent event) {

    }
    @FXML
    void clickBtnUsername(ActionEvent event) {

    }
    @FXML
    void clickLogout(ActionEvent event){
        changePage(event, "login");
    }
}
