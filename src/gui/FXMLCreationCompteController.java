/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Conducteur;
import entities.Utilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ConducteurService;
import service.UtilisateurService;
import utils.CommonController;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLCreationCompteController extends CommonController implements Initializable {

    private String permis;
    private String b3;
    @FXML
    private TextField tf_nom;
    @FXML
    private ToggleGroup role;
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
    private RadioButton conducteurBtn;
    @FXML
    private RadioButton clientBtn;

    @FXML
    private Pane ajoutC;
    @FXML
    private TextField tf_permis;
    @FXML
    private TextField tf_b3;
    @FXML
    private Label err_prenom;
    @FXML
    private Label err_num;
    @FXML
    private Label err_nom;
    @FXML
    private Label err_mail;
    @FXML
    private Label err_mdp;
    @FXML
    private Label err_mdpc;
    @FXML
    private Button yeux;
    @FXML
    private Button yeux1;
    @FXML
    private TextField tf_mdpclaire;
    @FXML
    private TextField tf_mdpCclaire;
    @FXML
    private Label err_permis;
    @FXML
    private Label err_b3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajoutC.setVisible(false);
    }

    @FXML
    private void creer(ActionEvent event) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String numtelRegex = "^[0-9+]+$";
        String nomprenomRegex = "^[A-Za-z .-]+$";
        String mdpRegex = "^[A-Za-z0-9_.-@]+$";
        if (!tf_nom.getText().matches(nomprenomRegex)) {
            err_nom.setVisible(true);
            return;
        } else {
            err_nom.setVisible(false);
        }

        if (!tf_prenom.getText().matches(nomprenomRegex)) {
            err_prenom.setVisible(true);
            return;
        } else {
            err_prenom.setVisible(false);
        }

        if (!tf_numtel.getText().matches(numtelRegex)) {
            err_num.setVisible(true);
            return;
        } else {
            err_num.setVisible(false);
        }

        if (!tf_mail.getText().matches(emailRegex)) {
            err_mail.setVisible(true);
            return;
        } else {
            err_mail.setVisible(false);
        }
        if (!tf_mdp.getText().matches(mdpRegex)) {
            err_mdp.setVisible(true);
            return;
        } else {
            err_mdp.setVisible(false);
        }
        if (!tf_mdpC.getText().matches(mdpRegex)) {
            err_mdpc.setVisible(true);
            return;
        } else {
            err_mdpc.setVisible(false);
        }
        UtilisateurService us = new UtilisateurService();
        String role = "";
        if (clientBtn.isSelected()) {
            role = "Client";
        } else {
            role = "Conducteur";
        }
        if (!tf_mdp.isVisible()) {
            tf_mdp.setText(tf_mdpclaire.getText());
        }
        if (!tf_mdpC.isVisible()) {
            tf_mdpC.setText(tf_mdpCclaire.getText());
        }

        if (tf_mdp.getText().equals(tf_mdpC.getText())) {
            String mdpH = tf_mdp.getText();
            mdpH = us.HashagePassword(mdpH);
            if (role.equals("Conducteur")) {
                if (tf_permis.getText().isEmpty()) {
                    err_permis.setVisible(true);
                    return;
                } else {
                    err_permis.setVisible(false);
                }
                if (tf_b3.getText().isEmpty()) {
                    err_b3.setVisible(true);
                    return;
                } else {
                    err_b3.setVisible(false);
                }
                Conducteur user = new Conducteur(tf_permis.getText(), tf_b3.getText(), tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), mdpH, tf_numtel.getText(), role, 0.0F);
                Context.getInstance().addContextObject("Utilisateur", user);
            } else {
                Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), mdpH, tf_numtel.getText(), role, 0.0F);
                Context.getInstance().addContextObject("Utilisateur", user);
            }
            try {
                setSceneContent("ImNotRobotFXML");
            } catch (IOException ex) {
                Logger.getLogger(FXMLCreationCompteController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("creation échoué");
            alert.show();
        }
    }

    @FXML
    private void importerPermis(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My File");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            System.out.println("Open File");

            tf_permis.setText(selectedFile.getPath());

        }
    }

    @FXML
    private void importerB3(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My File");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            System.out.println("Open File");
            tf_b3.setText(selectedFile.getPath());
        }
    }

    @FXML
    private void afficherFormulaireC(ActionEvent event) {
        if (conducteurBtn.isSelected()) {
            ajoutC.setVisible(true);
            err_permis.setVisible(false);
            err_b3.setVisible(false);
        } else {
            ajoutC.setVisible(false);
        }
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            setSceneContent("FXMLAuthentification");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mdpVisible(ActionEvent event) {
        if (tf_mdp.isVisible()) {
            tf_mdp.setVisible(false);
            tf_mdpclaire.setVisible(true);
            tf_mdpclaire.setText(tf_mdp.getText());
        } else {
            tf_mdpclaire.setVisible(false);
            tf_mdp.setVisible(true);
            tf_mdp.setText(tf_mdpclaire.getText());
        }
    }

    @FXML
    private void mdpCVisible(ActionEvent event) {
        if (tf_mdpC.isVisible()) {
            tf_mdpC.setVisible(false);
            tf_mdpCclaire.setVisible(true);
            tf_mdpCclaire.setText(tf_mdpC.getText());
        } else {
            tf_mdpCclaire.setVisible(false);
            tf_mdpC.setVisible(true);
            tf_mdpC.setText(tf_mdpCclaire.getText());
        }

    }

}
