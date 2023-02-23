/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import service.VehiculeService;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLVehiculeController implements Initializable {

    @FXML
    private TableColumn  prix;
    @FXML
    private Text txtout;
    @FXML
    private TableColumn  v1;
    @FXML
    private TableView<Vehicule> tab;
  
    private VehiculeService VehiculeService = new VehiculeService();
    @FXML
    private TableView<Vehicule> pprix;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        v1.setCellValueFactory(new PropertyValueFactory<>("description"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
      

            // récupère les données des utilisateurs depuis la base de données
            List<Vehicule> vleList = VehiculeService.afficheListe();
            
      
        
        // affiche les données dans le tableau
        tab.getItems().setAll(vleList);
        pprix.getItems().setAll(vleList);

    }    

    @FXML
    private void Selectionner(ActionEvent event) {
    }

    
    
  
     
  
        
    }

