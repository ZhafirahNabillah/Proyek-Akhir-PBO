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
    private Button btnActivity;

    @FXML
    private Button btnActivity2;

    @FXML
    private Button btnActivity3;

    @FXML
    private Button btnActivityPsi;

    @FXML
    void clickActivity(ActionEvent event) {

    }

    @FXML
    void clickActivity2(ActionEvent event) {

    }

    @FXML
    void clickActivity3(ActionEvent event) {

    }

    @FXML
    void clickActivityPsi(ActionEvent event) {

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

}
