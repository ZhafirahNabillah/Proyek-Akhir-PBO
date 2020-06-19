package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;

import javax.swing.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PageLaporController implements Initializable {

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnHome;

    @FXML
    private Button send;

    @FXML
    private Button batal;

    @FXML
    private Text name;

    @FXML
    private DatePicker tanggal;

    @FXML
    private TextArea alamat;

    @FXML
    private TextField noHp;

    @FXML
    private TextArea kronologi;

    @FXML
    private Text idUser;

    PreparedStatement ps;

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
        DBConnection connec = new DBConnection();
        String id = idUser.getText();
        String nama = name.getText();
        String tgl = tanggal.getValue().toString();
        String rumah = alamat.getText();
        String no = noHp.getText();
        String cerita= kronologi.getText();
        try {
            PreparedStatement ps=connec.connection().prepareStatement("INSERT INTO laporan (NamaLengkap,TanggalKejadian,AlamatLengkap,NoHandphone,Kronologi,IdUser) values ('"+nama+"','"+tgl+"','"+rumah+"','"+no+"','"+cerita+"','"+id+"')");
            ps.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"DATA BERHASIL TERKIRIM!");
                alert.showAndWait();
                reset();
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void clickBatal(ActionEvent event) {
        reset();
    }

    public void reset(){
        tanggal.getValue().equals("");
        alamat.setText("");
        noHp.setText("");
        kronologi.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(User.getNamalengkap());
        idUser.setText(User.getIduser());
    }
}
