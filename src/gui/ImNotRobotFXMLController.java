/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Conducteur;
import java.io.File;
import service.UtilisateurService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import entities.Utilisateur;
import gui.FXMLCreationCompteController;
import javafx.scene.control.Alert;
import service.ConducteurService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ImNotRobotFXMLController implements Initializable {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;
    @FXML
    private ImageView image9;
    private List<String> imageCafe = new ArrayList();
    private List<String> imageCafe2 = new ArrayList();
    private List<ImageView> images = new ArrayList();
    List<Integer> orderOfShuffle = new ArrayList<>();
    List<Integer> hh = new ArrayList<>();
    private boolean stillok = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        imageCafe.add("cafe1.jpg");
        imageCafe.add("cafe2V.jpg");
        imageCafe.add("cafe3.jpg");
        imageCafe.add("cafe4.jpg");
        imageCafe.add("cafe5.jpg");
        imageCafe.add("cafe6V.jpg");
        imageCafe.add("cafe7V.jpg");
        imageCafe.add("cafe8.jpg");
        imageCafe.add("cafe9.jpg");

        imageCafe2.add("cafe1.jpg");
        imageCafe2.add("cafe2V.jpg");
        imageCafe2.add("cafe3.jpg");
        imageCafe2.add("cafe4.jpg");
        imageCafe2.add("cafe5.jpg");
        imageCafe2.add("cafe6V.jpg");
        imageCafe2.add("cafe7V.jpg");
        imageCafe2.add("cafe8.jpg");
        imageCafe2.add("cafe9.jpg");

        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        Collections.shuffle(imageCafe);

        for (int i = 0; i < imageCafe.size(); i++) {
            if (imageCafe.get(i).equals("cafe2V.jpg") || imageCafe.get(i).equals("cafe6V.jpg") || imageCafe.get(i).equals("cafe7V.jpg")) {
                hh.add(i + 1);
            }
        }
        String path = "src\\images\\";

        for (int i = 0; i < 9; i++) {
            try {
                InputStream stream = new FileInputStream(path + imageCafe.get(i));
                images.get(i).setImage(new Image(stream));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImNotRobotFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void valide(ActionEvent event) throws IOException {
        if (stillok && hh.size() == 3) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("creation avec succés");
            alert.show();
            Utilisateur user = (Utilisateur) Context.getInstance().getContextObject("Utilisateur");
            System.out.println(user.getClass());
            if (user instanceof Conducteur ) {
                Conducteur c= (Conducteur) user;
                ConducteurService cs = new ConducteurService();
                cs.ajouter(c);
            } else {
                UtilisateurService us = new UtilisateurService();
                us.ajouter(user);
            }

            try {
                setSceneContent("FXMLAuthentification");
            } catch (IOException ex) {
                Logger.getLogger(FXMLCreationCompteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("echec essayer de noveau! ");
            alert.show();
            try {
                setSceneContent("ImNotRobotFXML");
            } catch (IOException ex) {
                Logger.getLogger(FXMLCreationCompteController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void clickImage(MouseEvent event) {
        int index = Integer.parseInt(((ImageView) event.getSource()).getId().substring(((ImageView) event.getSource()).getId().length() - 1, ((ImageView) event.getSource()).getId().length()));
        if (!hh.contains(index)) {
            stillok = false;
        }
        ((ImageView) event.getSource()).setImage(null);

    }

}
