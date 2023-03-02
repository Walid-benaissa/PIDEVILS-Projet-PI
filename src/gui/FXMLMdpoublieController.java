/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
        Utilisateur u = uc.rechUtilisateurByMail(fxLog.getText());
        String code = uc.sendMail(u.getMail());
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
