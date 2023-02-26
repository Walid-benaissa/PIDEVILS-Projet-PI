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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.VehiculeService;

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
    @FXML
    private TextField txtidp;
    @FXML
    private TextField txtphoto;
    @FXML
    private TextField txttype;
    @FXML
    private TextField txtidv;
    @FXML
    private Button btnpromo;
    @FXML
    private VehiculeService VehiculeService = new VehiculeService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierV(ActionEvent event) {
        int id_vehicule = Integer.parseInt(txtidv.getText());
        String nom_v = txtnomv.getText();
        String photo = txtphoto.getText();
        String ville = txtville.getText();
        float prix = Float.parseFloat(txtprix.getText());
        int id_promotion = Integer.parseInt(txtidp.getText());
        String description = txtdesc.getText();
        String type = txttype.getText();
  
           VehiculeService sp=new VehiculeService();
  Vehicule a = new Vehicule(id_vehicule, nom_v, photo, ville, prix,  id_promotion,description,type);
   sp.modifier(a);
    List<Vehicule> vList = VehiculeService.afficheListe();
    }

    @FXML
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
    
}
