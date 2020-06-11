package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.swing.*;
import static powerpuffgirls.Utils.Helper.changePage;

public class PageLaporController {

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnHome;

    @FXML
    void clickBtnHome(ActionEvent event) { changePage(event,"Dashboard");

    }

    @FXML
    void clickBtnPost(ActionEvent event) { changePage(event,"page_post");

    }

    @FXML
    void clickBtnProfile(ActionEvent event) {changePage(event,"page_profile");

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {changePage(event,"page_curhat");
    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");
    }

    @FXML
    void clickSend(ActionEvent event) {
        JOptionPane.showMessageDialog (null, "Berhasil Kirim !", "PEMBERITAHUAN", JOptionPane.INFORMATION_MESSAGE);
    }

}
