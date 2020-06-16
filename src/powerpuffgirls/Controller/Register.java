package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import powerpuffgirls.Utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static powerpuffgirls.Utils.Helper.changePage;

public class Register {

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField Name;

    @FXML
    private TextField email;

    @FXML
    private TextField noHP;

    @FXML
    private DatePicker tanggalLahir;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    PreparedStatement ps;

    @FXML
    void LogInClick(ActionEvent event) {
        changePage(event, "login");
    }

    @FXML
    void RegisterClick(ActionEvent event) {
        changePage(event, "login");

        DBConnection connec=new DBConnection();
        String name = Name.getText();
        String user = username.getText();
        String pass = password.getText();
        String mail= email.getText();
        String noHand = noHP.getText();
        String tgl = tanggalLahir.getValue().toString();
        try {
            ps=connec.connection().prepareStatement("INSERT INTO user (NamaLengkap,Username,Password,Email,NoHP,TanggalLahir) values ('"+name+"','"+user+"','"+pass+"','"+mail+"','"+noHand +"','"+tgl+"')");
            ps.execute();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Akun Telah Aktif !");
            a.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
