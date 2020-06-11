package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminDashboardController {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnAkun;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnUbah;

    @FXML
    private Button btnVerify;

    @FXML
    private AnchorPane AkunPSikolog;

    @FXML
    private Button btnSimpan;

    @FXML
    private Button btnBatal;

    @FXML
    void clickAkun(ActionEvent event) {
        changePage(event,"admin_DetailAkun");
    }

    @FXML
    void clickUbah(ActionEvent event) {
    }

    @FXML
    void clickAccount(ActionEvent event) { changePage(event, "admin_dashboard");

    }

    @FXML
    void clickPostArticle(ActionEvent event) { changePage(event,"admin_post");

    }

    @FXML
    void clickReport(ActionEvent event) { changePage(event,"admin_report");

    }

    @FXML
    void clickVerify(ActionEvent event){ changePage(event,"admin_verify");
    }

    @FXML
    void clickSimpan(ActionEvent event) {

    }

    @FXML
    void clickBatal(ActionEvent event) {

    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");}

}
