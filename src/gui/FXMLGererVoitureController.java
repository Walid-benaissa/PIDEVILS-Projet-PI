/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import entities.Voiture;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.VoitureService;
import utils.CommonController;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLGererVoitureController extends CommonController implements Initializable {

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
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    Voiture v = vs.afficheVoiture(u.getId());

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
        File imageFile = new File(v.getPhoto());
        Image image1 = new Image(imageFile.toURI().toString());
        IDimage.setImage(image1);
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            setSceneContent("FXMLAjouterVoiture");
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
        IDimage.setImage(null);
    }

    @FXML
    private void Metrreajour(ActionEvent event) {
        try {
            setSceneContent("FXMLModifierVoiture");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
