/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Location;
import entities.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import service.LocationService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLlouerVehiculeController implements Initializable {

    @FXML
    private TextField tf_lieu_de_depart;
    @FXML
    private DatePicker tf_dated;
    @FXML
    private DatePicker tf_retourd;
           private LocationService LocationService = new LocationService();
    @FXML
    private ChoiceBox choix_type;
    private String[] type = {"voiture", "velo", "trottinette"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                choix_type.getItems().addAll(type);
            choix_type.setValue("voiture");
    }    

    @FXML
    private void remise(ActionEvent event) {
                    LocationService sp=new LocationService();
          String lieu =tf_lieu_de_depart.getText();
              Date date_debut = java.sql.Date.valueOf(tf_dated.getValue());
     Date date_fin = java.sql.Date.valueOf(tf_retourd.getValue());
    String type = (String) choix_type.getValue();
     
Context.getInstance().addContextObject("DateF",date_fin);
Context.getInstance().addContextObject("DateD",date_debut);
Context.getInstance().addContextObject("lieu",lieu);
Context.getInstance().addContextObject("type",type);


//   Location a = new Location( date_debut, date_fin,  lieu);
//   sp.ajouter(a);
//      
        try {
            setSceneContent("FXMLVehiculePromotion");
        } catch (IOException ex) {
            Logger.getLogger(FXMLlouerVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void rechercher(ActionEvent event) {
        
                LocationService sp=new LocationService();
          String lieu =tf_lieu_de_depart.getText();
              Date date_debut = java.sql.Date.valueOf(tf_dated.getValue());
     Date date_fin = java.sql.Date.valueOf(tf_retourd.getValue());
    String type = (String) choix_type.getValue();
     
Context.getInstance().addContextObject("DateF",date_fin);
Context.getInstance().addContextObject("DateD",date_debut);
Context.getInstance().addContextObject("lieu",lieu);
Context.getInstance().addContextObject("type",type);


//   Location a = new Location( date_debut, date_fin,  lieu);
//   sp.ajouter(a);
//      
        try {
            setSceneContent("FXMLVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLlouerVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

}
