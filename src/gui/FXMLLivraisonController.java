/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.control.TableColumn;
import entities.Colis;
import entities.Livraison;
import java.net.URL;
import javafx.scene.control.TextField;
import service.LivraisonService;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ColisService;
import entities.Livraison;
import entities.Colis;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLivraisonController implements Initializable {

    @FXML
    private TableColumn<Livraison, String> tfAdresseExp;
    @FXML
    private TableColumn<Livraison, String> tfAdresseDest;
    @FXML
    private TableColumn<Livraison, Float> tfPrix;
    @FXML
    private TableColumn<Livraison, String> TfEtat;
    @FXML
    private TableColumn<Colis, Integer> tfNBObj;
    @FXML
    private TableColumn<Colis, String> tfDescription;
    @FXML
    private TableColumn<Colis, Float> tfPoids;
    private ObservableList<Livraison> dataList = FXCollections.observableArrayList();
    private ObservableList<Colis> dataList2 = FXCollections.observableArrayList();


    @FXML
    private TableView<Colis> table;
    @FXML
   private TableView<Livraison> table2;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public ObservableList<Livraison> getLivraison(List<Livraison> l){
        ObservableList<Livraison> dataList = FXCollections.observableArrayList();
        for (int i =0; i<=l.size()-1; i++){
            dataList.add(l.get(i));
        }
        return dataList;
    }
       public ObservableList<Colis> getColis(List<Colis> c){
        ObservableList<Colis> dataList2 = FXCollections.observableArrayList();
        for (int i =0; i<=c.size()-1; i++){
            dataList2.add(c.get(i));
        }
        return dataList2;
    }
    @FXML
    private void Afficher() throws SQLException {
        LivraisonService ls = new LivraisonService(){};
        ColisService cs = new ColisService(){};
        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<Livraison, String>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<Livraison, String>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<Livraison, Float>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<Livraison, String>("etat"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<Colis, Integer>("nb_items"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<Colis, String>("description"));
        tfPoids.setCellValueFactory(new PropertyValueFactory<Colis, Float>("poids"));
        table2.setItems(getLivraison(ls.afficheListe()));
        table.setItems(getColis(cs.afficheListe()));
    }
    
   /* private void delete(ActionEvent event) throws SQLException {
        LivraisonService ls = new LivraisonService(){};
        int l=Integer.parseInt(deletefield.getText());
        ls.supprimer(l);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Livraison supprimée avec succès");
        alert.show();
    }
    
*/

}
