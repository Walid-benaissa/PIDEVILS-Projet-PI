/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLGererUtilisateursController implements Initializable {

    @FXML
    private TableView<Utilisateur> TableUsers;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> nomCol;
    @FXML
    private TableColumn<?, ?> prenomCol;
    @FXML
    private TableColumn<?, ?> mailCol;
    @FXML
    private TableColumn<?, ?> numtelCol;
    @FXML
    private TableColumn<?, ?> roleCol;
    @FXML
    private TableColumn<?, ?> evaluationCol;
    @FXML
    private TextField txtID;
    @FXML
    private Button btnSupprimer;
    UtilisateurService us = new UtilisateurService();
    private String[] roles = {"Client", "Conducteur", "Locateur"};
    @FXML
    private ChoiceBox choix_type;
    @FXML
    private Button btnModifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherUsers();
        choix_type.getItems().addAll(roles);

    }

    public void afficherUsers() {
        List<Utilisateur> list = us.afficheListe();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        mailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
        numtelCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        evaluationCol.setCellValueFactory(new PropertyValueFactory<>("evaluation"));
        ObservableList<Utilisateur> L = FXCollections.observableArrayList(list);
        TableUsers.setItems(L);

    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Utilisateur u = TableUsers.getSelectionModel().getSelectedItem();
        txtID.setText("Id: " + u.getId());
        choix_type.setValue(u.getRole());

    }

    @FXML
    private void Supprimer(ActionEvent event) {
        Utilisateur u = new Utilisateur(TableUsers.getSelectionModel().getSelectedItem().getId());
        us.supprimer(u);
        afficherUsers();
    }

    @FXML
    private void modifierReclamation(ActionEvent event) {
        Utilisateur u = TableUsers.getSelectionModel().getSelectedItem();
        u.setRole(choix_type.getValue().toString());
        us.modifier(u);
        afficherUsers();

    }

    @FXML
    private void routeGererUser(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLGererUtilisateurs.fxml"));
            Scene sc = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeGererLivraisions(MouseEvent event) {
    }

    @FXML
    private void routeGererUser(ActionEvent event) {
        
    }

    @FXML
    private void routeGererLivraisions(ActionEvent event) {
    }

    @FXML
    private void routeGererReclamation(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLGererReclamation.fxml"));
            Scene sc = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void routeGererReclamation(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLGererReclamation.fxml"));
            Scene sc = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
