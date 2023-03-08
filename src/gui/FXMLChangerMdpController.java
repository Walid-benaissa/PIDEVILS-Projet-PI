/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.UtilisateurService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLChangerMdpController implements Initializable {

    @FXML
    private PasswordField tf_mdp;
    @FXML
    private PasswordField tf_mdpc;
    @FXML
    private Text cdsPass;
    @FXML
    private Text cdsPass1;
    UtilisateurService us = new UtilisateurService();
    String m = (String) Context.getInstance().getContextObject("mail");
    @FXML
    private Button yeux;
    @FXML
    private Button yeux1;
    @FXML
    private Label err_mdpc;
    @FXML
    private Label err_mdp;
    @FXML
    private TextField mdpClaire;
    @FXML
    private TextField mdpCClaire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmer(ActionEvent event) {
        String nomprenomRegex = "^[A-Za-z0-9_.-@]+$";
        if (!tf_mdp.isVisible()) {
            tf_mdp.setText(mdpClaire.getText());
        }
        if (!tf_mdpc.isVisible()) {
            tf_mdpc.setText(mdpCClaire.getText());
        }
        if (!tf_mdp.getText().matches(nomprenomRegex)) {
            err_mdp.setVisible(true);
            return;
        } else {
            err_mdp.setVisible(false);
        }
        if (!tf_mdpc.getText().matches(nomprenomRegex)) {
            err_mdpc.setVisible(true);
            return;
        } else {
            err_mdpc.setVisible(false);
        }
        if (tf_mdp.getText().equals(tf_mdpc.getText())) {
            String mdpH = tf_mdp.getText();
            mdpH = us.HashagePassword(mdpH);
            us.modifiermdp(m, mdpH);
            System.out.println(m);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation");
            alert.setContentText("mot de passe modifié ");
            alert.show();
            try {
                setSceneContent("FXMLAuthentification");
            } catch (IOException ex) {
                Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("mot de passe non identique ");
            alert.show();
        }
    }

    @FXML
    private void mdpVisibleA(ActionEvent event) {
        if (tf_mdp.isVisible()) {
            tf_mdp.setVisible(false);
            mdpClaire.setVisible(true);
            mdpClaire.setText(tf_mdp.getText());
        } else {
            mdpClaire.setVisible(false);
            tf_mdp.setVisible(true);
            tf_mdp.setText(mdpClaire.getText());
        }
    }

    @FXML
    private void mdpVisibleB(ActionEvent event) {
        if (tf_mdpc.isVisible()) {
            tf_mdpc.setVisible(false);
            mdpCClaire.setVisible(true);
            mdpCClaire.setText(tf_mdpc.getText());
        } else {
            mdpCClaire.setVisible(false);
            tf_mdpc.setVisible(true);
            tf_mdpc.setText(mdpCClaire.getText());
        }
    }

}
