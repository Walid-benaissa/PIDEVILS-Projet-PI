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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLCodeConfirmationController implements Initializable {

    @FXML
    private TextField fxLog;
    @FXML
    private Text cdsEnvoyer;
    @FXML
    private Text cdsPass;
    String c = (String) Context.getInstance().getContextObject("codeValidation");
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
        System.out.println(c);
        if (fxLog.getText().equals(c)) {
            try {
                setSceneContent("FXMLChangerMdp");
            } catch (IOException ex) {
                Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec");
            alert.setContentText("Code inccorect réinitialiser le code ");
            alert.show();

        }

    }

    @FXML
    private void renvoyer(ActionEvent event) {
        FXMLMdpoublieController.envoyerMail(m);
    }

}
