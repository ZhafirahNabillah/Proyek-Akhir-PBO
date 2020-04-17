package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static sample.Main.Helper.changePage;

public class PsikologSaranController {

    @FXML
    private Button btnCurhat;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnDetail;

    @FXML
    private Button btnVerify;

    @FXML
    void clickCurhat(ActionEvent event) {changePage(event,"psikolog_saran");

    }

    @FXML
    void clickDetail(ActionEvent event) {changePage(event,"psikolog_detail");

    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");

    }

    @FXML
    void clickProfile(ActionEvent event) {changePage(event,"psikolog_profile");

    }

    @FXML
    void clickVerify(ActionEvent event) {changePage(event,"");

    }

}
