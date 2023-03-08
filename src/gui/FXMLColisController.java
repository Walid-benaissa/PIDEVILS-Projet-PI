/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import entities.Utilisateur;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import service.LivraisonService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLColisController implements Initializable {

    // Utilisateur utilisateur = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    @FXML
    private TextField txtexp;
    @FXML
    private TextField txtdest;
    @FXML
    private ImageView qrcodee;
    @FXML
    private Button jButton1;
    @FXML
    private TextField txtprix;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txttel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private boolean adresse_expvalide() {
        Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(txtexp.getText());
        if (m.find() && m.group().equals(txtdest.getText())) {
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
        Matcher m = p.matcher(txtdest.getText());
        if (m.find() && m.group().equals(txtdest.getText())) {
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

    @FXML
    private void jButton1ActionPerformed(ActionEvent event) {

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            String Information = "adresse expédition: " + txtexp.getText() + "\n" + "Adresse destination : " + txtdest.getText() + "\n" + "Prix : " + txtprix.getText() + "\n" + "Nom client : " + txtnom.getText() + "\n" + "Prénom Client : " + txtprenom.getText() + "\n" + "Numéro de teléphone: " + txttel.getText();
            int width = 300;
            int height = 300;

            BufferedImage bufferedImage = null;
            BitMatrix byteMatrix = qrCodeWriter.encode(Information, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();

            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            System.out.println("Success...");

             qrcodee.setImage(SwingFXUtils.toFXImage(bufferedImage, null));


// TODO
        } catch (WriterException ex) {
            Logger.getLogger(FXMLColisController.class.getName()).log(Level.SEVERE, null, ex);

        }
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
