package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminVerifyController {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnVerify;

    @FXML
    private Button btnLogout;

    @FXML
    void clickAccount(ActionEvent event) {changePage(event,"admin_dashboard");
    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");
    }

    @FXML
    void clickPostArticle(ActionEvent event) {changePage(event,"admin_post");
    }

    @FXML
    void clickReport(ActionEvent event) {changePage(event,"admin_report");
    }

    @FXML
    void clickVerify(ActionEvent event) { changePage(event,"admin_verify");
    }

}
