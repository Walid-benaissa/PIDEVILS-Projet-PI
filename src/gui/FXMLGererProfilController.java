/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import service.UtilisateurService;
import utils.CommonController;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLGererProfilController extends CommonController implements Initializable {

    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_numtel;
    @FXML
    private TextField tf_mail;
    @FXML
    private TextField tf_mdp;
    @FXML
    private TextField tf_mdpC;
    @FXML
    private TextField tf_mdpAc;
    @FXML
    private CheckBox changermdp;
    UtilisateurService us = new UtilisateurService();
    @FXML
    private Pane paneMDP;
    String motdepasse;
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    @FXML
    private AnchorPane sidepane;
    @FXML
    private Button yeux;
    @FXML
    private Button yeux1;
    @FXML
    private Button yeux2;
    @FXML
    private TextField tf_mdpAcClaire;
    @FXML
    private TextField tf_mdpClaire;
    @FXML
    private TextField tf_mdpCClaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf_nom.setText(u.getNom());
        tf_prenom.setText(u.getPrenom());
        tf_numtel.setText(u.getNum_tel());
        tf_mail.setText(u.getMail());
        motdepasse = u.getMdp();
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
    private void ModifierInfo(ActionEvent event) {
        if (!tf_mdpAc.isVisible()) {
            tf_mdpAc.setText(tf_mdpAcClaire.getText());
        }
        if (!tf_mdp.isVisible()) {
            tf_mdp.setText(tf_mdpClaire.getText());
        }
        if (!tf_mdpC.isVisible()) {
            tf_mdpC.setText(tf_mdpCClaire.getText());
        }
        String mdpAc = tf_mdpAc.getText();
        mdpAc = us.HashagePassword(mdpAc);
        if (changermdp.isSelected()) {
            if (!tf_mdp.getText().equals(tf_mdpC.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("alert");
                alert.setContentText("les mots de passe ne sont pas identiques ");
                alert.show();
            } else {
                if (us.authentification(tf_mail.getText(), mdpAc).getId() == 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("alert");
                    alert.setContentText("mot de passe ancien n'est pas correct ");
                    alert.show();
                } else {

                    String mdpH = tf_mdp.getText();
                    mdpH = us.HashagePassword(mdpH);
                    Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), mdpH, tf_numtel.getText());
                    user.setId(u.getId());
                    us.modifierWithmdp(user);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setContentText("modification avec succés ");
                    alert.show();
                }
            }
        } else {
            Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), motdepasse, tf_numtel.getText());
            user.setId(u.getId());
            us.modifierSansmdp(user);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("modification avec succés ");
            alert.show();
        }
    }

    @FXML
    private void ModifierMDP(ActionEvent event
    ) {
        if (changermdp.isSelected()) {
            paneMDP.setDisable(false);
        } else {
            paneMDP.setDisable(true);
        }

    }

    @FXML
    private void mdpVisibleA(ActionEvent event
    ) {
        if (tf_mdpAc.isVisible()) {
            tf_mdpAc.setVisible(false);
            tf_mdpAcClaire.setVisible(true);
            tf_mdpAcClaire.setText(tf_mdpAc.getText());
        } else {
            tf_mdpAcClaire.setVisible(false);
            tf_mdpAc.setVisible(true);
            tf_mdpAc.setText(tf_mdpAcClaire.getText());
        }
    }

    @FXML
    private void mdpVisible(ActionEvent event
    ) {
        if (tf_mdp.isVisible()) {
            tf_mdp.setVisible(false);
            tf_mdpClaire.setVisible(true);
            tf_mdpClaire.setText(tf_mdp.getText());
        } else {
            tf_mdpClaire.setVisible(false);
            tf_mdp.setVisible(true);
            tf_mdp.setText(tf_mdpClaire.getText());
        }
    }

    @FXML
    private void mdpVisibleC(ActionEvent event
    ) {
        if (tf_mdpC.isVisible()) {
            tf_mdpC.setVisible(false);
            tf_mdpCClaire.setVisible(true);
            tf_mdpCClaire.setText(tf_mdpC.getText());
        } else {
            tf_mdpCClaire.setVisible(false);
            tf_mdpC.setVisible(true);
            tf_mdpC.setText(tf_mdpCClaire.getText());
        }
    }

}
