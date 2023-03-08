/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Location;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.LocationService;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLVehiculeLouerController implements Initializable {

    @FXML
    private TableView<Location> TableVehicule;
    private LocationService LocationService = new LocationService();
    @FXML
    private TableColumn<?, ?> colonnecontrat;
    @FXML
    private TableColumn<?, ?> colonnnevehicule;
    @FXML
    private TableColumn<?, ?> colonnedated;
    @FXML
    private TableColumn<?, ?> datef;
    @FXML
    private TableColumn<?, ?> lieu;
    @FXML
    private TableColumn<?, ?> colonneville1;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                colonnecontrat.setCellValueFactory(new PropertyValueFactory<>("id_contrat"));
        colonnnevehicule.setCellValueFactory(new PropertyValueFactory<>("id_vehicule "));
        colonnedated.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        datef.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
   

        // récupère les données des utilisateurs depuis la base de données
        List<Location> vleList = LocationService.afficheListe();

        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vleList);
        // TODO
    }    

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
         try {
            setSceneContent("FXMLGererVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
