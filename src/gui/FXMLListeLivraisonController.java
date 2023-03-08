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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static org.apache.http.client.methods.RequestBuilder.options;
import service.LivraisonService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLListeLivraisonController implements Initializable {

    @FXML
    private TableView<LivraisonColis> table2;
    @FXML
    private TableColumn<?, ?> tfAdresseExp;
    @FXML
    private TableColumn<?, ?> tfAdresseDest;
    @FXML
    private TableColumn<?, ?> tfPrix;
    @FXML
    private TableColumn<?, ?> tfNBObj;
    @FXML
    private TableColumn<?, ?> tfPoids;
    @FXML
    private TableColumn<?, ?> tfDescription;
    @FXML
    private TableColumn<?, ?> TfEtat;
    LivraisonService ls = new LivraisonService();
    Utilisateur u = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");
    @FXML
    private TextField filterfield;
    final ObservableList options = FXCollections.observableArrayList();
    @FXML
    private Button btnTrier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        afficher();

    }

    @FXML
    private void getSelected(MouseEvent event) {
    }

    public ObservableList<LivraisonColis> getLivraisonColis(List<LivraisonColis> l) {
        ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }

    public ObservableList<LivraisonColis> getLivraison(List<LivraisonColis> l) {
        ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }

    public void afficher() {

        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<>("nb_items"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tfPoids.setCellValueFactory(new PropertyValueFactory<>("poids"));
        table2.setItems(getLivraisonColis(ls.afficher()));

    }

    /*public List<LivraisonColis> findLivraisonByAdresse(String adresse) {
        LivraisonService sf = new LivraisonService();
        List<LivraisonColis> result = sf.getAllLivraisonColis().stream().filter((p) -> p.getAdresse_expedition().contains(adresse.toUpperCase())).collect(Collectors.toList());
        return result;
    }*/

    @FXML
    private void Livrer(ActionEvent event) {
        LivraisonColis l = table2.getSelectionModel().getSelectedItem();
        l.setId_livreur(u.getId());
        System.out.println(u.getId());
        ls.modif2(l);
        afficher();

    }

      public void SortLivraisonByPrice() {
        LivraisonService sf = new LivraisonService();
        TreeSet<LivraisonColis> livraisons = (TreeSet<LivraisonColis>) sf.afficher().stream().collect(Collectors.toCollection(() -> new TreeSet<LivraisonColis>((a, b) -> ((int) b.getPrix() * 100) - ((int) a.getPrix() * 100))));
        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<>("nb_items"));
        tfPoids.setCellValueFactory(new PropertyValueFactory<>("Poids"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        table2.setItems(getLivraisonColis(new ArrayList<LivraisonColis>(livraisons)));
        System.out.println(livraisons);
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            setSceneContent("FXMLLivreurLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void search(ActionEvent event) throws SQLException {
        String critere = filterfield.getText();
        LivraisonService so = new LivraisonService();
        List<LivraisonColis> livraisons = so.rechercherLiv(critere);
        options.clear();
        options.addAll(livraisons);
        table2.setItems(options);
    }

    @FXML
    private void Trier(ActionEvent event) {
              SortLivraisonByPrice();
    }

}
