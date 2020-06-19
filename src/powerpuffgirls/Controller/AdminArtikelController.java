package powerpuffgirls.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Admin;
import powerpuffgirls.Models.Artikel;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminArtikelController implements Initializable {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnLogout;

    @FXML
    private TableView<Artikel> tblArtikel;

    @FXML
    private TableColumn<Artikel,String> tanggal;

    @FXML
    private TableColumn<Artikel,String> namaPenerbit;

    @FXML
    private TableColumn<Artikel,String> judulArtikel;

    @FXML
    private TextField nama;

    @FXML
    private TextField kota;

    @FXML
    private TextField date;

    @FXML
    private TextField judul;

    @FXML
    private TextArea isi;

    @FXML
    private Text idAdmin;

    @FXML
    private Text idArtikel;

    PreparedStatement ps;
    ObservableList<Artikel> tblArtikel2;
    ResultSet rt;

    @FXML
    void clickAccount(ActionEvent event) { changePage(event,"admin_dashboard");
    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");
    }

    @FXML
    void clickPostArticle(ActionEvent event) {changePage(event,"admin_post");

    }

    @FXML
    void clickReport(ActionEvent event) {changePage(event,"admin_report");

    }

    @FXML
    void klikArtikel(ActionEvent event) {changePage(event,"admin_artikel");
    }

    @FXML
    void klikHapus(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String id=idArtikel.getText();
        try {
            ps=connec.connection().prepareStatement("Delete from artikel where IdArtikel='"+id+"'");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DATA TELAH SEPENUHNYA DIHAPUS");
            a.showAndWait();
            InsertTabel();
            ViewTabel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void klikReset(ActionEvent event) {

    }

    @FXML
    void klikSimpan(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String id=idArtikel.getText();
        String name = nama.getText();
        String tempat = kota.getText();
        String tgl = tanggal.getText();
        String jdl= judul.getText();
        String artikel = isi.getText();

        try {
            ps=connec.connection().prepareStatement("INSERT INTO artikel (IdArtikel,NamaPenerbit,KotaPenerbit,TanggalTerbit,JudulArtikel,IsiArtikel) values ('"+id+"','"+name+"','"+tempat+"','"+tgl+"'," +
                    "'"+jdl+"','"+artikel +"') on duplicate key update NamaPenerbit='"+name+"'" + ",KotaPenerbit='"+tempat+"',TanggalTerbit='"+tgl+"',JudulArtikel='"+jdl+"',IsiArtikel='"+artikel+"'");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DATA BERHASIL DIUBAH !");
            a.showAndWait();
            InsertTabel();
            ViewTabel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertTabel(){
        DBConnection connec = new DBConnection();
        try {
            tblArtikel2= FXCollections.observableArrayList();
            ps = connec.connection().prepareStatement("Select * from artikel");
            rt=ps.executeQuery();
            while (rt.next()){
                tblArtikel2.add(new Artikel(rt.getString("IdArtikel"),rt.getString("NamaPenerbit"),rt.getString("KotaPenerbit"),rt.getString("TanggalTerbit"),rt.getString("JudulArtikel"),rt.getString("IsiArtikel"),rt.getString("IdAdmin")));
            }
            namaPenerbit.setCellValueFactory(new PropertyValueFactory<>("nama"));
            tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            judulArtikel.setCellValueFactory(new PropertyValueFactory<>("judul"));

            tblArtikel.setItems(null);
            tblArtikel.setItems(tblArtikel2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ViewTabel(){
        tblArtikel.setOnMouseClicked(e ->{
            Artikel artikel = tblArtikel.getItems().get(tblArtikel.getSelectionModel().getFocusedIndex());
            idArtikel.setText(artikel.getId());
            nama.setText(artikel.getNama());
            kota.setText(artikel.getKota());
            date.setText(artikel.getTanggal());
            judul.setText(artikel.getJudul());
            isi.setText(artikel.getIsiArtikel());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idAdmin.setText(Admin.getIdAdmin());
        InsertTabel();
        ViewTabel();
    }
}

//BELUM TAU CARA NGERESET MAYY.
