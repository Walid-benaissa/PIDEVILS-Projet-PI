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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import service.VehiculeService;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLAjouterVehiculeController implements Initializable {

    @FXML
    private TextField txtdesc;
    @FXML
    private TextField txtnomv;
    @FXML
    private TextField txtville;
    @FXML
    private TextField txtprix;
    @FXML
    private TextField txtphoto;
    private TextField txttype;
        @FXML
    private Button btnAjouter;
        private VehiculeService VehiculeService = new VehiculeService();
    @FXML
   private ChoiceBox choix_type;
       private String[] type = {"voiture", "velo", "trottinette"};
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                    choix_type.getItems().addAll(type);
            choix_type.setValue("voiture");

    }    

    @FXML
    private void AjouterV(ActionEvent event) {
          VehiculeService sp=new VehiculeService();
          String nom_v =txtnomv.getText();
          String ville = txtville.getText();
          String photo = txtphoto.getText();
          float prix = Float.parseFloat(txtprix.getText());
          String type = (String) choix_type.getValue();
          String description = txtdesc.getText();
     
         
 
   Vehicule a = new Vehicule(nom_v,  photo,  ville,  prix,  description,  type);
   sp.ajouter(a);
    }

    @FXML
    private void back(ActionEvent event) {
        
        try {  
            setSceneContent("FXMLGererVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

