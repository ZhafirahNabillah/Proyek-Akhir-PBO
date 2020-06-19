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

    }

    @FXML
    void klikUbah(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String idPostingan=id.getText();
        String name = namadetail.getText();
        String us = usrnmdetail.getText();
        String date = tgldetail.getText();
        String post = isidetail.getText();
        String stat = status.getText();
        try {
            ps=connec.connection().prepareStatement("INSERT INTO postingan (IdPostingan,NamaLengkap,Username,IsiPostingan,TanggalPosting,StatusPostingan) values ('"+idPostingan+"','"+name+"','"+us+"','"+post+"','"+date+"','"+stat+"') on duplicate key update IdPostingan='"+idPostingan+"',NamaLengkap='"+name+"'" +
                    ",Username='"+us+"',IsiPostingan='"+post+"',TanggalPosting='"+date+"',Status='"+stat+"'");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Berhasil Diubah !");
            a.showAndWait();
            MasukPostingan();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void MasukPostingan(){
        DBConnection connec = new DBConnection();
        try {
            tblpostingan2= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM postingan where NamaLengkap='"+txt_Name.getText()+"'&&Username='"+txt_Username.getText()+"'");
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
            namadetail.setText(tampilan.getNama());
            usrnmdetail.setText(tampilan.getUsername());
            tgldetail.setText(tampilan.getTanggal());
            isidetail.setText(tampilan.getIsi());
            status.setText(tampilan.getStatus());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_Name.setText(User.getNamalengkap());
        txt_Username.setText(User.getUsrname());
        MasukPostingan();
        nampilinpostingan();
    }
}
