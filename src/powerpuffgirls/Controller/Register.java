package powerpuffgirls.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import powerpuffgirls.Models.User;

import javax.swing.*;
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

    @FXML
    void LogInClick(ActionEvent event) {
        changePage(event, "login");
    }

    @FXML
    void RegisterClick(ActionEvent event) {
        changePage(event, "login");

        System.out.println(tanggalLahir.getValue().toString());
    boolean status = User.insertUser(Name.getText(),username.getText(),password.getText(),email.getText(),noHP.getText(),tanggalLahir.getValue().toString());
        if (status==true){
            JOptionPane.showMessageDialog (null, "Akun anda telah aktif ! Silahkan Masuk !", "BERHASIL", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog (null, "Maaf, terjadi kesalahan dalam mendaftar ! Coba lagi !", "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
    }
}
