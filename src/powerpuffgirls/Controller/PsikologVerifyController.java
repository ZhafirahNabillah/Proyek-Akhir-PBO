package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import static powerpuffgirls.Utils.Helper.changePage;

public class PsikologVerifyController {

    @FXML
    private Button btnCurhat;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnLogout;

    @FXML
    void clickCurhat(ActionEvent event) {changePage(event,"psikolog_saran");

    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");

    }

    @FXML
    void clickProfile(ActionEvent event) {changePage(event,"psikolog_profile");

    }

}
