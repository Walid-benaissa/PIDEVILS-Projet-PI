/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.VehiculeService;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLVehiculeAdmineController implements Initializable {

    @FXML
    private TextField txtid_vehicule;
    @FXML
    private TextField txtcin;
    @FXML
    private TextField txtphoto;
    @FXML
    private TextField txtdescription;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnMettreajour;
    @FXML
    private TableColumn colonneidvehicule;
    @FXML
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
    private TextField txtville;
    @FXML
    private TextField txtprix;
    @FXML
    private TextField txtid_promotion;
    @FXML
    private TextField txttype;
    @FXML
    private TableView<Vehicule> TableVehicule;
    private VehiculeService VehiculeService = new VehiculeService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        colonneidvehicule.setCellValueFactory(new PropertyValueFactory<>("id_vehicule"));
        colonnecin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        colonnephoto.setCellValueFactory(new PropertyValueFactory<>("photo"));
        colonneville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        PrixColone.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colonneidPROMOTION.setCellValueFactory(new PropertyValueFactory<>("id_promotion"));
        colonnedescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colonnetype.setCellValueFactory(new PropertyValueFactory<>("type"));

            // récupère les données des utilisateurs depuis la base de données
            List<Vehicule> vleList = VehiculeService.afficheListe();
            
      
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vleList);
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
         VehiculeService sp=new VehiculeService();
         
           String id_vehicule = txtid_vehicule.getText();
           String cin = txtcin.getText();
           String photo = txtphoto.getText();
           String ville = txtville.getText();
        float prix = Float.parseFloat(txtprix.getText());
        int id_promotion = Integer  .parseInt(txtid_promotion.getText());
        String description = txtdescription.getText();
        String type = txttype.getText();
         
        
   Vehicule a = new Vehicule(id_vehicule,  cin,  photo,  ville,  prix,  id_promotion,  description,  type);
   sp.ajouter(a);
         
     


   List<Vehicule> vList = VehiculeService.afficheListe();
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vList);
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
                     String id_vehicule = txtid_vehicule.getText();
           String cin = txtcin.getText();
           String photo = txtphoto.getText();
           String ville = txtville.getText();
        float prix = Float.parseFloat(txtprix.getText());
        int id_promotion = Integer  .parseInt(txtid_promotion.getText());
        String description = txtdescription.getText();
        String type = txttype.getText();
         
        VehiculeService sp=new VehiculeService();
  Vehicule a = new Vehicule(id_vehicule,  cin,  photo,  ville,  prix,  id_promotion,  description,  type);
   sp.modifier(a);
 List<Vehicule> vList = VehiculeService.afficheListe();
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vList);}

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }
    
}
