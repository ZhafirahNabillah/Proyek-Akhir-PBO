package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import static sample.Main.Helper.changePage;


public class DashboardController {
     int number = 0;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Text txtLikes;

    @FXML
    private Text txtComment;

    @FXML
    private Button btnLikes;

    @FXML
    private Button btnComment;

    @FXML
    private Button btnArticle;

    @FXML
    private Button btnReport;

    @FXML
    void clickBtnArticle(ActionEvent event) {changePage(event, "page_Article");
    }

    @FXML
    void clickBtnComment(ActionEvent event) {
        number++;
        txtComment.setText(String.valueOf(number));
    }

    @FXML
    void clickBtnHome(ActionEvent event) {

        changePage(event, "Dashboard");

    }

    @FXML
    void clickBtnLikes(ActionEvent event) {
        number++;
        txtLikes.setText(String.valueOf(number));
    }

    @FXML
    void clickBtnPost(ActionEvent event) {changePage(event, "page_post");

    }

    @FXML
    void clickBtnProfile(ActionEvent event) {changePage(event, "page_profile");

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {changePage(event, "page_curhat");

    }

    @FXML
    void clickBtnReport(ActionEvent event) {changePage(event, "page_lapor");

    }
    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");

    }
}
