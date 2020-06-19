package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Admin;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Models.Psikolog.mail;
import static powerpuffgirls.Utils.Helper.changePage;

public class AdminPostController implements Initializable {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnSend;

    @FXML
    private Button btnLogout;
    @FXML
    private TextField namaPen;

    @FXML
    private TextField kota;

    @FXML
    private TextField judul;

    @FXML
    private TextArea isi;

    @FXML
    private Button batal;

    @FXML
    private DatePicker tanggal;

    @FXML
    private Text idAdmin;

    PreparedStatement ps;

    @FXML
    void clickAccount(ActionEvent event) { changePage(event,"admin_dashboard");

    }

    @FXML
    void clickPostArticle(ActionEvent event) {changePage(event,"admin_post");

    }

    @FXML
    void clickReport(ActionEvent event) {changePage(event,"admin_report");

    }

    @FXML
    void clickSend(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String name = namaPen.getText();
        String kotaPen = kota.getText();
        String judulAr = judul.getText();
        String artikel= isi.getText();
        String tgl = tanggal.getValue().toString();
        String id = idAdmin.getText();
        try {
            ps=connec.connection().prepareStatement("INSERT INTO artikel (NamaPenerbit,KotaPenerbit,TanggalTerbit,JudulArtikel,IsiArtikel,IdAdmin) values ('"+name+"','"+kotaPen+"','"+tgl+"','"+judulAr+"','"+artikel+"','"+id+"')");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DATA BERHASIL DI UPLOAD !");
            a.showAndWait();
            reset();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        changePage(event,"admin_dashboard");
    }

    @FXML
    void clickBatal(ActionEvent event) {
        reset();
    }

    @FXML
    void klikArtikel(ActionEvent event) {changePage(event,"admin_artikel");
    }

    @FXML
    void clickLogout(ActionEvent event){changePage(event,"login");

    }

    public void reset(){
        namaPen.setText("");
        kota.setText("");
        judul.setText("");
        isi.setText("");
        tanggal.getValue().equals("");
        idAdmin.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idAdmin.setText(Admin.getIdAdmin());
    }
}
