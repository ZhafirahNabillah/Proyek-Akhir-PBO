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
import powerpuffgirls.Models.Postingan;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;


public class PageArticleController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private TableView<Artikel> artikel;

    @FXML
    private TableColumn<Artikel,String> namaPenerbit;

    @FXML
    private TableColumn<Artikel,String> tanggalTerbit;

    @FXML
    private TableColumn<Artikel,String> kotaTerbit;

    @FXML
    private TableColumn<Artikel,String> judulArtikel;

    @FXML
    private Text idArtikel;

    @FXML
    private Text namaPn;

    @FXML
    private Text tglPn;

    @FXML
    private Text kotaPn;

    @FXML
    private Text judul;

    @FXML
    private Text isi;

    ObservableList<Artikel> tblArtikel;
    PreparedStatement ps;
    ResultSet st;

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
    void clickLogout(ActionEvent event) { changePage(event,"login");

    }

    public void Insert(){
        DBConnection connec  = new DBConnection();
        try {
            tblArtikel= FXCollections.observableArrayList();
            ps=connec.connection().prepareStatement("SELECT * FROM artikel");
            st=ps.executeQuery();
            while (st.next()){
                tblArtikel.add(new Artikel(st.getString("IdArtikel"),st.getString("NamaPenerbit"),st.getString("KotaPenerbit"),st.getString("TanggalTerbit"),st.getString("JudulArtikel"),st.getString("IsiArtikel"),st.getString("IdAdmin")));
            }
            //[[]]
            //[[1,maya,username,pas][2,maya1,user]]

            namaPenerbit.setCellValueFactory(new PropertyValueFactory<>("nama"));
            tanggalTerbit.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            kotaTerbit.setCellValueFactory(new PropertyValueFactory<>("kota"));
            judulArtikel.setCellValueFactory(new PropertyValueFactory<>("judul"));

            artikel.setItems(null);
            artikel.setItems(tblArtikel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void View(){
        artikel.setOnMouseClicked(e ->{
            Artikel art = artikel.getItems().get(artikel.getSelectionModel().getFocusedIndex());
            idArtikel.setText(art.getId());
            namaPn.setText(art.getNama());
            tglPn.setText(art.getTanggal());
            kotaPn.setText(art.getKota());
            judul.setText(art.getJudul());
            isi.setText(art.getIsiArtikel());
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Insert();
        View();
    }
}
