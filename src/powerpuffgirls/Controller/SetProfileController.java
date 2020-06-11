package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import static powerpuffgirls.Utils.Helper.changePage;

public class SetProfileController {

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
    private Button btnBatal;

    @FXML
    private Button btnSimpan1;

    @FXML
    void clickBtnBatal(ActionEvent event) {

    }

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event,"Dashboard");

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
    void clickBtnSimpan(ActionEvent event) {

    }

    @FXML
    void clickLogout(ActionEvent event) { changePage(event,"login");

    }

}
