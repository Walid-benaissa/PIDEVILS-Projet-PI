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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ConducteurService;
import service.UtilisateurService;
import utils.CommonController;
import static utils.CommonController.setSceneContent;

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
    private RadioButton locateurBtn;
    @FXML
    private VBox ajoutC;
    @FXML
    private TextField tf_permis;
    @FXML
    private TextField tf_b3;

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
        String nomprenomRegex = "^[A-Za-z0-9_.-]+$";
        String mdpRegex = "^[A-Za-z0-9_.-@]+$";
        if (!tf_nom.getText().matches(nomprenomRegex)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Format nom incorrect");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre nom!");
            alert.showAndWait();
            return;
        }
        if (!tf_prenom.getText().matches(nomprenomRegex)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Format prénom incorrect");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre prénom!");
            alert.showAndWait();
            return;
        }
        if (!tf_numtel.getText().matches(numtelRegex)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Format numero de téléphone incorrect");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un numero de téléphone valide !");
            alert.showAndWait();
            return;
        }
        if (!tf_mail.getText().matches(emailRegex)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Format email incorrect");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un email valide !");
            alert.showAndWait();
            return;
        }
        if (!tf_mdp.getText().matches(mdpRegex)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Format mot de passe incorrect");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre mot de passe!");
            alert.showAndWait();
            return;
        }
        UtilisateurService us = new UtilisateurService();
        String role = "";
        if (locateurBtn.isSelected()) {
            role = "Locateur";
        } else if (clientBtn.isSelected()) {
            role = "Client";
        } else {
            role = "Conducteur";
        }
        if (tf_mdp.getText().equals(tf_mdpC.getText())) {
            if (role.equals("Conducteur")) {
                Conducteur user = new Conducteur(permis, b3, tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), tf_mdp.getText(), tf_numtel.getText(), role, 0.0F);
                ConducteurService cs = new ConducteurService();
                cs.ajouter(user);
            } else {
                Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), tf_mdp.getText(), tf_numtel.getText(), role, 0.0F);
                us.ajouter(user);
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("creation avec succés");
            alert.show();

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
            permis = selectedFile.getPath();
            tf_permis.setText(permis);

        }
    }

    @FXML
    private void importerB3(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My File");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            System.out.println("Open File");
            b3 = selectedFile.getPath();
            tf_b3.setText(b3);
        }
    }

    @FXML
    private void afficherFormulaireC(ActionEvent event) {
        if (conducteurBtn.isSelected()) {
            ajoutC.setVisible(true);
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

}
