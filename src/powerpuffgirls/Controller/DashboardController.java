package powerpuffgirls.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Artikel;
import powerpuffgirls.Models.Postingan;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;

public class DashboardController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnArticle;

    @FXML
    private Button btnReport;

    @FXML
    private Text nama;

    @FXML
    private Text usrnm;

    @FXML
    private Text tgl;

    @FXML
    private Text isi;

    @FXML
    private Text status;

    @FXML
    private TableView<Postingan> postingan;

    @FXML
    private TableColumn<Postingan,String> namaLengkap;

    @FXML
    private TableColumn<Postingan,String> username;

    @FXML
    private TableColumn<Postingan,String> tanggalPostingan;

    @FXML
    private TableColumn<Postingan,String> statusPostingan;

    ObservableList<Postingan> tblPostingan;
    PreparedStatement ps;
    ResultSet st;

    @FXML
    void clickBtnArticle(ActionEvent event) {changePage(event, "page_Article");
    }

    @FXML
    void clickBtnHome(ActionEvent event) {

        changePage(event, "Dashboard");

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
    void clickBtnReport(ActionEvent event) {changePage(event, "page_lapor");

    }
    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");

    }

    public void Insert(){
        DBConnection connec  = new DBConnection();
        String stat="Diterima";
        try {
            tblPostingan= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM postingan where StatusPostingan='"+stat+"'");
            st=ps.executeQuery();
            while (st.next()){
                tblPostingan.add(new Postingan(st.getString("IdPostingan"),st.getString("NamaLengkap"),st.getString("Username"),st.getString("IsiPostingan"),st.getString("TanggalPosting"),st.getString("StatusPostingan"),st.getString("IdUser")));
            }
            //[[]]
            //[[1,maya,username,pas][2,maya1,user]]

            namaLengkap.setCellValueFactory(new PropertyValueFactory<>("nama"));
            username.setCellValueFactory(new PropertyValueFactory<>("username"));
            tanggalPostingan.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            statusPostingan.setCellValueFactory(new PropertyValueFactory<>("status"));

            postingan.setItems(null);
            postingan.setItems(tblPostingan);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void View(){
        postingan.setOnMouseClicked(e ->{
            Postingan post = postingan.getItems().get(postingan.getSelectionModel().getFocusedIndex());
//            idArtikel.setText(artikel.getId());
            nama.setText(post.getNama());
            usrnm.setText(post.getUsername());
            tgl.setText(post.getTanggal());
            status.setText(post.getStatus());
            isi.setText(post.getIsi());
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Insert();
        View();
    }
}
