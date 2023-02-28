/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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

 /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Voiture v = vs.afficheVoiture(3);
        tf_immatriculation.setText(v.getImmatriculation());
        tf_modele.setText(v.getModele());
        tf_marque.setText(v.getMarque());
        tf_etat.setText(v.getEtat());
        photo.setText(v.getPhoto());

    }

    @FXML
    private void ModifierV(ActionEvent event) {
        Voiture v = new Voiture(tf_immatriculation.getText(), tf_modele.getText(), tf_marque.getText(), tf_etat.getText(), photo.getText(), 3);
        vs.modifier(v);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLGererVoiture.fxml"));
            Scene sc = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(sc);
            stage.show();
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
