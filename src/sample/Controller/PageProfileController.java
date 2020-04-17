package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class PageProfileController {

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
    private TextField btnSearching;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnSetProfile;

    @FXML
    void clickBtnHome(ActionEvent event) {

    }

    @FXML
    void clickBtnNext(ActionEvent event) {

    }

    @FXML
    void clickBtnPost(ActionEvent event) {

    }

    @FXML
    void clickBtnProfile(ActionEvent event) {

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {

    }

    @FXML
    void clickBtnSetProfile(ActionEvent event) {

    }

    public void clickBtnHome(javafx.event.ActionEvent event) {ShowDashboard();
    }

    public void clickBtnPost(javafx.event.ActionEvent event) {ShowPost();
    }

    public void clickBtnPsikolog(javafx.event.ActionEvent event) {ShowChat();
    }

    public void clickBtnProfile(javafx.event.ActionEvent event) {ShowProfile();
    }

    public void clickBtnNext(javafx.event.ActionEvent event) {ShowbtnNext();
    }

    public void clickBtnSetProfile(javafx.event.ActionEvent event) {Showsetprofile();
    }

    void ShowProfile(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/page_Profile.fxml"));
            Parent root = loader.load();

            PageProfileController page_profile = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    void ShowPost(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/page_Post.fxml"));
            Parent root = loader.load();

            PagePostController page_post= loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    void ShowChat(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/page_Curhat.fxml"));
            Parent root = loader.load();

            PageCurhatController page_curhat = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    void ShowDashboard(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/dashboard.fxml"));
            Parent root = loader.load();

            DashboardController dashboard = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    void ShowbtnNext(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/btn_Next.fxml"));
            Parent root = loader.load();

            DashboardController dashboard = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
    void Showsetprofile(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/set_Profile.fxml"));
            Parent root = loader.load();

            DashboardController dashboard = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }

}
