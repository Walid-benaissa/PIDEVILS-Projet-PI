/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Conducteur;
import entities.Reclamation;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import service.ConducteurService;
import service.UtilisateurService;
import service.VoitureService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLDetailsUtilisateurController implements Initializable {

    @FXML
    private ImageView permis;
    @FXML
    private ImageView b3;
    @FXML
    private Label affichage;

    @FXML
    private Pane visibleC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String role = (String) Context.getInstance().getContextObject("role");
        if (role.equals("Conducteur")) {
            ConducteurService serc = new ConducteurService();
            Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("user");
             Conducteur cond =serc.afficheC(u.getId());
            visibleC.setVisible(true);
            affichage.setText("id :  " + u.getId() + "\n"
                    + "Nom :  " + cond.getNom() + "\n" + "Prénom :  " + cond.getPrenom() + "\n"
                    + "Mail :  " + cond.getMail() + "\n" + "Numero téléphone :  " + cond.getNum_tel() + "\n"
                    + "Role :  " + cond.getRole() + "\n" + "Evaluation :  " + cond.getEvaluation() + "\n"
                    + "Bloquer :  " + cond.isBolque() + "\n");
            File imageFile = new File(cond.getPermis());
            Image image1 = new Image(imageFile.toURI().toString());
            permis.setImage(image1);
            imageFile = new File(cond.getB3());
            Image image2 = new Image(imageFile.toURI().toString());
            b3.setImage(image2);

        } else {
            Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("user");
            affichage.setText("id :  " + u.getId() + "\n"
                    + "Nom :  " + u.getNom() + "\n" + "Prénom :  " + u.getPrenom() + "\n"
                    + "Mail :  " + u.getMail() + "\n" + "Numero téléphone :  " + u.getNum_tel() + "\n"
                    + "Role :  " + u.getRole() + "\n" + "Evaluation :  " + u.getEvaluation() + "\n"
                    + "Bloquer :  " + u.isBolque() + "\n");

        }
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            setSceneContent("FXMLGererUtilisateurs");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
