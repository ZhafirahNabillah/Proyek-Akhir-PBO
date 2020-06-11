package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminDetailReport {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnSelesai;

    @FXML
    private Button btnLaporan;

    @FXML
    private Button btnSee;

    @FXML
    private Button btnVerify;

    @FXML
    void clickAccount(ActionEvent event) {

    }

    @FXML
    void clickLaporan(ActionEvent event) {

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

    @FXML
    void clickSee(ActionEvent event) {

    }

    @FXML
    void clickSelesai(ActionEvent event) {

    }

    @FXML
    void clickVerify(ActionEvent event){
    changePage(event,"admin_verify");
    }

}
