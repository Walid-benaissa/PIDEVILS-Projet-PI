/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import service.VehiculeService;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLAjouterVehiculeController implements Initializable {


    @FXML
    private TextField tf_id_vehicule;
    @FXML
    private TextField tf_prix;
    @FXML
    private TextField tf_ville;
    @FXML
    private TextField tf_description;
    @FXML
    private TextField tf_type;
    @FXML
    private TextField tf_photo;
    

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
        VehiculeService sp=new VehiculeService();

  
        String id_vehicule = tf_id_vehicule.getText();
        float prix = Float.parseFloat(tf_prix.getText());
        String ville = tf_ville.getText();
        String description = tf_description.getText();
        String photo = tf_photo.getText();
        String type = tf_type.getText();
         
         
     
   Vehicule a = new Vehicule( id_vehicule,  photo,  ville,  prix,  description,  type);
   sp.ajouter(a);
    }
    
}
