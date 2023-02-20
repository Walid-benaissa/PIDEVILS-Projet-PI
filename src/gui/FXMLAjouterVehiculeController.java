/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLAjouterVehiculeController implements Initializable {

    @FXML
    private TextField tf_nom;
    @FXML
    private RadioButton conducteurBtn;
    @FXML
    private ToggleGroup role;
    @FXML
    private RadioButton clientBtn;
    @FXML
    private RadioButton locateurBtn;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_numtel;
    @FXML
    private TextField tf_mail;
    @FXML
    private TextField tf_mdp;
    @FXML
    private TextField tf_mdpC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void creer(ActionEvent event) {
    }
    
}
