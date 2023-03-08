/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bough
 */
public class FXMLMapController implements Initializable {
     Connection connexion ;
     Statement stm;
     private Stage stage;
      private Stage stage1;
     private Scene scene;
     private Parent root;

    @FXML
    private Button btnRetour;
    @FXML
    private WebView webView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        webView.getEngine().load("https://www.google.com/maps");
       
    }    


    @FXML
    private void Retour(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gui/FXMLCourse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /* private void MapView(MouseEvent event) {
    WebView webView = new WebView();
    webView.getEngine().load("https://www.google.com/maps");
    
    Scene scene = new Scene(webView, 800, 600);
    stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage1.setScene(scene);
    stage1.show();
    }*/
    
}
