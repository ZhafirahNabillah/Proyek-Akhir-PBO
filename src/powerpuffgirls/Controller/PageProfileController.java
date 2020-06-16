package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import powerpuffgirls.Models.User;

import java.net.URL;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PageProfileController implements Initializable {

    @FXML
    private AnchorPane profile;

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
    private Button btnDetail;

    @FXML
    private TableView<?> tblpostingan;

    @FXML
    private TableColumn<?, ?> idpost;

    @FXML
    private TableColumn<?, ?> namapost;

    @FXML
    private TableColumn<?, ?> usrnamepost;

    @FXML
    private TableColumn<?, ?> tglpost;

    @FXML
    private Text namadetail;

    @FXML
    private Text usrnmdetail;

    @FXML
    private DatePicker tgldetail;

    @FXML
    private TextArea isidetail;

    @FXML
    private Text status;

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event, "Dashboard");

    }

    @FXML
    void clickBtnNext(ActionEvent event) {changePage(event, "btn_next");

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
    void clickBtnDetail(ActionEvent event) {changePage(event, "detail_profile");

    }

    @FXML
    void clickLogout(ActionEvent event) { changePage(event,"login");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_Name.setText(User.getNamalengkap());
        txt_Username.setText(User.getUsrname());
    }
}
