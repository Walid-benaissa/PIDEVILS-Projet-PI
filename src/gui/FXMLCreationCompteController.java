/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Conducteur;
import entities.Utilisateur;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ConducteurService;
import service.UtilisateurService;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLCreationCompteController implements Initializable {
private String permis ;
private String b3 ;
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
if (!tf_mail.getText().matches(emailRegex)) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Format email incorrect");
    alert.setHeaderText(null);
    alert.setContentText("Veuillez saisir un email valide !");
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
                Conducteur user = new Conducteur( permis,b3, tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), tf_mdp.getText(), tf_numtel.getText(), role, 0.0F);
                ConducteurService cs = new ConducteurService();
                cs.ajouter(user);
            }
            else{
            Utilisateur user = new Utilisateur(tf_nom.getText(), tf_prenom.getText(), tf_mail.getText(), tf_numtel.getText(), tf_mdp.getText(), role, 0.0F);
            us.ajouter(user);}
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
                if (selectedFile != null ) {
                    System.out.println("Open File");
                    permis=selectedFile.getPath();
                    tf_permis.setText(permis);
                    
                }
    }

    @FXML
    private void importerB3(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open My File");
                File selectedFile = fileChooser.showOpenDialog(new Stage());
                if (selectedFile != null ) {
                    System.out.println("Open File");
                    b3=selectedFile.getPath();
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

}
