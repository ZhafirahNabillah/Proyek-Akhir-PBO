package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Utils.DBConnection;

import javax.swing.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PageCurhatController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnSend;

    @FXML
    private Text nama;

    @FXML
    private Text noHP;

    @FXML
    void clickBtnHome(ActionEvent event) {changePage(event, "Dashboard");

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
    void clickBtnSend(ActionEvent event) {
        JOptionPane.showMessageDialog (null, "Berhasil Kirim !", "PEMBERITAHUAN", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void clickNotif(ActionEvent event) {

    }
    @FXML
    void clickLogout(ActionEvent event) {
        changePage(event,"login");
    }

    private void nampilin(){
        DBConnection connec= new DBConnection();
        String namaPsikolog = null;
        String noHandphone = null;
        try {
            PreparedStatement ps=connec.connection().prepareStatement("SELECT * from Psikolog");
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                namaPsikolog=rs.getString("NamaLengkap");
                noHandphone=rs.getString("NoHP");
            }
            nama.setText(namaPsikolog);
            noHP.setText(noHandphone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nampilin();
    }
}
