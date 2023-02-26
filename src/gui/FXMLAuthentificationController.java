/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UtilisateurService;
import utils.CommonController;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLAuthentificationController extends CommonController implements Initializable {

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
        UtilisateurService us = new UtilisateurService();
        Utilisateur user = us.authentification(tf_mail.getText(), tf_mdp.getText());
        if (user.getId() != 0) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("Authentification avec succés");
                alert.show();
                Context.getInstance().addContextObject("UtilisateurCourant", user);
                setSceneContent("FXMLGererProfil");
            } catch (IOException ex) {
                Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("Authentification échoué");
            alert.show();
        }
    }

    @FXML
    private void inscrire(ActionEvent event) {
        try {
            setSceneContent("FXMLCreationCompte");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
