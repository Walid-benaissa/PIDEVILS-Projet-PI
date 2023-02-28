/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.ReclamationService;
import service.UtilisateurService;
import utils.CommonController;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLGererReclamationController extends CommonController implements Initializable {

    @FXML
    private TableView<Reclamation> reclamationTable;
    @FXML
    private TableColumn<?, ?> id_reclamationCol;
    @FXML
    private TableColumn<?, ?> etatCol;
    @FXML
    private TableColumn<?, ?> messageCol;
    @FXML
    private TableColumn<?, ?> IdUsrCol;
    ReclamationService rs = new ReclamationService();
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField idRec;
    @FXML
    private ChoiceBox choix_type;
    
    UtilisateurService us=new UtilisateurService();

    private String[] etats = {"Ouvert", "En cours", "Traite"};
    @FXML
    private TableColumn<?, ?> IdUsrCol1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherReclamation();
        choix_type.getItems().addAll(etats);
    }

    public void afficherReclamation() {
        List<Reclamation> list = rs.afficheListe();
        id_reclamationCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        etatCol.setCellValueFactory(new PropertyValueFactory<>("etat"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        IdUsrCol.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        ObservableList<Reclamation> L = FXCollections.observableArrayList(list);
        reclamationTable.setItems(L);
    }

    @FXML
    private void supprimerReclamation(ActionEvent event) {
        Reclamation r = new Reclamation(reclamationTable.getSelectionModel().getSelectedItem().getId());
        rs.supprimer(r);
        afficherReclamation();
    }

    @FXML
    private void modifierReclamation(ActionEvent event) {
        Reclamation c = reclamationTable.getSelectionModel().getSelectedItem();
        c.setEtat(choix_type.getValue().toString());
        rs.modifier(c);
        afficherReclamation();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Reclamation c = reclamationTable.getSelectionModel().getSelectedItem();
        idRec.setText("Id: " + c.getId());
        choix_type.setValue(c.getEtat());
    }



}
