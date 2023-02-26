/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import service.UtilisateurService;
import utils.CommonController;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("loggedInUser");
        tf_nom.setText(u.getNom());
        tf_prenom.setText(u.getPrenom());
        tf_numtel.setText(u.getNum_tel());
        tf_mail.setText(u.getMail());
        motdepasse = u.getMdp();
    }

    @FXML
    private void ModifierInfo(ActionEvent event) {
        if (changermdp.isSelected() & tf_mdp.getText().equals(tf_mdpC.getText())) {
            Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_numtel.getText(), tf_mail.getText(), tf_mdp.getText());
            user.setId(2);
            us.modifierWithmdp(user);
        } else {
            Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(),motdepasse, tf_numtel.getText());
            user.setId(2);
            us.modifierSansmdp(user);
        }
    }

    @FXML
    private void ModifierMDP(ActionEvent event) {
        if (changermdp.isSelected()) {
            paneMDP.setDisable(false);
        } else {
            paneMDP.setDisable(true);
        }

    }

}
