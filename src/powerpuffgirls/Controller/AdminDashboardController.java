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
import powerpuffgirls.Models.Psikolog;
import powerpuffgirls.Models.User1;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class AdminDashboardController implements Initializable {

    @FXML
    private TableView<User1> tblpenggu;

    @FXML
    private TableColumn<User1, Integer> idpengguna;

    @FXML
    private TableColumn<User1, String> namapengguna;

    @FXML
    private TableColumn<User1, String> uspengguna;

    @FXML
    private TableColumn<User1, String> passwordpengguna;

    @FXML
    private TableColumn<User1, String> emailpengguna;

    @FXML
    private TableColumn<User1, String> nopengguna;

    @FXML
    private Text iddetail;

    @FXML
    private Text namadetail;

    @FXML
    private Text userdetail;

    @FXML
    private Text pasdetail;

    @FXML
    private Text emaildetail;

    @FXML
    private Text nodetail;

    @FXML
    private Text tgldetail;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnAkun;

    @FXML
    private Button btnLogout;

    @FXML
    private AnchorPane AkunPSikolog;

    @FXML
    private TableView<Psikolog> tblpsikolog;

    @FXML
    private TableColumn<Psikolog, String> namalengkap;

    @FXML
    private TableColumn<Psikolog, String> usrname;

    @FXML
    private TableColumn<Psikolog, String> email;

    @FXML
    private TableColumn<Psikolog, String> idPsi;

    @FXML
    private TextField nama;

    @FXML
    private TextField username;

    @FXML
    private TextField pass;

    @FXML
    private TextField emailfield;

    @FXML
    private TextField noHP;

    @FXML
    private Text tanggal;

    @FXML
    private Button simpan;

    @FXML
    private Button batal;

    @FXML
    private Text idPSikolog;

    ObservableList <User1> tbllpengguna;
    ObservableList<Psikolog> tbllpsikolog;
    PreparedStatement ps;
    ResultSet rs;

    private void masuktabel(){
        DBConnection connec  = new DBConnection();
        try {
            tbllpsikolog= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM psikolog");
            rs=ps.executeQuery();
            while (rs.next()){
                tbllpsikolog.add(new Psikolog(rs.getString("IdPsikolog"),rs.getString("NamaLengkap"),rs.getString("Username"),rs.getString("Password"),rs.getString("Email"),rs.getString("NoHP"),rs.getString("TanggalLahir")));
            }
            //[[]]
            //[[1,maya,username,pas][2,maya1,user]]

            idPsi.setCellValueFactory(new PropertyValueFactory<>("id"));
            namalengkap.setCellValueFactory(new PropertyValueFactory<>("nama"));
            usrname.setCellValueFactory(new PropertyValueFactory<>("username"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));

            tblpsikolog.setItems(null);
            tblpsikolog.setItems(tbllpsikolog);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void masuktabel2(){
        DBConnection connec  = new DBConnection();
        try {
            tbllpengguna= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM user");
            rs=ps.executeQuery();
            while (rs.next()){
                tbllpengguna.add(new User1(rs.getString("idUser"),rs.getString("NamaLengkap"),rs.getString("Username"),rs.getString("Password"),rs.getString("Email"),rs.getString("NoHP"),rs.getString("TanggalLahir")));
            }
            //[[]]
            //[[1,maya,username,pas][2,maya1,user]]

            idpengguna.setCellValueFactory(new PropertyValueFactory<>("id"));
            namapengguna.setCellValueFactory(new PropertyValueFactory<>("nama"));
            uspengguna.setCellValueFactory(new PropertyValueFactory<>("username"));
            passwordpengguna.setCellValueFactory(new PropertyValueFactory<>("password"));
            emailpengguna.setCellValueFactory(new PropertyValueFactory<>("email"));
            nopengguna.setCellValueFactory(new PropertyValueFactory<>("nohp"));

            tblpenggu.setItems(null);
            tblpenggu.setItems(tbllpengguna);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void nampilin(){
        tblpsikolog.setOnMouseClicked(e ->{
            Psikolog akun=tblpsikolog.getItems().get(tblpsikolog.getSelectionModel().getFocusedIndex());
            idPSikolog.setText(akun.getId());
            nama.setText(akun.getNama());
            username.setText(akun.getUsername());
            pass.setText(akun.getPassword());
            emailfield.setText(akun.getEmail());
            noHP.setText(akun.getNohp());
            tanggal.setText(akun.getTanggal());
        });
    }

    private void nampilin2(){
        tblpenggu.setOnMouseClicked(e ->{
            User1 akun=tblpenggu.getItems().get(tblpenggu.getSelectionModel().getFocusedIndex());
            iddetail.setText(akun.getId());
            namadetail.setText(akun.getNama());
            userdetail.setText(akun.getUsername());
            pasdetail.setText(akun.getPassword());
            emaildetail.setText(akun.getEmail());
            nodetail.setText(akun.getNohp());
            tgldetail.setText(akun.getTanggal());
        });
    }

    @FXML
    void clickAkun(ActionEvent event) {
        changePage(event,"admin_DetailAkun");
    }

    @FXML
    void clickAccount(ActionEvent event) { changePage(event, "admin_dashboard"); }

    @FXML
    void clickPostArticle(ActionEvent event) { changePage(event,"admin_post");}

    @FXML
    void clickReport(ActionEvent event) { changePage(event,"admin_report");}

    @FXML
    void clickVerify(ActionEvent event){ changePage(event,"admin_verify");}

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");}

    @FXML
    void btnBatal(ActionEvent event) {

    }

    @FXML
    void btnSimpan(ActionEvent event) {
    DBConnection connec=new DBConnection();
    String id1=idPSikolog.getText();
    String name = nama.getText();
    String us = username.getText();
    String pas = pass.getText();
    String mail= emailfield.getText();
    String noHand = noHP.getText();
    String tgl = tanggal.getText();
        try {
            ps=connec.connection().prepareStatement("INSERT INTO psikolog (IdPsikolog,NamaLengkap,Username,Password,Email,NoHP,TanggalLahir) values ('"+id1+"','"+name+"','"+us+"','"+pas+"','"+mail+"','"+noHand +"','"+tgl+"') on duplicate key update NamaLengkap='"+name+"'" +
                    ",Username='"+us+"',Password='"+pas+"',Email='"+mail+"',NoHP='"+noHand+"',TanggalLahir='"+tgl+"'");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Data Berhasil Diubah !");
            a.showAndWait();
            masuktabel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        masuktabel();
        masuktabel2();
        nampilin();
        nampilin2();
    }
}
