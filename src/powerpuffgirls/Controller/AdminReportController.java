package powerpuffgirls.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Laporan;
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminReportController implements Initializable {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnLogout;

    @FXML
    private TableView<Laporan> tblLaporan;

    @FXML
    private TableColumn<Laporan, String> tanggal;

    @FXML
    private TableColumn<Laporan, String> namaLengkap;

    @FXML
    private TableColumn<Laporan, String> alamat;

    @FXML
    private Text handphone;

    @FXML
    private Text nama;

    @FXML
    private Text tgl;

    @FXML
    private Text rumah;

    @FXML
    private Text isi;


    @FXML
    private Text idLaporan;

    ObservableList<Laporan> tbl2laporan;
    PreparedStatement ps;
    ResultSet rs;


    @FXML
    void clickAccount(ActionEvent event) {changePage(event,"admin_dashboard");

    }

    @FXML
    void clickPostArticle(ActionEvent event) {changePage(event,"admin_post");

    }

    @FXML
    void clickReport(ActionEvent event) {changePage(event, "admin_report");

    }

    @FXML
    void klikArtikel(ActionEvent event) {changePage(event,"admin_artikel");
    }

    @FXML
    void clickLogout(ActionEvent event){changePage(event,"login");

    }

    private void InsertTabel(){
        DBConnection connec  = new DBConnection();
        try {
            tbl2laporan= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM laporan");
            rs=ps.executeQuery();
            while (rs.next()){
                tbl2laporan.add(new Laporan(rs.getString("IdLaporan"),rs.getString("NamaLengkap"),rs.getString("TanggalKejadian"),rs.getString("AlamatLengkap"),rs.getString("NoHandphone"),rs.getString("Kronologi")));
            }
            //[[]]
            //[[1,maya,username,pas][2,maya1,user]]

            namaLengkap.setCellValueFactory(new PropertyValueFactory<>("nama"));
            tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            alamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));

            tblLaporan.setItems(null);
            tblLaporan.setItems(tbl2laporan);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void View(){
        tblLaporan.setOnMouseClicked(e ->{
            Laporan report=tblLaporan.getItems().get(tblLaporan.getSelectionModel().getFocusedIndex());
            idLaporan.setText(report.getId());
            nama.setText(report.getNama());
            tgl.setText(report.getTanggal());
            rumah.setText(report.getAlamat());
            isi.setText(report.getKronologi());
            handphone.setText(report.getNoHP());
            tanggal.setText(report.getTanggal());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InsertTabel();
        View();
    }
}
