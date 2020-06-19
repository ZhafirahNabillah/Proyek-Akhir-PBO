package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import powerpuffgirls.Models.Admin;
import powerpuffgirls.Models.User;
import powerpuffgirls.Utils.DBConnection;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static powerpuffgirls.Utils.Helper.changePage;


public class DetailProfileController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnLogOut;

    @FXML
    private Text txt_Name;

    @FXML
    private Text txt_Username;

    @FXML
    private TextField nama;

    @FXML
    private TextField tanggal;

    @FXML
    private TextField noHP;

    @FXML
    private TextField email;

    @FXML
    private TextField usrname;

    @FXML
    private TextField pass;

    @FXML
    private Button simpan;

    @FXML
    private Button hapus;

    @FXML
    private Button reset;

    @FXML
    private Text idUser;

    PreparedStatement ps;

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
    void clickHapus(ActionEvent event) {

    }

    @FXML
    void clickLogout(ActionEvent event) {changePage(event,"login");

    }

    @FXML
    void clickReset(ActionEvent event) {
        idUser.setText("");
        nama.setText("");
        usrname.setText("");
        pass.setText("");
        email.setText("");
        noHP.setText("");
        tanggal.setText("");
        //String konfirmasi ="Konfirmasi ";

    }

    @FXML
    void clickSimpan(ActionEvent event) {
        DBConnection connec=new DBConnection();
        String id = idUser.getText();
        String name = nama.getText();
        String usrnm = usrname.getText();
        String pas = pass.getText();
        String mail = email.getText();
        String nohp= noHP.getText();
        String tgl = tanggal.getText();
        String verif = "Konfirmasi ";

        try {
            ps=connec.connection().prepareStatement("INSERT INTO user (IdUser,NamaLengkap,Username,Password,Email,NoHP,TanggalLahir,status) values ('"+id+"','"+name+"','"+usrnm+"','"+pas+"','"+mail+"','"+nohp+"','"+tgl+"','"+verif+"') on duplicate key update IdUser='"+id+"',NamaLengkap='"+name+"',Username='"+usrnm+"',Password='"+pas+"',Email='"+mail+"',NoHP='"+nohp+"',TanggalLahir='"+tgl+"',status = '"+verif+"' ");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DATA BERHASIL DIUBAH !");
            a.showAndWait();
            Change();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        changePage(event,"page_profile");
    }
    public void View(){
        idUser.setText(User.getIduser());
        txt_Name.setText(User.getNamalengkap());
        txt_Username.setText(User.getUsrname());
        nama.setText(User.getNamalengkap());
        usrname.setText(User.getUsrname());
        pass.setText(User.getPasswrd());
        email.setText(User.getMail());
        noHP.setText(User.getNoHP());
        tanggal.setText(User.getTgllahir());
    }
    public void Change(){
        DBConnection connec  = new DBConnection();
        String nama=null;
        String us=null;
        String pas=null;
        String mail=null;
        String hand=null;
        String date=null;
        try {
            User.setIduser(idUser.getText());
            PreparedStatement ps = connec.connection().prepareStatement("Select * from user where IdUser ='"+idUser.getText()+"'");
            ResultSet st =ps.executeQuery();
            while (st.next()){
                nama= st.getString("NamaLengkap");
                us=st.getString("Username");
                pas=st.getString("Password");
                mail=st.getString("Email");
                hand=st.getString("NoHP");
                date=st.getString("TanggalLahir");
            }
            User.setNamalengkap(nama);
            User.setPasswrd(pas);
            User.setUsrname(us);
            User.setMail(mail);
            User.setNoHP(hand);
            User.setTgllahir(date);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        View();
    }
}
