/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Colis;
import entities.Livraison;
import java.net.URL;
import javafx.scene.control.TextField;
import service.LivraisonService;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import service.ColisService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLAjoutLivraisonController implements Initializable {

    @FXML
    private TextField tf_AdresseExp;
    @FXML
    private TextField tf_adresseDest;
    @FXML
    private TextField tf_prix;
    @FXML
    private TextField tf_nbrObjets;
    @FXML
    private TextField tf_description;
    @FXML
    private TextField tf_poids;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajoutL(ActionEvent event) {
        LivraisonService ls = new LivraisonService();
        ColisService cs = new ColisService();
        String prix=tf_prix.getText();
        Livraison l = new Livraison(tf_AdresseExp.getText(), tf_adresseDest.getText(),Float.parseFloat(prix) );
        String nb_items=tf_nbrObjets.getText();
        String poids=tf_poids.getText();
        Colis c = new Colis(Integer.parseInt(nb_items),tf_description.getText(), Float.parseFloat(poids));
        ls.ajouter(l);
        cs.ajouter(c);
        System.err.println("Ajout avec succès");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Livraison ajoutée avec succès");
        alert.show();
    }

}
