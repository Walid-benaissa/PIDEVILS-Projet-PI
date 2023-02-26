/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import entities.Voiture;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.UtilisateurService;
import service.VoitureService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLAfficherVoitureAdminController implements Initializable {

    @FXML
    private TableView TableVoitures;
    @FXML
    private TableColumn<?, ?> immatriculationCol;
    @FXML
    private TableColumn<?, ?> nomCol;
    @FXML
    private TableColumn<?, ?> prenomCol;
    @FXML
    private TableColumn<?, ?> etatCol;
    @FXML
    private TableColumn<?, ?> modeleCol;
    @FXML
    private TableColumn<?, ?> marqueCol;
    VoitureService vs = new VoitureService();
    UtilisateurService us = new UtilisateurService();
    @FXML
    private TableView TableUsers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Voiture> v = vs.afficheListe();
         List<Utilisateur> u = us.afficheListe();
         nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        immatriculationCol.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        etatCol.setCellValueFactory(new PropertyValueFactory<>("etat"));
        modeleCol.setCellValueFactory(new PropertyValueFactory<>("modele"));
        marqueCol.setCellValueFactory(new PropertyValueFactory<>("marque"));
        ObservableList<Utilisateur> Lu = FXCollections.observableArrayList(u);
        TableUsers.setItems(Lu);
       ObservableList<Voiture> L = FXCollections.observableArrayList(v);
        TableVoitures.setItems(L);
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {

    }

}
