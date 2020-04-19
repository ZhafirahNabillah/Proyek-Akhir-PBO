package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static sample.Main.Helper.changePage;


public class PsikologProfileController {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnProfile;

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event,"psikolog_saran");

    }

    @FXML
    void clickBtnProfile(ActionEvent event) {changePage(event,"psikolog_profile");

    }

    @FXML
    void clickLogout(ActionEvent event){
        changePage(event,"login");
    }

}
