/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import static utils.CommonController.setSceneContent;

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
    private DatePicker tf_dated;
    @FXML
    private DatePicker tf_retourd;

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
      
    
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLVehicule.fxml"));
            
            Scene sc = new Scene(root);
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLlouerVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
            setSceneContent("FXMLAjoutLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeGererCourse(ActionEvent event) {
         try {  
            setSceneContent("FXMLCourse");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeGererLocation(ActionEvent event) {
        try {  
            setSceneContent("FXMLlouerVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
