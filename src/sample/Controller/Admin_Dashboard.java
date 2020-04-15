package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button btnActivity;

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
    void ShowDashboardAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/admin_Dashboard.fxml"));
            Parent root = loader.load();

            Admin_Dashboard admin_dashboard = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void clickActivity(javafx.event.ActionEvent event) {
    }

    public void clickBtnPsikolog(javafx.event.ActionEvent event) {
    }

    public void clickPostArticle(javafx.event.ActionEvent event) {
    }

    public void clickBtnHome(javafx.event.ActionEvent event) {
    }
}
