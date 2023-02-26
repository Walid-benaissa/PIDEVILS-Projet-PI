/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import service.ReclamationService;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLEffectuerReclamationController implements Initializable {

    @FXML
    private ChoiceBox choix_type;
    
    private String[] types={"Livraison","Location","Course"};
    @FXML
    private TextArea ta_msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choix_type.getItems().addAll(types);
        choix_type.setValue("Livraison");
    }    

    @FXML
    private void effectuerReclamation(ActionEvent event) {
        ReclamationService rs=new ReclamationService();
        Reclamation r=new Reclamation(1, 1, ta_msg.getText(), "Ouvert");
        rs.ajouter(r);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Reclamation ajouté avec succés");
        alert.show();
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
    

