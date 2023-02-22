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
    private ToggleGroup role;
    @FXML
    private RadioButton veloBtn;
    @FXML
    private RadioButton trottinetteBtn;
    @FXML
    private RadioButton voitureBtn;
    @FXML
    private TextField tf_id_vehicule;
    @FXML
    private TextField tf_prix;
    @FXML
    private TextField tf_ville;
    @FXML
    private TextField tf_description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
         VehiculeService vs= new VehiculeService();
        String role="";
         Vehicule v1 = new Vehicule(tf_id_vehicule.getText(), tf_prix.getText(), tf_ville.getText(), tf_description.getText(), role,0.0F);
            vs.ajouter(v1);
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("ajout avec succés");
            alert.show();
        if(veloBtn.isSelected())
            role="velo";
        else if (trottinetteBtn.isSelected())
            role="trottinette";
        else 
             role="voiture";
   
       


    }
    
}
