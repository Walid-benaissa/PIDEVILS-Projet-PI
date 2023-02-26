/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import entities.Livraison;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.LivraisonService;


/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLSuivreLiraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    LivraisonService ls = new LivraisonService();
    @FXML
    private TableView<Livraison> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> etat;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Livraison> list = ls.afficheListe();
        id.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        ObservableList<Livraison> L = FXCollections.observableArrayList(list);
        table.setItems(L);
    }    

    @FXML
    private void routeGererProfil(ActionEvent event) {
    }

    @FXML
    private void routeGererReclamation(ActionEvent event) {
    }

    @FXML
    private void routeGererLivraisions(ActionEvent event) {
    }

    @FXML
    private void routeGererCourse(ActionEvent event) {
    }

    @FXML
    private void routeGererLocation(ActionEvent event) {
    }
    
  
    
}
