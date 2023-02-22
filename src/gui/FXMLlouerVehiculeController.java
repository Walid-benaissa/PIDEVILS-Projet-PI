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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLlouerVehiculeController implements Initializable {

    @FXML
    private RadioButton voitureBtn;
    @FXML
    private ToggleGroup role;
    @FXML
    private RadioButton trottinetteBtn;
    @FXML
    private RadioButton veloBtn;
    @FXML
    private TextField tf_lieu_de_depart;
    @FXML
    private TextField tf_ddepart;
    @FXML
    private TextField tf_dretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void remise(ActionEvent event) {
    }

    @FXML
    private void rechercher(ActionEvent event) {
      
    
    
}
}
