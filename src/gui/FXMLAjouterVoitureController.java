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
public class FXMLAjouterVoitureController implements Initializable {

    private String phtotoV;

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
    @FXML
    private Button btnAjouter;
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        VoitureService vs = new VoitureService();
        Voiture v = new Voiture(tf_immatriculation.getText(), tf_modele.getText(), tf_marque.getText(), tf_etat.getText(), photo.getText(), u.getId());
        vs.ajouter(v);
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
