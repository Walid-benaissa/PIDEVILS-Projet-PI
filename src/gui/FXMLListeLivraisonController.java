/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livraison;
import entities.LivraisonColis;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.LivraisonService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLListeLivraisonController implements Initializable {

    @FXML
    private TableView<Livraison> table2;
    @FXML
    private TableColumn<?, ?> tfAdresseExp;
    @FXML
    private TableColumn<?, ?> tfAdresseDest;
    @FXML
    private TableColumn<?, ?> tfPrix;
    @FXML
    private TableColumn<?, ?> tfNBObj;
    @FXML
    private TableColumn<?, ?> tfPoids;
    @FXML
    private TableColumn<?, ?> tfDescription;
    @FXML
    private TableColumn<?, ?> TfEtat;
     LivraisonService ls = new LivraisonService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
            afficher();
       
    }    

    @FXML
    private void getSelected(MouseEvent event) {
    }

       public ObservableList<LivraisonColis> getLivraisonColis (List<LivraisonColis> l) {
        ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }
   
        public void afficher() {

        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<>("nb_items"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tfPoids.setCellValueFactory(new PropertyValueFactory<>("poids"));
        table2.setItems(getLivraisonColis(ls.afficher()));


    }
       /*TreeSet<Forum> SortForumByTitle(){
        ServiceForum sf = new ServiceForum();
        TreeSet<Forum> forums =sf.getAllForums().stream().collect(Collectors.toCollection(()-> new TreeSet<Forum>((a,b)->a.getTitre().compareTo(b.getTitre()))));
        return forums;
    }*/
        
        TreeSet<Livraison> SortForumByTitle(){
        LivraisonService sf = new LivraisonService();
        TreeSet<Livraison> livraisons =sf.getAllLivraisons()).stream().collect(Collectors.toCollection(()-> new TreeSet<Livraison>((a,b)->a.getPrix().compareTo(b.getPrix()))));
        return livraisons;
    }

    @FXML
    private void Livrer(ActionEvent event) {
    }
        


    
}
