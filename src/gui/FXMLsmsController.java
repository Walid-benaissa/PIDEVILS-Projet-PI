/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLsmsController implements Initializable {
    
     /* public static final String ACCOUNT_SID = "AC23c10455ba1e24c96fb6bcc98f9183a0";
    public static final String AUTH_TOKEN = "ca73d2dd53ebcc0b60d9cb40b2d47931";
    public static final String TWILIO_NUMBER = "+16076955652";*/
      
       public static final String ACCOUNT_SID = "ACb41add57cfe9cce88d4b9dec32886a34";
    public static final String AUTH_TOKEN = "aeefa0ce3b4a15611706b146cb4c2ef0";
    public static final String TWILIO_NUMBER = "+15075858388";
    
    @FXML
    private TextField textfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void sendSMS(ActionEvent event) {
            String toPhoneNumber = textfield.getText();
   if (toPhoneNumber == null || toPhoneNumber.trim().isEmpty()) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un numéro de téléphone valide!");
            alert.showAndWait();
        return;
    }
   Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
   
    String messageText = "Bonjour, votre livraison est en route ! Veuillez vous assurer que quelqu'un est disponible pour récupérer la commande à l'arrivée. Merci pour votre confiance !" ;
    Message message = Message.creator(new PhoneNumber(toPhoneNumber),
            new PhoneNumber(TWILIO_NUMBER),
            messageText).create();
    
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("success");
            alert.setContentText(" Message envoyé avec succès");
            alert.show();
   
}  

    @FXML
    private void retour(ActionEvent event) {
           try {
            setSceneContent("FXMLLivreurLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
