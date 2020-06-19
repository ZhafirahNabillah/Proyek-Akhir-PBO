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
import powerpuffgirls.Models.Artikel;
import powerpuffgirls.Models.Curhat;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PsikologCurhatController implements Initializable {

    @FXML
    private Button btnCurhat;

    @FXML
    private Button btnProfile;

    @FXML
    private Text isi;

    @FXML
    private Text umur;

    @FXML
    private Text nama;

    @FXML
    private Text noHand;

    @FXML
    private Text tanggal;

    @FXML
    private TableView<Curhat> tblCurhat;

    @FXML
    private TableColumn<Curhat,String> namaLengkap;

    @FXML
    private TableColumn<Curhat,String> usia;

    @FXML
    private TableColumn<Curhat,String> noHP;

    ObservableList<Curhat> tblCurhat2;
    PreparedStatement ps;
    ResultSet rt;

    @FXML
    void clickCurhat(ActionEvent event) { changePage(event,"psikolog_curhat");

    }

    @FXML
    void clickProfile(ActionEvent event) {changePage(event,"psikolog_profile");
    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");

    }

    public void InsertTabel(){
        DBConnection connec = new DBConnection();
        tblCurhat2=FXCollections.observableArrayList();
        try {
            ps = connec.connection().prepareStatement("Select * from curhat");
            rt = ps.executeQuery();
            while (rt.next()){
                tblCurhat2.add(new Curhat(rt.getString("IdCurhat"),rt.getString("NamaLengkap"),rt.getString("TanggalLahir"),rt.getString("Usia"),rt.getString("NoHP"),rt.getString("IsiCurhat")));
            }
            namaLengkap.setCellValueFactory(new PropertyValueFactory<>("nama"));
            usia.setCellValueFactory(new PropertyValueFactory<>("usia"));
            noHP.setCellValueFactory(new  PropertyValueFactory<>("noHP"));

            tblCurhat.setItems(null);
            tblCurhat.setItems(tblCurhat2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void ViewTabel(){
        tblCurhat.setOnMouseClicked(e ->{
            Curhat curhat = tblCurhat.getItems().get(tblCurhat.getSelectionModel().getFocusedIndex());
            nama.setText(curhat.getNama());
            umur.setText(curhat.getUsia());
            tanggal.setText(curhat.getTanggal());
            noHand.setText(curhat.getNoHP());
            isi.setText(curhat.getIsi());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InsertTabel();
        ViewTabel();
    }
}
