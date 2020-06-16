package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import powerpuffgirls.Models.User;

import javax.swing.*;

import java.net.URL;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PagePostController implements Initializable {

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
    private Text nama;

    @FXML
    private Text username;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nama.setText(User.getNamalengkap());
        username.setText(User.getUsrname());
    }
}
