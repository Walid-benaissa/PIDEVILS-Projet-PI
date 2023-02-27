/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import utils.CommonController;
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
  //  private ObservableList<Colis> dataList2 = FXCollections.observableArrayList();

  //  private TableView<Colis> table;
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

    /**
     * Initializes the controller class.
     */
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
        public ObservableList<LivraisonColis> getLivraisonColis (List<LivraisonColis> l) {
        ObservableList<LivraisonColis> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }

    public void afficher() throws SQLException {

       // tfidLivraison.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
       // tfidColis.setCellValueFactory(new PropertyValueFactory<>("id"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<>("nb_items"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tfPoids.setCellValueFactory(new PropertyValueFactory<>("poids"));
        table2.setItems(getLivraisonColis(ls.afficher()));


    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException {

        LivraisonColis l = table2.getSelectionModel().getSelectedItem();
 if (AdExp.getText().isEmpty() || AdDest.getText().isEmpty() || Prix.getText().isEmpty() || NbObj.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!");
            alert.setContentText("il y'a des champs vides !");
            alert.show();

        }
 else if (adresse_desvalide() && nb_itemsvalide() && adresse_expvalide()) {
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

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = table2.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
       // idLiv.setText(tfidLivraison.getCellData(index).toString());
        AdExp.setText(tfAdresseExp.getCellData(index).toString());
        AdDest.setText(tfAdresseDest.getCellData(index).toString());
        Prix.setText(tfPrix.getCellData(index).toString());
   //     etat.setText(TfEtat.getCellData(index).toString());
      //  idColis.setText(tfidColis.getCellData(index).toString());
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
      //  idLiv.setText("");
        AdExp.setText("");
        AdDest.setText("");
        Prix.setText("");
        etat.setText("");
      //  idColis.setText("");
        NbObj.setText("");
        poids.setText("");
        tf_description.setText("");

    }

    @FXML
    private void routeGererProfil(ActionEvent event) {
    }

    @FXML
    private void routeGererReclamation(ActionEvent event) {
    }

    @FXML
    private void routeGererLivraisions(ActionEvent event) {
    }

    @FXML
    private void routeGererCourse(ActionEvent event) {
    }

    @FXML
    private void routeGererLocation(ActionEvent event) {
    }

    @FXML
    private void Ajouter(ActionEvent event) {
           try {
            setSceneContent("FXMLAjoutLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
