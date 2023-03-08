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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.VoitureService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLModifierVoitureController implements Initializable {

    private String phtotoV;

    @FXML
    private Button btnModifier;
    @FXML
    private TextField tf_immatriculation;
    @FXML
    private TextField tf_modele;
    @FXML
    private TextField tf_marque;
    @FXML
    private TextField tf_etat;
    @FXML
    private TextField photo;
    VoitureService vs = new VoitureService();
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    @FXML
    private Label err_immat;
    @FXML
    private Label err_mod;
    @FXML
    private Label err_marque;
    @FXML
    private Label err_etat;
    @FXML
    private Label err_img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Voiture v = vs.afficheVoiture(u.getId());
        tf_immatriculation.setText(v.getImmatriculation());
        tf_modele.setText(v.getModele());
        tf_marque.setText(v.getMarque());
        tf_etat.setText(v.getEtat());
        photo.setText(v.getPhoto());

    }

    @FXML
    private void ModifierV(ActionEvent event) {
        String nomprenomRegex = "^[A-Za-z 0-9.-]+$";
        if (!tf_immatriculation.getText().matches(nomprenomRegex)) {
            err_immat.setVisible(true);
            return;
        } else {
            err_immat.setVisible(false);
        }
        if (!tf_modele.getText().matches(nomprenomRegex)) {
            err_mod.setVisible(true);
            return;
        } else {
            err_mod.setVisible(false);
        }
        if (!tf_marque.getText().matches(nomprenomRegex)) {
            err_marque.setVisible(true);
            return;
        } else {
            err_marque.setVisible(false);
        }
        if (!tf_etat.getText().matches(nomprenomRegex)) {
            err_etat.setVisible(true);
            return;
        } else {
            err_etat.setVisible(false);
        }
        if (photo.getText().isEmpty()) {
            err_img.setVisible(true);
            return;
        } else {
            err_img.setVisible(false);
        }
        Voiture v = new Voiture(tf_immatriculation.getText(), tf_modele.getText(), tf_marque.getText(), tf_etat.getText(), photo.getText(), 3);
        vs.modifier(v);
        try {
            setSceneContent("FXMLGererVoiture");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void importerVoiture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My File");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            System.out.println("Open File");
            phtotoV = selectedFile.getPath();
            photo.setText(phtotoV);

        }
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            setSceneContent("FXMLGererVoiture");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
