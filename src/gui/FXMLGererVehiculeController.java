/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.VehiculeService;
import utils.CommonController;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLGererVehiculeController extends CommonController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnMettreajour;

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
    private TableColumn colonnenom_v;
    @FXML
    private Button btn_excel;
    @FXML
    private Button btn_vehicule;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

//        // Ajoute un listener sur le tableau pour détecter quand une ligne est sélectionnée
//        TableVehicule.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehicule>() {
//            @Override
//            public void changed(ObservableValue<? extends Vehicule> obs, Vehicule oldSelection, Vehicule newSelection) {
//                if (newSelection != null) {
//                    // Récupère le Vehicule sélectionné
//                    Vehicule vehiculeSelectionne = TableVehicule.getSelectionModel().getSelectedItem();
//                    // Charge le fichier FXML de la nouvelle interface
//                    FXMLLoader loader = new FXMLLoader(FXMLGererVehiculeController.this.getClass().getResource("FXMLLouerV.fxml"));
//                    Parent root;
//                    try {
//                        root = loader.load();
//                    } catch (IOException ex) {
//                        Logger.getLogger(FXMLGererVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
//                        return;
//                    }   // Obtient le contrôleur de la nouvelle interface
//                    FXMLLouerVController controller = loader.getController();
//                    // Configure le contrôleur avec les données du Vehicule sélectionné
//                    controller.initialiserAvecVehicule(vehiculeSelectionne);
//                    // Charge la nouvelle interface dans une nouvelle fenêtre
//                    Scene scene = new Scene(root);
//                    Stage stage = new Stage();
//                    stage.setScene(scene);
//                    stage.show();
//                }
//            }
//        }}
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
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        Vehicule selectedVehicule = TableVehicule.getSelectionModel().getSelectedItem();

        Context.getInstance().addContextObject("Vehicule", selectedVehicule);
        try {
            setSceneContent("FXMLModifierVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Vehicule v = TableVehicule.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    public void handleExport() throws Exception {
    
    PrintWriter writer = new PrintWriter( new OutputStreamWriter(new FileOutputStream("C:\\pi\\PIDEVILS-Projet-PI\\vehicule.csv"), "UTF-8"));

VehiculeService sp = new VehiculeService();
        
        List<Vehicule> vehicule = sp.afficheListe();
       writer.write("Nom,Type,ville,Description\n");
               for (Vehicule obj : vehicule) {
                   
            writer.write(obj.getNom_v().toString());
            writer.write(",");
            writer.write(obj.getType().toString());
            writer.write(",");
            writer.write(obj.getVille().toString());
            writer.write(",");
             writer.write(obj.getDescription().toString());
            writer.write("\n");

               }
               writer.flush();
               writer.close();
               
               Notifications notifications=Notifications.create();
        notifications.text("fichier telecharger");
        notifications.title("fchier Enregistée");
        notifications.hideAfter(Duration.seconds(10));
        notifications.darkStyle();
        notifications.position(Pos.BOTTOM_RIGHT);
        notifications.show();
}

    @FXML
    private void louer(ActionEvent event) {
          try {
            setSceneContent("FXMLVehiculeLouer");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
