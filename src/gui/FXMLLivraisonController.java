/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javafx.scene.control.TableColumn;
import entities.Colis;
import entities.Livraison;
import java.net.URL;
import javafx.scene.control.TextField;
import service.LivraisonService;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ColisService;
import entities.Livraison;
import entities.Colis;
import entities.LivraisonColis;
import entities.Utilisateur;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.controlsfx.control.textfield.TextFields;
import utils.CommonController;
import utils.Context;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLivraisonController extends CommonController implements Initializable {

    @FXML
    private TableColumn<?, ?> tfAdresseExp;
    @FXML
    private TableColumn<?, ?> tfAdresseDest;
    @FXML
    private TableColumn<?, ?> tfPrix;
    @FXML
    private TableColumn<?, ?> TfEtat;
    @FXML
    private TableColumn<?, ?> tfNBObj;
    @FXML
    private TableColumn<?, ?> tfDescription;
    @FXML
    private TableColumn<?, ?> tfPoids;
    private ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");

    @FXML
    private TableView<LivraisonColis> table2;
    @FXML
    private TextField AdExp;
    @FXML
    private TextField AdDest;
    @FXML
    private TextField Prix;
    @FXML
    private TextField tf_description;
    int index = -1;

    private TextField etat;
    @FXML
    private TextField NbObj;
    @FXML
    private TextField poids;
    private TableColumn<?, ?> tfidLivraison;
    private TableColumn<?, ?> tfidColis;
    private TextField idLiv;
    private TextField idColis;
    LivraisonService ls = new LivraisonService();
    ColisService cs = new ColisService();
    @FXML
    private Button jButton1;
    @FXML
    private ImageView qrcodee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
        String[] possibleWords = {"Ariana", "Beja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jandouba", "Kairouan", "Kasserine", "Kebili", "Kef", "Mahdia", "Manouba", "Medenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan"};
        TextFields.bindAutoCompletion(AdExp, possibleWords);
        TextFields.bindAutoCompletion(AdDest, possibleWords);
    }

    public ObservableList<LivraisonColis> getLivraisonColis(List<LivraisonColis> l) {
        ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }

    public void afficher() {

        // tfidLivraison.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        // tfidColis.setCellValueFactory(new PropertyValueFactory<>("id"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<>("nb_items"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tfPoids.setCellValueFactory(new PropertyValueFactory<>("poids"));
        table2.setItems(getLivraisonColis(ls.afficherClient(u.getId())));

    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException {

        LivraisonColis l = table2.getSelectionModel().getSelectedItem();
        if (AdExp.getText().isEmpty() || AdDest.getText().isEmpty() || Prix.getText().isEmpty() || NbObj.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setContentText("il y'a des champs vides !");
            alert.show();

        } else if (adresse_desvalide() && nb_itemsvalide() && adresse_expvalide() && Prixvalide() && Poidsvalide()) {
            l.setAdresse_expedition(AdExp.getText());
            l.setAdresse_destinataire(AdDest.getText());
            String prix2 = Prix.getText();
            l.setPrix(Float.parseFloat(prix2));
//        l.setEtat(etat.getText());
            String Nb_items = NbObj.getText();
            l.setNb_items(Integer.parseInt(Nb_items));
            String poids2 = poids.getText();
            l.setPoids(Float.parseFloat(poids2));
            l.setDescription(tf_description.getText());
            ls.modif(l);
            afficher();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("sucess");
            alert.setContentText("Livraison Modifiée avec succès");
            alert.show();

            AdExp.setText("");
            AdDest.setText("");
            Prix.setText("");
            //  etat.setText("");

            NbObj.setText("");
            poids.setText("");
            tf_description.setText("");
        }

    }

    private boolean adresse_expvalide() {
        Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(AdExp.getText());
        if (m.find() && m.group().equals(AdExp.getText())) {
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
        Matcher m = p.matcher(AdDest.getText());
        if (m.find() && m.group().equals(AdDest.getText())) {
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
        Matcher m = p.matcher(NbObj.getText());
        if (m.find() && m.group().equals(NbObj.getText())) {
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

    private boolean Prixvalide() {
        Pattern p = Pattern.compile("[0-9]+.?[0-9]?[0-9]?");
        Matcher m = p.matcher(Prix.getText());
        if (m.find() && m.group().equals(Prix.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Type du prix invalide !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un type valide !");
            alert.showAndWait();

            return false;
        }

    }

    private boolean Poidsvalide() {
        Pattern p = Pattern.compile("[0-9]+.?[0-9]?[0-9]?");
        Matcher m = p.matcher(poids.getText());
        if (m.find() && m.group().equals(poids.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Type du poids invalide !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un type valide !");
            alert.showAndWait();

            return false;
        }

    }

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = table2.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        AdExp.setText(tfAdresseExp.getCellData(index).toString());
        AdDest.setText(tfAdresseDest.getCellData(index).toString());
        Prix.setText(tfPrix.getCellData(index).toString());
        NbObj.setText(tfNBObj.getCellData(index).toString());
        tf_description.setText(tfDescription.getCellData(index).toString());
        poids.setText(tfPoids.getCellData(index).toString());
    }

    @FXML
    private void Supprimer(javafx.event.ActionEvent event) throws SQLException {

        Colis c = new Colis(table2.getSelectionModel().getSelectedItem().getId());
        cs.supprimer(c);
        afficher();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Livraison Supprimée avec succès");
        alert.show();
        AdExp.setText("");
        AdDest.setText("");
        Prix.setText("");
        NbObj.setText("");
        poids.setText("");
        tf_description.setText("");

    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            setSceneContent("FXMLAjoutLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void jButton1ActionPerformed(ActionEvent event) {
        try {

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            String QrCodeData = " Les infomations de la livraison sont : " + "\n" + " Adresse expédition: " + AdExp.getText() + "\n" + "Adresse destination : " + AdDest.getText() + "\n" + "Prix : " + Prix.getText() + "\n" + "Nombre d'objets  : " + NbObj.getText() + "\n" + "Poids du colis : " + poids.getText() + "\n" + "Description : " + tf_description.getText();

            String filePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\QR_Code\\qr.png";
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(QrCodeData.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200, hintMap);

            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
            System.out.println("Qr code has been generated at the location " + filePath);

            JFrame frame = new JFrame();
            ImageIcon icon = new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\QR_Code\\qr.png");
            JLabel label = new JLabel(icon);
            frame.add(label);
          //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);

        }
    }

}
