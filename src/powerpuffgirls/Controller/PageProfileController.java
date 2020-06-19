package powerpuffgirls.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Postingan;
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class PageProfileController implements Initializable {

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
    private Button btnDetail;

    @FXML
    private TableView<Postingan> tblpostingan;

    @FXML
    private TableColumn<Postingan, String> idpost;

    @FXML
    private TableColumn<Postingan, String> namapost;

    @FXML
    private TableColumn<Postingan, String> usrnamepost;

    @FXML
    private TableColumn<Postingan, String> tglpost;

    @FXML
    private TextField namadetail;

    @FXML
    private TextField usrnmdetail;

    @FXML
    private TextField tgldetail;

    @FXML
    private TextArea isidetail;

    @FXML
    private Text status;

    @FXML
    private Button ubah;

    @FXML
    private Button batal;

    @FXML
    private Text id;

    @FXML
    private Text idUser;

    @FXML
    private Button hapus;

    ObservableList<Postingan> tblpostingan2;
    PreparedStatement ps;
    ResultSet rs;

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
    void clickBtnDetail(ActionEvent event) {changePage(event, "detail_profile");

    }

    @FXML
    void clickLogout(ActionEvent event) { changePage(event,"login");
    }

    @FXML
    void klikBatal(ActionEvent event) {
        id.setText("");
        namadetail.setText("");
        usrnmdetail.setText("");
        isidetail.setText("");
        tgldetail.setText("");
        status.setText("");
    }

    @FXML
    void klikHapus(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String idPostingan = id.getText();
        String nama = namadetail.getText();
        String us = usrnmdetail.getText();
        String date = tgldetail.getText();
        String isi = isidetail.getText();
        String sta = status.getText();
        String idUs = idUser.getText();

        try {
            ps=connec.connection().prepareStatement("DELETE FROM postingan where IdPostingan='"+idPostingan+"' ");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "POSTINGAN TELAH DIHAPUS!");
            a.showAndWait();
            MasukPostingan();
            Reset();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void klikUbah(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String idPostingan = id.getText();
        String nama = namadetail.getText();
        String us = usrnmdetail.getText();
        String date = tgldetail.getText();
        String isi = isidetail.getText();
        String sta = status.getText();
        String idUs = idUser.getText();

        try {
            ps=connec.connection().prepareStatement("INSERT INTO postingan (IdPostingan,NamaLengkap,Username,IsiPostingan,TanggalPosting,StatusPostingan,IdUser) values ('"+idPostingan+"','"+nama+"','"+us+"','"+isi+"','"+date+"','"+sta+"','"+idUs+"') on duplicate key update IdPostingan='"+idPostingan+"',NamaLengkap='"+nama+"',Username='"+us+"',IsiPostingan='"+isi+"',TanggalPosting='"+date+"',StatusPostingan='"+sta+"',IdUser='"+idUs+"' ");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "POSTINGAN DIUBAH!");
            a.showAndWait();
            MasukPostingan();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void MasukPostingan(){
        DBConnection connec = new DBConnection();
        String idUs = idUser.getText();
        try {
            tblpostingan2= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM postingan where IdUser='"+idUs+"'");
            rs=ps.executeQuery();
            while (rs.next()){
                tblpostingan2.add(new Postingan(rs.getString("IdPostingan"),rs.getString("NamaLengkap"),rs.getString("Username"),rs.getString("IsiPostingan"),rs.getString("TanggalPosting"),rs.getString("StatusPostingan"),rs.getString("IdUser")));
            }
            //[[]]
            //[[1,maya,username,pas][2,maya1,user]]

            idpost.setCellValueFactory(new PropertyValueFactory<>("id"));
            namapost.setCellValueFactory(new PropertyValueFactory<>("nama"));
            usrnamepost.setCellValueFactory(new PropertyValueFactory<>("username"));
            tglpost.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

            tblpostingan.setItems(null);
            tblpostingan.setItems(tblpostingan2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nampilinpostingan(){
        tblpostingan.setOnMouseClicked(e ->{
            Postingan tampilan =tblpostingan.getItems().get(tblpostingan.getSelectionModel().getFocusedIndex());
            id.setText(tampilan.getId());
            namadetail.setText(tampilan.getNama());
            usrnmdetail.setText(tampilan.getUsername());
            tgldetail.setText(tampilan.getTanggal());
            isidetail.setText(tampilan.getIsi());
            status.setText(tampilan.getStatus());
        });
    }

    public void Reset(){
        id.setText("");
        namadetail.setText("");
        usrnmdetail.setText("");
        isidetail.setText("");
        tgldetail.setText("");
        status.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_Name.setText(User.getNamalengkap());
        txt_Username.setText(User.getUsrname());
        idUser.setText(User.getIduser());
        MasukPostingan();
        nampilinpostingan();
    }
}
