/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.LivraisonColis;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.LivraisonService;
import utils.CommonController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLModifierLivraisonController extends CommonController  implements Initializable {

    @FXML
    private TextField AdExp;
    @FXML
    private TextField AdDest;
    @FXML
    private TextField Prix;
    @FXML
    private TextField NbObj;
    @FXML
    private TextField tf_description;
    @FXML
    private TextField poids;
     LivraisonService ls = new LivraisonService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

   /* @FXML
    private void Modifier(ActionEvent event) {
        LivraisonColis l = table2.getSelectionModel().getSelectedItem();
        

        l.setAdresse_expedition(AdExp.getText());
        l.setAdresse_destinataire(AdDest.getText());
        String prix2 = Prix.getText();
        l.setPrix(Float.parseFloat(prix2));
       // l.setEtat(etat.getText());
         String Nb_items = NbObj.getText();
        l.setNb_items(Integer.parseInt(Nb_items));
        String poids2 = poids.getText();
        l.setPoids(Float.parseFloat(poids2));
        l.setDescription(tf_description.getText()); 
        ls.modif(l);
        //afficher();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Livraison Modifiée avec succès");
        alert.show();

        AdExp.setText("");
        AdDest.setText("");
        Prix.setText("");
       // etat.setText("");
  
        NbObj.setText("");
        poids.setText("");
        tf_description.setText("");
    }*/

    @FXML
    private void Modifier(ActionEvent event) {
    }
    
}
