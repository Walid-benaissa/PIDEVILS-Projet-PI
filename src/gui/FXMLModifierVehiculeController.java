/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.VehiculeService;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLModifierVehiculeController implements Initializable {

    @FXML
    private Button btnModifier;
    @FXML
    private TextField txtdesc;
    @FXML
    private TextField txtnomv;
    @FXML
    private TextField txtville;
    @FXML
    private TextField txtprix;
    private TextField txtidp;
    @FXML
    private TextField txtphoto;
    private TextField txttype;
    private TextField txtidv;
    private VehiculeService VehiculeService = new VehiculeService();
    @FXML
    private ChoiceBox choix_id;
      private String[] id = {"0","5", "10", "15","20", "25", "30","35", "40", "45","50", "55", "60","65", "70", "85","90"};
    @FXML
    private ChoiceBox choix_taux;
       private String[] taux = {"0","5", "10", "15","20", "25", "30","35", "40", "45","50", "55", "60","65", "70", "85","90"};
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
           choix_id.getItems().addAll(id);
            choix_type.getItems().addAll(type);
            choix_type.setValue("voiture");

            choix_taux.getItems().addAll(taux);
    }    

    @FXML
    private void ModifierV(ActionEvent event) {
        int id_vehicule = Integer.parseInt((String) choix_id.getValue());
        String type = (String) choix_type.getValue();
        String nom_v = txtnomv.getText();
        String photo = txtphoto.getText();
        String ville = txtville.getText();
        float prix = Float.parseFloat(txtprix.getText());
        int taux = Integer.parseInt((String) choix_taux.getValue());
        String description = txtdesc.getText();
 
  
           VehiculeService sp=new VehiculeService();
  Vehicule a = new Vehicule(id_vehicule, nom_v, photo, ville, prix,taux,description,type);
   sp.modifier(a);
    List<Vehicule> vList = VehiculeService.afficheListe();
    }

    private void promotion(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLCreePromotion.fxml"));
            
            Scene sc = new Scene(root);
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLModifierVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
