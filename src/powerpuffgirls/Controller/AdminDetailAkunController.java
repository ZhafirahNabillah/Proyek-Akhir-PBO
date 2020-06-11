package powerpuffgirls.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import powerpuffgirls.Models.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminDetailAkunController implements Initializable {

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
    private  Button btnVerify;

    @FXML
    private ListView<String> listAdmin;

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

    @FXML
    void clickVerify(ActionEvent event){changePage(event,"admin_verify");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<User> data = User.getUser();
        for (User user : data){
            listAdmin.getItems().add(user.getNamaLengkap());
            listAdmin.getItems().add(user.getUsername());
            listAdmin.getItems().add(user.getPassword());
            listAdmin.getItems().add(user.getEmail());
            listAdmin.getItems().add(user.getNoHP());
            listAdmin.getItems().add(user.getTanggalLahir());
        }
    }
}
