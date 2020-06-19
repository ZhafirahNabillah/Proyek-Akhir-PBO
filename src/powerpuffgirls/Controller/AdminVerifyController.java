package powerpuffgirls.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Postingan;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminVerifyController implements Initializable {

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnLogout;

    @FXML
    private TableView<Postingan> tblPostingan;

    @FXML
    private TableColumn<Postingan, String> tanggalPostinan;

    @FXML
    private TableColumn<Postingan, String> namaLengkap;

    @FXML
    private TableColumn<Postingan, String> statusPostingan;

    @FXML
    private Text nama;

    @FXML
    private Text usrnm;

    @FXML
    private Text tgl;

    @FXML
    private Text status;

    @FXML
    private Text isi;

    @FXML
    private Text idPostingan;
    @FXML
    private Text idUser;

    ObservableList<Postingan> tblpostingan2;
    PreparedStatement ps;
    ResultSet rs;

    @FXML
    void clickAccount(ActionEvent event) {changePage(event,"admin_dashboard");
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
    void klikTerima(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String id=idPostingan.getText();
        String name = nama.getText();
        String us = usrnm.getText();
        String date = tgl.getText();
        String post = isi.getText();
        String user= idUser.getText();
        String stat = "Diterima";

        try {
            ps=connec.connection().prepareStatement("INSERT INTO postingan (IdPostingan,NamaLengkap,Username,IsiPostingan,TanggalPosting,StatusPostingan,IdUser) values ('"+id+"','"+name+"','"+us+"','"+post+"','"+date+"','"+stat+"','"+user+"') on duplicate key update IdPostingan='"+id+"'" + ",NamaLengkap='"+name+"',Username='"+us+"',IsiPostingan='"+post+"',TanggalPosting='"+date+"',StatusPostingan='"+stat+"',IdUser='"+user+"'");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "POSTINGAN DITERIMA !");
            a.showAndWait();
            MasukPostingan();
            nampilinpostingan();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void klikTolak(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String id=idPostingan.getText();
        String name = nama.getText();
        String us = usrnm.getText();
        String date = tgl.getText();
        String post = isi.getText();
        String user= idUser.getText();
        String stat = "Ditolak";

        try {
            ps=connec.connection().prepareStatement("INSERT INTO postingan (IdPostingan,NamaLengkap,Username,IsiPostingan,TanggalPosting,StatusPostingan,IdUser) values ('"+id+"','"+name+"','"+us+"','"+post+"','"+date+"','"+stat+"','"+user+"') on duplicate key update IdPostingan='"+id+"'" + ",NamaLengkap='"+name+"',Username='"+us+"',IsiPostingan='"+post+"',TanggalPosting='"+date+"',StatusPostingan='"+stat+"',IdUser='"+user+"'");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "POSTINGAN DITOLAK!");
            a.showAndWait();
            MasukPostingan();
            nampilinpostingan();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void MasukPostingan(){
        DBConnection connec = new DBConnection();
        try {
            tblpostingan2= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM postingan ");
            rs=ps.executeQuery();
            while (rs.next()){
                tblpostingan2.add(new Postingan(rs.getString("IdPostingan"),rs.getString("NamaLengkap"),rs.getString("Username"),rs.getString("IsiPostingan"),rs.getString("TanggalPosting"),rs.getString("StatusPostingan"),rs.getString("IdUser")));
            }
            //[[]]
            //[[1,maya,username,pas][2,maya1,user]]

            tanggalPostinan.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            namaLengkap.setCellValueFactory(new PropertyValueFactory<>("nama"));
            statusPostingan.setCellValueFactory(new PropertyValueFactory<>("status"));

            tblPostingan.setItems(null);
            tblPostingan.setItems(tblpostingan2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void nampilinpostingan(){
        tblPostingan.setOnMouseClicked(e ->{
            Postingan tampilan =tblPostingan.getItems().get(tblPostingan.getSelectionModel().getFocusedIndex());
            idUser.setText(tampilan.getIdUser());
            idPostingan.setText(tampilan.getId());
            nama.setText(tampilan.getNama());
            usrnm.setText(tampilan.getUsername());
            tgl.setText(tampilan.getTanggal());
            isi.setText(tampilan.getIsi());
            status.setText(tampilan.getStatus());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MasukPostingan();
        nampilinpostingan();
    }
}
