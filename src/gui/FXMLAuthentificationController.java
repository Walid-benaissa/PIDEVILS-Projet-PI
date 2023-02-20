/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLAuthentificationController implements Initializable {

    @FXML
    private TextField tf_mail;
    @FXML
    private TextField tf_mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void authentification(ActionEvent event) {
        UtilisateurService us= new UtilisateurService();
            boolean res=us.authentification(tf_mail.getText(), tf_mdp.getText());
            if(res){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setContentText("Authentification avec succés");
            alert.show();
            }
            else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("Authentification échoué");
            alert.show();}
        }
    }
    
