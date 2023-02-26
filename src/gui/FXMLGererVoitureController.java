/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Voiture;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.VoitureService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLGererVoitureController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnMettreajour;
    @FXML
    private ImageView IDimage;
    @FXML
    private Label affichage;
    VoitureService vs = new VoitureService();
    Voiture v = vs.afficheVoiture(3);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (v.getImmatriculation() != null) {
            btnAjouter.setDisable(true);
            affichage.setText("Immatriculation :  " + v.getImmatriculation() + "\n"
                    + "Modele :  " + v.getModele() + "\n" + "Marque :  " + v.getMarque() + "\n"
                    + "Etat :  " + v.getEtat() + "\n");
        } else {
            btnSupprimer.setDisable(true);
            btnMettreajour.setDisable(true);
            affichage.setText("Aucune voiture");
        }

    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLAjouterVoiture.fxml"));
            Scene sc = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        vs.supprimer(v);
        affichage.setText("Aucune voiture");
        btnAjouter.setDisable(false);
        btnSupprimer.setDisable(true);
        btnMettreajour.setDisable(true);

    }

    @FXML
    private void Metrreajour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLModifierVoiture.fxml"));
            Scene sc = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
