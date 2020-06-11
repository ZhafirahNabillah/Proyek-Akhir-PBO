package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminAktivitasController {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnAkun;

    @FXML
    void clickAccount(ActionEvent event) {
        changePage(event,"admin_Dashboard");
    }

    @FXML
    void clickAkun(ActionEvent event) {
        changePage(event,"admin_Dashboard");
    }

    @FXML
    void clickLogout(ActionEvent event) {
        changePage(event,"admin_Login");
    }

    @FXML
    void clickPostArticle(ActionEvent event) {
        changePage(event,"admin_Post");
    }

    @FXML
    void clickReport(ActionEvent event) {
        changePage(event,"admin_Report");
    }

}
