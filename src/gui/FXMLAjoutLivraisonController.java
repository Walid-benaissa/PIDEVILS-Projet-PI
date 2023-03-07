package gui;

import entities.Colis;
import entities.Livraison;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.TextField;
import service.LivraisonService;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import org.controlsfx.control.textfield.TextFields;
import service.ColisService;
import static utils.CommonController.setSceneContent;
import utils.Context;
//import org.controlsfx.control.textfield.TextFields;


/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLAjoutLivraisonController implements Initializable {

    @FXML
    private TextField tf_AdresseExp;
    @FXML
    private TextField tf_adresseDest;
    @FXML
    private TextField tf_prix;
    @FXML
    private TextField tf_nbrObjets;
    @FXML
    private TextField tf_description;
    @FXML
    private TextField tf_poids;
        Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] possibleWords= {"Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jandouba","Kairouan","Kasserine","Kébili","Kef","Mahdia","Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"};
        TextFields.bindAutoCompletion(tf_AdresseExp, possibleWords);
        TextFields.bindAutoCompletion(tf_adresseDest, possibleWords);        
    }

    private boolean adresse_expvalide() {
        Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tf_AdresseExp.getText());
        if (m.find() && m.group().equals(tf_AdresseExp.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Type Adresse Expédition invalide !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un type valide !");
            alert.showAndWait();

            return false;
        }
    }

    private boolean adresse_desvalide() {
        Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(tf_adresseDest.getText());
        if (m.find() && m.group().equals(tf_adresseDest.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Type Adresse Destination invalide !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un type valide !");
            alert.showAndWait();

            return false;
        }
    }

    private boolean nb_itemsvalide() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(tf_nbrObjets.getText());
        if (m.find() && m.group().equals(tf_nbrObjets.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Type nombre d'objets invalide !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un type valide !");
            alert.showAndWait();

            return false;
        }
        
    }

    @FXML
    private void ajoutL(ActionEvent event) {
        LivraisonService ls = new LivraisonService();
        ColisService cs = new ColisService();
        if (tf_AdresseExp.getText().isEmpty() || tf_adresseDest.getText().isEmpty() || tf_prix.getText().isEmpty() || tf_nbrObjets.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setContentText("il y'a des champs vides !");
            alert.show();

        } else if (adresse_desvalide() && nb_itemsvalide() && adresse_expvalide()) {
            String prix = tf_prix.getText();
            Livraison l = new Livraison(tf_AdresseExp.getText(), tf_adresseDest.getText(), Float.parseFloat(prix), "En attente");
            String nb_items = tf_nbrObjets.getText();
            String poids = tf_poids.getText();
            Colis c = new Colis(Integer.parseInt(nb_items), tf_description.getText(), Float.parseFloat(poids));

            cs.ajouter(c);
            ls.ajouter2(l,u.getId() );
            // System.err.println("Ajout avec succès");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("success");
            alert.setContentText("Livraison ajoutée avec succès");
            alert.show();
            tf_AdresseExp.setText("");
            tf_adresseDest.setText("");
            tf_description.setText("");
            tf_nbrObjets.setText("");
            tf_poids.setText("");
            tf_prix.setText("");

        }
    }

   
   

    @FXML
    private void retour(ActionEvent event) {
        try {
            setSceneContent("FXMLLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
