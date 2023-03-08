/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLLouerVPromotionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Vehicule u = (Vehicule) Context.getInstance().getContextObject("Vehicule");
    Date dated = (Date) Context.getInstance().getContextObject("DateD");
    Date datef = (Date) Context.getInstance().getContextObject("DateF");

    @FXML
    private Button btnALouer;
    @FXML
    private ImageView IDimage;
    @FXML
    private Label affichage;
    @FXML
    private Button btnBack;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("test " + u);
        if (u.getDescription() != null) {
            long diffInMillies = Math.abs(datef.getTime() - dated.getTime());
            long daysBetween = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            float taux;
              switch (u.getId_promotion()) {
           
           case 6:
                // code block
                taux=(25);
                break;
            case 7:
                // code block
                taux=(30);
                break;
            case 8:
                // code block
                taux=(35);
                break;
            case 9:
                // code block
                taux=(40);
                break;
            case 10:
                // code block
                taux=(45);
                break;
            case 11:
                // code block
                taux=(50);
                break;
            case 12:
                // code block
                taux=(55);
                break;
            case 13:
                // code block
                taux=(60);
                break;
            case 14:
                // code block
                taux=(65);
                break;
            case 15:
                // code block
                taux=(70);
                break;
            case 16:
                // code block
                taux=(75);
                break;
            case 17:
                // code block
                taux=(80);
                break;
            case 18:
                // code block
                taux=(85);
                break;
            case 19:
                // code block
                taux=(90);
                break;

            default:
                // code block
                taux=(0);
        }
            affichage.setText("nom vehicule :  " + u.getNom_v() + "\n"
                    + "description :  " + u.getDescription() + "\n" + "prix par jour :  " + u.getPrix() + "\n"
                    + "\n Prix total: "+ daysBetween * (u.getPrix()*(1-(taux/100))));
           
                    
        } else {
            affichage.setText("Info non disponible");
        }

    }
    @FXML
    private void louer(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    
   
          try {  
            setSceneContent("FXMLVehiculePromotion");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
