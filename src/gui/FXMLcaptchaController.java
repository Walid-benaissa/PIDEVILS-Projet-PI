/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
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
import javafx.stage.Stage;
import service.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLcaptchaController implements Initializable {

    @FXML
    private CheckBox notRobot;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;
    @FXML
    private ImageView image9;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> imageBus = new ArrayList();
        imageBus.add("bus1.png");
        imageBus.add("bus2V.png");
        imageBus.add("bus3.png");
        imageBus.add("bus4.png");
        imageBus.add("bus5.png");
        imageBus.add("bus6V.png");
        imageBus.add("bus7V.png");
        imageBus.add("bus8.png");
        imageBus.add("bus9.png");
        List<ImageView> images = new ArrayList();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        Collections.shuffle(imageBus);
        String path = "C:\\Users\\ASUS\\Desktop\\bus\\E:\\PidevJava\\Pidevils\\PIDEVILS-Projet-PI\\src\\images\\";
        for (int i = 0; i < 9; i++) {
            try {
                InputStream stream = new FileInputStream(path + imageBus.get(i));
                images.get(i).setImage(new Image(stream));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLcaptchaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void valider(ActionEvent event) {
               UtilisateurFXMLController u = new UtilisateurFXMLController();
        if (u.login.equals("admin") && u.password.equals("admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCreationCompte"));
            Parent root;
            try {
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLcaptchaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            Stage primaryStage2 = new Stage();
            primaryStage2.setTitle("Offre");
            primaryStage2.setScene(scene);
            primaryStage2.show();
            Stage primaryStage3 = (Stage) ((Button) event.getSource()).getScene().getWindow();
            primaryStage3.close();
        } else {
            UtilisateurService us = new UtilisateurService();
            Utilisateur ut = us.getUserLogin(u.login, u.password);
            if (ut == null) {
                /*u.cdsLogin.setText("Incorrect");
                u.cdsPass.setText("Incorrect");

                u.setTimerIncorrect();*/
                Stage primaryStage3 = (Stage) ((Button) event.getSource()).getScene().getWindow();
                primaryStage3.close();
                return;
            } else {
                System.out.println("User ( id :" + ut.getId() + " ) Connected succefully  ");
                Stage primaryStage3 = (Stage) ((Button) event.getSource()).getScene().getWindow();
                primaryStage3.close();
            }
        }
    }

}
