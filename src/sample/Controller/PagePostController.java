package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.swing.*;

import static sample.Main.Helper.changePage;

public class PagePostController {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnPosting;

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event, "Dashboard");

    }

    @FXML
    void clickBtnPost(ActionEvent event) {changePage(event, "page_post");

    }

    @FXML
    void clickBtnPostingan(ActionEvent event) {
        JOptionPane.showMessageDialog (null, "Data sedang diverifikasi !", "PEMBERITAHUAN", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void clickBtnProfile(ActionEvent event) {changePage(event, "page_profile");

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {changePage(event, "page_curhat");

    }

    @FXML
    void clickLogout(ActionEvent event) {
        changePage(event,"login");
    }

}
