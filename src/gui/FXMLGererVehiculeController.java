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
import java.util.Optional;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.VehiculeService;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLGererVehiculeController implements Initializable {

    
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnMettreajour;
    @FXML
    private TableColumn colonneidvehicule;
    private TableColumn colonnecin;
    @FXML
    private TableColumn colonnephoto;
    @FXML
    private TableColumn colonneville;
    @FXML
    private TableColumn PrixColone;
    @FXML
    private TableColumn colonneidPROMOTION;
    @FXML
    private TableColumn colonnedescription;
    @FXML
    private TableColumn colonnetype;
    @FXML
    private TableView<Vehicule> TableVehicule;
    private VehiculeService VehiculeService = new VehiculeService();
    @FXML
    private TableColumn colonneid;
    @FXML
    private TableColumn colonnenom_v;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        colonneidvehicule.setCellValueFactory(new PropertyValueFactory<>("id_vehicule"));
        
        colonneid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colonnephoto.setCellValueFactory(new PropertyValueFactory<>("photo"));
        colonneville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        PrixColone.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colonneidPROMOTION.setCellValueFactory(new PropertyValueFactory<>("id_promotion"));
        colonnedescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colonnetype.setCellValueFactory(new PropertyValueFactory<>("type"));
         colonnenom_v.setCellValueFactory(new PropertyValueFactory<>("nom_v"));

            // récupère les données des utilisateurs depuis la base de données
            List<Vehicule> vleList = VehiculeService.afficheListe();
            
      
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vleList);
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
        /*   VehiculeService sp=new VehiculeService();
         
           String id_vehicule = txtid_vehicule.getText();
       int id = Integer  .parseInt(txtid.getText());
           String photo = txtphoto.getText();
           String ville = txtville.getText();
        float prix = Float.parseFloat(txtprix.getText());
        int id_promotion = Integer  .parseInt(txtid_promotion.getText());
        String description = txtdescription.getText();
        String type = txttype.getText();
         
        
   Vehicule a = new Vehicule(id_vehicule,nom_v ,  id,  photo,  ville,  prix,  id_promotion,  description,  type);
   sp.ajouter(a);
         
     


   List<Vehicule> vList = VehiculeService.afficheListe();
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vList);*/
           
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLAjouterVehicule.fxml"));
            
            Scene sc = new Scene(root);
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
           Vehicule selectedVehicule = TableVehicule.getSelectionModel().getSelectedItem();
       
        if (selectedVehicule == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No user selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a user in the table.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm deletion");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected user?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println(selectedVehicule);
            VehiculeService.supprimer(selectedVehicule);
             List<Vehicule> vvlist = VehiculeService.afficheListe();
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vvlist);
        }
    }

     @FXML
    private void Metrreajour(ActionEvent event) {
        /*                    String id_vehicule = txtid_vehicule.getText();
           int id = Integer  .parseInt(txtid.getText());
           String photo = txtphoto.getText();
           String ville = txtville.getText();
        float prix = Float.parseFloat(txtprix.getText());
        int id_promotion = Integer  .parseInt(txtid_promotion.getText());
        String description = txtdescription.getText();
        String type = txttype.getText();
         
        VehiculeService sp=new VehiculeService();
  Vehicule a = new Vehicule(id_vehicule,  id,  photo,  ville,  prix,  id_promotion,  description,  type);
   sp.modifier(a);
 List<Vehicule> vList = VehiculeService.afficheListe();
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vList);}*/
      try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLModifierVehicule.fxml"));
            
            Scene sc = new Scene(root);
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    

  
    
}

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }
}
