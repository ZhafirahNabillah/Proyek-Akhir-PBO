package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static sample.Main.Helper.changePage;

public class AdminDashboardController {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnAkun1;

    @FXML
    private Button btnAkun2;

    @FXML
    private Button btnAkun3;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnUbah;

    @FXML
    void clickAkun1(ActionEvent event) {
        changePage(event,"admin_DetailAktivitas");
    }

    @FXML
    void clickAkun2(ActionEvent event) {

    }

    @FXML
    void clickAkun3(ActionEvent event) {

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
    void clickLogout(ActionEvent event) {changePage(event,"login");}

}
