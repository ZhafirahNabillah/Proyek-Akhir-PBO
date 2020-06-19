package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;

import javax.swing.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;
import static powerpuffgirls.Utils.Helper.changeScene;

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
    private TextArea post;

    @FXML
    private DatePicker tanggal;

    @FXML
    private Text idUser;

    PreparedStatement ps;

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event, "Dashboard");

    }

    @FXML
    void clickBtnPost(ActionEvent event) {changePage(event, "page_post");

    }

    @FXML
    void clickBtnPostingan(ActionEvent event) {
        DBConnection connec = new DBConnection();
        String name = nama.getText();
        String usrnm = username.getText();
        String tgl = tanggal.getValue().toString();
        String isi = post.getText();
        String id = idUser.getText();
        String stat = "Kosong";
        try {
            ps=connec.connection().prepareStatement("INSERT INTO postingan (NamaLengkap,Username,IsiPostingan,TanggalPosting,StatusPostingan,IdUser) values ('"+name+"','"+usrnm+"','"+isi+"','"+tgl+"','"+stat+"','"+id+"')");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Silahkan Tunggu Verifikasi !");
            a.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        changePage(event,"page_profile");
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
        idUser.setText(User.getIduser());
    }
}
