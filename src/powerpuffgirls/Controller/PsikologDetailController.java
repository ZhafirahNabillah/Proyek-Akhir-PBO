package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import static powerpuffgirls.Utils.Helper.changePage;

public class PsikologDetailController {

    @FXML
    private Button btnCurhat;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnSend;

    @FXML
    void clickCurhat(ActionEvent event) { changePage(event,"psikolog_saran");

    }

    @FXML
    void clickProfile(ActionEvent event) {changePage(event,"psikolog_profile");

    }

    @FXML
    void clickSend(ActionEvent event) {changePage(event,"psikolog_saran");

    }

}
