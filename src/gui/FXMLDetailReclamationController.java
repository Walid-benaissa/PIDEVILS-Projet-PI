/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import entities.Utilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import service.UtilisateurService;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLDetailReclamationController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private AnchorPane content;

    Reclamation r = (Reclamation) Context.getInstance().getContextObject("reclamation");
    @FXML
    private Label title1;
    @FXML
    private Label title11;
    @FXML
    private Label title111;
    @FXML
    private Label effectuePar;
    @FXML
    private Label msgRec;
    @FXML
    private Label etatRec;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.setText(title.getText() + r.getId());
        UtilisateurService us = new UtilisateurService();
        Utilisateur u = us.afficheUser(r.getIdUser());
        effectuePar.setText(u.getNom());
        msgRec.setText(r.getMessage());
        etatRec.setText(r.getEtat());
    }

    @FXML
    private void pdfPrint(ActionEvent event) {
        WritableImage nodeshot = content.snapshot(new SnapshotParameters(), null);
        File file = new File("chart.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", file);
        } catch (IOException e) {

        }

        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        PDImageXObject pdimage;
        PDPageContentStream content;
        try {
            pdimage = PDImageXObject.createFromFile("chart.png", doc);
            content = new PDPageContentStream(doc, page);
            content.drawImage(pdimage, -100, 50, 889, 663);
            content.close();
            doc.addPage(page);
            doc.save("C:/Users/walid/Downloads/pdf_file.pdf");
            doc.close();
            file.delete();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setContentText("Pdf telechargé avec success");
            alert.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
