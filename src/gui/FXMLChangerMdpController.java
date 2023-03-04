/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import service.UtilisateurService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLChangerMdpController implements Initializable {

    @FXML
    private PasswordField tf_mdp;
    @FXML
    private PasswordField tf_mdpc;
    @FXML
    private Text cdsPass;
    @FXML
    private Text cdsPass1;
    UtilisateurService us = new UtilisateurService();
    String m = (String) Context.getInstance().getContextObject("mail");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmer(ActionEvent event) {
        if (tf_mdp.getText().equals(tf_mdpc.getText())) {
            String mdpH = tf_mdp.getText();
            mdpH = us.HashagePassword(mdpH);
            us.modifiermdp(m, mdpH);
            System.out.println(m);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation");
            alert.setContentText("mot de passe modifié ");
            alert.show();
            try {
                setSceneContent("FXMLAuthentification");
            } catch (IOException ex) {
                Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("mot de passe non identique ");
            alert.show();
        }
    }

}
