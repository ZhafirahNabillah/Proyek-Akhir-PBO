package sample.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Admin_Dashboard {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPostArticle;

    @FXML
    private Button btnPsikolog;

    @FXML
    private Tab userPage;

    @FXML
    private Button btnActivity;

    @FXML
    private Button btnActivity1;

    @FXML
    private Button btnActivity11;

    @FXML
    void ShowUser(ActionEvent event) {

    }

    @FXML
    void clickActivity(ActionEvent event) {

    }

    @FXML
    void clickBtnHome(ActionEvent event) {

    }

    @FXML
    void clickBtnPsikolog(ActionEvent event) {

    }

    @FXML
    void clickPostArticle(ActionEvent event) {

    }

    public void clickBtnHome(javafx.event.ActionEvent event) {
    }

    public void clickPostArticle(javafx.event.ActionEvent event) {
    }

    public void clickBtnPsikolog(javafx.event.ActionEvent event) {
    }

    public void ShowUser(Event event) {
        ShowPsikologTable();
    }

    public void clickActivity(javafx.event.ActionEvent event) {
    }
    void ShowPsikologTable(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/admin_Dashboard2.fxml"));
            Parent root = loader.load();

            Admin_Dashboard2 admin_dashboard2 = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
