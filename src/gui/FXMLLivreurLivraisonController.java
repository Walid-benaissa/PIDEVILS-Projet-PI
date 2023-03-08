/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livraison;
import entities.LivraisonColis;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import service.LivraisonService;
import utils.CommonController;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLivreurLivraisonController extends CommonController implements Initializable {

    @FXML
    private Button btnModifier;
    @FXML
    private TableColumn<?, ?> tfAdresseExp;
    @FXML
    private TableColumn<?, ?> tfAdresseDest;
    @FXML
    private TableColumn<?, ?> tfPrix;
    @FXML
    private TableColumn<?, ?> TfEtat;
    @FXML
    private TextField etat;
    @FXML
    private TableView<LivraisonColis> table2;
    LivraisonService ls = new LivraisonService();
    int index = -1;
    // private ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");

    private TextField txt_search;
    @FXML
    private Button btnTrier;
    @FXML
    private Button txtbtn;
    @FXML
    private TableColumn<?, ?> Poids;
    @FXML
    private TableColumn<?, ?> tfDescription;
    @FXML
    private TableColumn<?, ?> tfNBObj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        afficher();

    }

    private boolean Etat_valide() {
        Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(etat.getText());
        if (m.find() && m.group().equals(etat.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Type d'état invalide !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un type valide !");
            alert.showAndWait();

            return false;
        }
    }

    /* public ObservableList<Livraison> getLivraison(List<Livraison> l) {
        ObservableList<Livraison> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }*/
    public ObservableList<LivraisonColis> getLivraisonColis(List<LivraisonColis> l) {
        ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }

    public void SortLivraisonByPrice() {
        LivraisonService sf = new LivraisonService();
        TreeSet<LivraisonColis> livraisons = sf.afficherLivreur(u.getId()).stream().collect(Collectors.toCollection(() -> new TreeSet<LivraisonColis>((a, b) -> ((int) b.getPrix() * 100) - ((int) a.getPrix() * 100))));
        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        table2.setItems(getLivraisonColis(new ArrayList<LivraisonColis>(livraisons)));
        System.out.println(livraisons);
    }

    public void afficher() {

        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<>("nb_items"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        Poids.setCellValueFactory(new PropertyValueFactory<>("poids"));
        table2.setItems(getLivraisonColis(ls.afficherLivreur(u.getId())));
        /*        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
 table2.getItems().clear();
            List<Livraison> Liv =  findLivraisonByAdresse(newValue);

        table2.setItems(getLivraison(Liv));
        
       

              });*/

    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        LivraisonColis l = table2.getSelectionModel().getSelectedItem();
        if (etat.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setContentText("Champs Vide!");
            alert.show();
        } else if (Etat_valide()) {
            l.setEtat(etat.getText());
            ls.modif(l);
            afficher();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("sucess");
            alert.setContentText("Etat de livraison Modifié avec succès");
            alert.show();
            etat.setText("");
        }
    }

    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = table2.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }

        etat.setText(TfEtat.getCellData(index).toString());
    }

    @FXML
    private void retour(ActionEvent event) {

        try {
            setSceneContent("FXMLListeLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Trier(ActionEvent event) {
        SortLivraisonByPrice();

    }

    @FXML
    private void sms(ActionEvent event) {
        try {
            setSceneContent("FXMLsms");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void qrcode(ActionEvent event) {
        try {
            setSceneContent("FXMLColis");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
