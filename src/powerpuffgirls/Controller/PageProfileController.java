package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import static powerpuffgirls.Utils.Helper.changePage;

public class PageProfileController {

    @FXML
    private AnchorPane profile;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Text txt_Name;

    @FXML
    private Text txt_Username;

    @FXML
    private TextField btnSearching;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnDetail;

    @FXML
    private Text Username_post;

    @FXML
    private Button btnSetPostingan;

    @FXML
    private Text Date_Post;

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event, "Dashboard");

    }

    @FXML
    void clickBtnNext(ActionEvent event) {changePage(event, "btn_next");

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
    void clickBtnDetail(ActionEvent event) {changePage(event, "detail_profile");

    }

    @FXML
    void clickLogout(ActionEvent event) { changePage(event,"login");
    }

    @FXML
    void clickSetPost(ActionEvent event){changePage(event,"set_postingan");
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ArrayList<User> data= User.getUser();
//        for (User user : data){
//            txt_Name.getText().add(user.getNamaLengkap());
//        }
//        System.out.println(new Gson().toJson(data));
//    }
}
