/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Commentaire;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.CommentaireService;
import service.UtilisateurService;
import utils.CommonController;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLAvisSurConducteurController extends CommonController implements Initializable {

    @FXML
    private Button eval1;
    @FXML
    private Button eval2;
    @FXML
    private Button eval3;
    @FXML
    private Button eval4;
    @FXML
    private Button eval5;
    @FXML
    private TextArea tf_comment;
    @FXML
    private ImageView etoile1;
    @FXML
    private ImageView etoile2;
    @FXML
    private ImageView etoile3;
    @FXML
    private ImageView etoile4;
    @FXML
    private ImageView etoile5;
    private int rating = 0;
    ArrayList<ImageView> etoiles = new ArrayList<ImageView>();
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    @FXML
    private Button soumBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        etoiles.add(etoile1);
        etoiles.add(etoile2);
        etoiles.add(etoile3);
        etoiles.add(etoile4);
        etoiles.add(etoile5);
    }

    @FXML
    private void evaluation(ActionEvent event) {
        switch (((Node) event.getSource()).getId()) {
            case "eval1":
                etoiles.forEach((i) -> {
                    i.setImage(new Image("/images/star.png/"));
                });
                etoile1.setImage(new Image("/images/star (1).png/"));
                rating = 1;
                break;
            case "eval2":
                etoiles.forEach((i) -> {
                    i.setImage(new Image("/images/star.png/"));
                });
                etoile1.setImage(new Image("/images/star (1).png/"));
                etoile2.setImage(new Image("/images/star (1).png/"));
                rating = 2;
                break;
            case "eval3":
                etoiles.forEach((i) -> {
                    i.setImage(new Image("/images/star.png/"));
                });
                etoile1.setImage(new Image("/images/star (1).png/"));
                etoile2.setImage(new Image("/images/star (1).png/"));
                etoile3.setImage(new Image("/images/star (1).png/"));
                rating = 3;
                break;
            case "eval4":
                etoiles.forEach((i) -> {
                    i.setImage(new Image("/images/star.png/"));
                });
                etoile1.setImage(new Image("/images/star (1).png/"));
                etoile2.setImage(new Image("/images/star (1).png/"));
                etoile3.setImage(new Image("/images/star (1).png/"));
                etoile4.setImage(new Image("/images/star (1).png/"));
                rating = 4;
                break;
            case "eval5":
                etoile1.setImage(new Image("/images/star (1).png/"));
                etoile2.setImage(new Image("/images/star (1).png/"));
                etoile3.setImage(new Image("/images/star (1).png/"));
                etoile4.setImage(new Image("/images/star (1).png/"));
                etoile5.setImage(new Image("/images/star (1).png/"));
                rating = 5;
                break;
        }
        soumBtn.setDisable(false);
    }

    @FXML
    private void soummetreEval(ActionEvent event) {
        Commentaire c = new Commentaire();
        if (!tf_comment.getText().isEmpty()) {
            c.setMessage(tf_comment.getText());
            c.setId1(11);
            c.setId2(12);
            CommentaireService cs = new CommentaireService();
            cs.ajouter(c);
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("Votre evaluation a été enregistrée");
        alert.show();
        UtilisateurService us = new UtilisateurService();
        us.evaluer(2, rating);
        
    }

}
