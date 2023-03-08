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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import service.LivraisonService;
import service.ReclamationService;
import utils.CommonController;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLEffectuerReclamationController extends CommonController implements Initializable {

    @FXML
    private ChoiceBox choix_type;

    private String[] types = {"Livraison", "Location", "Course"};
    @FXML
    private TextArea ta_msg;
    @FXML
    private AnchorPane sidepane;
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    ReclamationService rs = new ReclamationService();
    @FXML
    private Label msg_err;
    @FXML
    private Button btn_effectuer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choix_type.getItems().addAll(types);
        choix_type.setValue("Livraison");
        if (rs.nbrRecParUser(u.getId())>=3){
                msg_err.setVisible(true);
                btn_effectuer.setDisable(true);
        }
        try {
            switch (u.getRole()) {
                case "Client":
                    sidepane.getChildren().add(FXMLLoader.load(getClass().getResource("FXMLSideBarClient.fxml")));
                    break;
                case "Conducteur":
                    sidepane.getChildren().add(FXMLLoader.load(getClass().getResource("FXMLSideBarConducteur.fxml")));
                    break;
                default:
                    sidepane.getChildren().add(FXMLLoader.load(getClass().getResource("FXMLSideBarAdmin.fxml")));
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void effectuerReclamation(ActionEvent event) {
        Reclamation r = new Reclamation(13, u.getId(), ta_msg.getText(), "Ouvert");
        rs.ajouter(r);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Reclamation ajouté avec succés");
        alert.show();
        try {
            setSceneContent("FXMLConsulterReclamations");
        } catch (IOException ex) {
            Logger.getLogger(FXMLEffectuerReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(ActionEvent event) {
         try {
            setSceneContent("FXMLConsulterReclamations");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
