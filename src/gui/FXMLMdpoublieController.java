/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.*;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import service.UtilisateurService;
import utils.CommonController;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLMdpoublieController extends CommonController implements Initializable {

    @FXML
    private TextField fxLog;
    @FXML
    private Text cdsEnvoyer;
    @FXML
    private Text cdsPass;
    UtilisateurService uc = new UtilisateurService();
    Utilisateur u = new Utilisateur();
            


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void EnvoyerBTN(ActionEvent event) {
        String To=fxLog.getText();
        envoyerMail(To);
        

    }
    public static void envoyerMail(String To){
    Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pfe.mailer2022@gmail.com", "yfytvfimsgddnwgs");
            }
        }
        );
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pfe.mailer2022@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject("code de validation");
            message.setText("Votre code de validation est: ");
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "message sent");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
