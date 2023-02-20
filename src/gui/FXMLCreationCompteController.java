/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLCreationCompteController implements Initializable {

    @FXML
    private TextField tf_nom;
    @FXML
    private ToggleGroup role;
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
    @FXML
    private RadioButton conducteurBtn;
    @FXML
    private RadioButton clientBtn;
    @FXML
    private RadioButton locateurBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void creer(ActionEvent event) {
        UtilisateurService us= new UtilisateurService();
        String role="";
        if(locateurBtn.isSelected())
            role="Locateur";
        else if (clientBtn.isSelected())
            role="Client";
        else 
             role="Conducteur";
        if (tf_mdp.getText().equals(tf_mdpC.getText()) ){
        Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_numtel.getText(), tf_mail.getText(), tf_mdp.getText(), role,0.0F);
            us.ajouter(user);
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("creation avec succés");
            alert.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("creation échoué");
            alert.show();}
        }
    
    
}
