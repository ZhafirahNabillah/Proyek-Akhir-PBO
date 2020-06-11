package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import static powerpuffgirls.Utils.Helper.changePage;

public class DashboardController {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Text namaLengkap;

    @FXML
    private Text userName;

    @FXML
    private Text isiPostingan;
    @FXML
    private Button btnArticle;

    @FXML
    private Button btnReport;

    @FXML
    void clickBtnArticle(ActionEvent event) {changePage(event, "page_Article");
    }

    @FXML
    void clickBtnHome(ActionEvent event) {

        changePage(event, "Dashboard");

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

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ArrayList<User> data = User.getUser();
//        for (User user : data){
//            namaLengkap.setText(toString()).add(user.getNamaLengkap());
//            userName.setText().add(user.getUsername());
//            isiPostingan.setText().add(user.Isipostingan());
//        }
//    }
}
