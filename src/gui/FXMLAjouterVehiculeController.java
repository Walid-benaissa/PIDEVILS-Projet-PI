/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.VehiculeService;

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
    @FXML
    private TextField txttype;
        @FXML
    private Button btnAjouter;
        private VehiculeService VehiculeService = new VehiculeService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterV(ActionEvent event) {
          VehiculeService sp=new VehiculeService();
          String nom_v =txtnomv.getText();
          String ville = txtville.getText();
          String photo = txtphoto.getText();
          float prix = Float.parseFloat(txtprix.getText());
          String type = txttype.getText();
          String description = txtdesc.getText();
     
         
 
   Vehicule a = new Vehicule(nom_v,  photo,  ville,  prix,  description,  type);
   sp.ajouter(a);
    }
    
}
