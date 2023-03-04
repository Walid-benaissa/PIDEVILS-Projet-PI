/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import entities.Utilisateur;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.ReclamationService;
import utils.CommonController;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLConsulterReclamationsController extends CommonController implements Initializable {

    @FXML
    private TableView<Reclamation> reclamationTable;
    @FXML
    private TableColumn<?, ?> etatCol;
    @FXML
    private TableColumn<?, ?> messageCol;
    @FXML
    private TableColumn<?, ?> typeCol;

    ReclamationService rs = new ReclamationService();
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    @FXML

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherReclamation(rs.afficheListeByUser(u.getId()));
    }

    public void afficherReclamation(List<Reclamation> l) {
        etatCol.setCellValueFactory(new PropertyValueFactory<>("etat"));
        messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
        ObservableList<Reclamation> L = FXCollections.observableArrayList(l);
        reclamationTable.setItems(L);
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Reclamation c = reclamationTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void effectuerReclamation(ActionEvent event) {
        try {
            setSceneContent("FXMLEffectuerReclamation");
        } catch (IOException ex) {
            Logger.getLogger(FXMLConsulterReclamationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
