/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import utils.CommonController;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLSideBarConducteurController extends CommonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void routeGererProfil(ActionEvent event) {
        try {  
            setSceneContent("FXMLGererProfil");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeGererReclamation(ActionEvent event) { 
        try {  
            setSceneContent("FXMLEffectuerReclamation");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeGererLivraisions(ActionEvent event) {
         try {  
            setSceneContent(" ");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeOffreCourse(ActionEvent event) {
          try {  
            setSceneContent("FXMLOffreCourse");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeGererVoiture(ActionEvent event) { 
        try {
            setSceneContent("FXMLGererVoiture");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deconnexion(ActionEvent event) {
         try {
             Context.getInstance().removeContextObject("UtilisateurCourant");
             Context.getInstance().removeContextObject("Role");
            setSceneContent("FXMLAuthentification");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
