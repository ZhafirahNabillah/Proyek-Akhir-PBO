package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Models.User;
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
    private Text namaPsi;

    @FXML
    private Text noHP;

    @FXML
    private Text nama;

    @FXML
    private Button kirim;

    @FXML
    private TextField usia;

    @FXML
    private DatePicker tgl;

    @FXML
    private Text noHand;

    @FXML
    private TextArea isiCurhat;

    @FXML
    private Button batal;

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
    void clickBtnProfile(ActionEvent event) {changePage(event, "page_profile");

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {
        changePage(event, "page_curhat");
    }


    @FXML
    void klikBatal(ActionEvent event) {
        reset();
    }

    @FXML
    void klikKirim(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String name = nama.getText();
        String age = usia.getText();
        String isi= isiCurhat.getText();
        String date = tgl.getValue().toString();
        String hand=noHand.getText();
        String id = idUser.getText();
        try {
            ps=connec.connection().prepareStatement("INSERT INTO curhat (NamaLengkap,TanggalLahir,Usia,NoHP,IsiCurhat,IdUser) values ('"+name+"','"+date+"','"+age+"','"+hand+"','"+isi+"','"+id+"')");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DATA BERHASIL DIKIRIM !");
            a.showAndWait();
            reset();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickLogout(ActionEvent event) {
        changePage(event,"login");
    }

    private void Psi(){
        DBConnection connec = new DBConnection();
        String name = null;
        String nohp= null;
        try {
            PreparedStatement pre = connec.connection().prepareStatement("SELECT * FROM psikolog where IdPsikolog=1");
            ResultSet rt = pre.executeQuery();
            while (rt.next()){
                name= rt.getString("NamaLengkap");
                nohp=rt.getString("NoHp");
            }
            namaPsi.setText(name);
            noHP.setText(nohp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reset(){
        usia.setText("");
        tgl.getValue().equals("");
        isiCurhat.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Psi();
       idUser.setText(User.getIduser());
       nama.setText(User.getNamalengkap());
       noHand.setText(User.getNoHP());
    }
}
