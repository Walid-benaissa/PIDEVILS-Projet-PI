/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Voiture;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import service.VoitureService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLGererVoitureController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnMettreajour;
    @FXML
    private ImageView IDimage;
    @FXML
    private Label affichage;
    VoitureService vs = new VoitureService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Voiture v = vs.afficheVoiture(2);
        affichage.setText("Immatriculation :  " + v.getImmatriculation() + "\n"
                + "Modele :  " + v.getModele() + "\n" + "Marque :  " + v.getMarque() + "\n"
                + "Etat :  " + v.getEtat() + "\n");


    }

    @FXML
    private void Ajouter(ActionEvent event) {
    }

    @FXML
    private void Supprimer(ActionEvent event) {
    }

    @FXML
    private void Metrreajour(ActionEvent event) {
    }

}
