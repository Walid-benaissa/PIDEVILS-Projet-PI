/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livraison;
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
    private TableView<Livraison> table2;
    LivraisonService ls = new LivraisonService();
    int index = -1;
    private ObservableList<Livraison> dataList = FXCollections.observableArrayList();
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");

    private TextField txt_search;
    @FXML
    private Button btnTrier;
    @FXML
    private Button txtbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher();
            //findLivraisonByAdresse(txt_search.getText());
            //SortForumByTitle();
       } catch (SQLException ex) {
            Logger.getLogger(FXMLCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Livraison> getLivraison(List<Livraison> l) {
        ObservableList<Livraison> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }
    
        public List<Livraison> findLivraisonByAdresse(String adresse) {
        LivraisonService sf = new LivraisonService();
        List<Livraison> result = sf.getAllLivraison().stream().filter((p) -> p.getAdresse_expedition().contains(adresse.toUpperCase())).collect(Collectors.toList());
        return result;
    }

    public void SortForumByTitle() {
        LivraisonService sf = new LivraisonService();
        TreeSet<Livraison> forums = sf.afficherLivreur(u.getId()).stream().collect(Collectors.toCollection(() -> new TreeSet<Livraison>((a, b) -> ((int) b.getPrix() * 100) - ((int) a.getPrix() * 100))));
        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        table2.setItems(getLivraison(new ArrayList<Livraison>(forums)));
        System.out.println(forums);
    }


  
    public void afficher() throws SQLException {

        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));

        table2.setItems(getLivraison(ls.afficherLivreur(u.getId())));
/*        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
 table2.getItems().clear();
            List<Livraison> Liv =  findLivraisonByAdresse(newValue);

        table2.setItems(getLivraison(Liv));
        
       

              });*/

    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        Livraison l = table2.getSelectionModel().getSelectedItem();
        l.setEtat(etat.getText());

        ls.modifier(l);
        afficher();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Etat de livraison Modifié avec succès");
        alert.show();
        etat.setText("");
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
        SortForumByTitle();
        
    }

    @FXML
    private void sms(ActionEvent event) {
             try {
            setSceneContent("FXMLsms");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void qrcode(ActionEvent event) {
           try {
            setSceneContent("FXMLColis");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    

}
