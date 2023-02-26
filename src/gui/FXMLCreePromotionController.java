/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Promotion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.PromotionService;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLCreePromotionController implements Initializable {

    @FXML
    private Button btnmodifier;
    @FXML
    private TextField txtid_v;
    @FXML
    private TextField txtlibillé;
    @FXML
    private Button btnAjouter;
    @FXML
    private TextField txttaux;
        private PromotionService PromotionService = new PromotionService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Modifier(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLModifierPromotion.fxml"));
            
            Scene sc = new Scene(root);
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLCreePromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ajouter(ActionEvent event) {
          PromotionService sp=new PromotionService();
          String libelle =txtlibillé.getText();
          float taux = Float.parseFloat(txttaux.getText());
       int id_vehicule = Integer.parseInt(txtid_v.getText());
        
     
         
 
   Promotion a = new Promotion( id_vehicule,libelle, taux);
   sp.ajouter(a);
    }
    
}
