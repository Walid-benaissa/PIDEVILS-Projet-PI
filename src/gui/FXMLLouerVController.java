/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.sun.webkit.graphics.WCImage.getImage;
import entities.Location;
import entities.Translator;
import entities.Utilisateur;
//import entities.Translator;
import entities.Vehicule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.Date;
import static java.util.Arrays.stream;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.StreamSupport.stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import service.LocationService;
import static sun.applet.AppletResourceLoader.getImage;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLLouerVController implements Initializable {

    /**
     * Initializes the controller class.
     */
      Utilisateur k = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    Vehicule u = (Vehicule) Context.getInstance().getContextObject("Vehicule");
//    Location m =(Location) Context.getInstance().getContextObject("Location");
    private LocationService LocationService = new LocationService();
    Date dated = (Date) Context.getInstance().getContextObject("DateD");
    Date datef = (Date) Context.getInstance().getContextObject("DateF");
    String lieu = (String) Context.getInstance().getContextObject("lieu");

    @FXML
    private Button btnALouer;
    @FXML
    private Label affichage;
    @FXML
    private Button btnBack;
    @FXML
    private ImageView imaage;
    @FXML
    private Button btnALouer1;
    @FXML
    private TextField emailtxt;
  
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("test " + u);
        if (u.getDescription() != null) {
            long diffInMillies = Math.abs(datef.getTime() - dated.getTime());
            long daysBetween = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            affichage.setText("nom vehicule :  " + u.getNom_v() + "\n"
                    + "description :  " + u.getDescription() + "\n" + "prix par jour :  " + u.getPrix() + "\n"
                    + "\n Prix total: "+daysBetween*u.getPrix());
            

        } else {
            affichage.setText("Info non disponible");
        }
        String dossierImage = "C:\\pi\\PIDEVILS-Projet-PI\\Image\\";
               File dossier = new File(dossierImage);
        File[] fichiers = dossier.listFiles();
        System.out.println(u.getImage());
        for (File fichier : fichiers) {
        String nomFichier = fichier.getName();
        if (nomFichier.startsWith(u.getImage()) && nomFichier.endsWith(".jpb")||nomFichier.startsWith(u.getImage()) && nomFichier.endsWith(".png")) {
            String cheminImage1 = fichier.toURI().toString();
            Image image = new Image(cheminImage1);
            imaage.setImage(image);
            break;

    }
        }

    }
    

    @FXML
    private void back(ActionEvent event) {
    
   
          try {  
            setSceneContent("FXMLVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//@FXML
//public void translateComment(String targetLang) {
//   
//}
//
    @FXML
    private void louerj(ActionEvent event) {
         String text = u.getDescription();
                String fromLang = "en";
                String toLang = "fr";

    try {
    
   
         // Get the translated text using the Translator class
        Translator translator = new Translator();
        translator.translate(fromLang, toLang, text);
        String translatedText = translator.getTranslatedText();

        // Show the translated text in the commentTextArea
        u.setDescription(translatedText);
     
        // Show an alert with the original and translated comments
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Translated Comment");
        alert.setHeaderText("Original Comment: " + text);
        alert.setContentText("Translated Comment: " + translatedText);
        alert.showAndWait();

    } catch (Exception e) {
        e.printStackTrace();
        // Show an error alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Translation Error");
        alert.setContentText("An error occurred while translating the comment.");
        alert.showAndWait();
    }
    }
//
//        public static void sendMail(String recepient) throws MessagingException{
//        System.out.println("Prepared to send email");
//        Properties properties=new Properties();
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.smtp.host","smtp.gmail.com");
//        properties.put("mail.smtp.port","587");
//        String myEmailAccount="azizi7084@gmail.com";
//        String password="rscfpsobfcljniee";
//        Session session=Session.getInstance(properties,new Authenticator(){
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication(myEmailAccount,password);
//                
//            }
//        });
//        
//        Message message=prepareMessage(session,myEmailAccount,recepient);
//        Transport.send(message);
//        System.out.println("Message sent succesfully");
//    }
//        private static Message prepareMessage(Session session, String myEmailAccount,String recepient){
//        try {
//            Message message=new MimeMessage(session);
//            message.setFrom(new InternetAddress(myEmailAccount));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//            message.setSubject("Reservation du moyen transport");
//            message.setText("Bonjour cher(e) client(e),\n Suite à votre demande, veuillez trouver ci-dessous notre RIB  888555693742014 Attijari bank");
//            return message;
//                    } catch (MessagingException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//        }

    @FXML
    private void payer(ActionEvent event) throws MessagingException, FileNotFoundException, IOException {
//   String email=emailtxt.getText();
//   sendMail(email);
   Location l = new Location();
   l.setDate_debut(dated);
   l.setDate_fin(datef);
   l.setLieu(lieu);
   l.setId_vehicule(u.getId_vehicule());
   l.setId(2);
 LocationService.ajouter(l);

//        LocationService sp = new LocationService();
//    List<Location> annonces = sp.afficheListe();
//    XWPFDocument document = new XWPFDocument();
//    XWPFTable table = document.createTable();
//    XWPFTableRow headerRow = table.getRow(0);
//    headerRow.getCell(0).setText("Date debut");
//    headerRow.addNewTableCell().setText("Date fin");
//    headerRow.addNewTableCell().setText("Lieu");
//    headerRow.addNewTableCell().setText("id vehicule");
//   
//   
//    for (Location annonce : annonces) {
//        XWPFTableRow dataRow = table.createRow();
//        dataRow.getCell(0).setText(l.getDate_debut().toString());
//           dataRow.getCell(1).setText(l.getDate_fin().toString());
//         dataRow.getCell(2).setText(l.getLieu());
//        dataRow.getCell(3).setText(Integer.toString(l.getId_vehicule()));
//    }
//    FileOutputStream out = new FileOutputStream("C:\\Users\\azizi\\Desktop\\wordapi\\annonce.docx");
//    document.write(out);
//    out.close();
LocationService sp = new LocationService();
List<Location> annonces = sp.afficheListe();

XWPFDocument document = new XWPFDocument();

// Ajouter un titre
XWPFParagraph titre = document.createParagraph();
XWPFRun titreRun = titre.createRun();
titreRun.setText("Contrat de location");
titreRun.setBold(true);
titreRun.setFontSize(16);
titreRun.addBreak();

// Ajouter les informations de la location
for (Location annonce : annonces) {
    XWPFParagraph info = document.createParagraph();
    XWPFRun infoRun = info.createRun();
    infoRun.setText("Date début : " + l.getDate_debut().toString());
    infoRun.addBreak();
    infoRun.setText("Date fin : " + l.getDate_fin().toString());
    infoRun.addBreak();
    infoRun.setText("Lieu : " + l.getLieu());
    infoRun.addBreak();
    infoRun.setText("ID véhicule : " + Integer.toString(l.getId_vehicule()));
    infoRun.addBreak();
    break;
    
}

// Ajouter les conditions du contrat
XWPFParagraph conditions = document.createParagraph();
XWPFRun conditionsRun = conditions.createRun();
conditionsRun.setText("Le locataire s'engage à utiliser le véhicule de manière responsable et à le restituer en bon état à la fin de la période de location. Tout dommage causé au véhicule sera à la charge du locataire.\n  veuillez trouver ci-dessous notre RIB  888555693742014 Attijari bank");
conditionsRun.addBreak();

// Sauvegarder le document
FileOutputStream out = new FileOutputStream("C:\\pi\\PIDEVILS-Projet-PI\\contrat.docx");
document.write(out);
out.close();
    }

}
