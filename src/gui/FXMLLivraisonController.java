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
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLivraisonController implements Initializable {
    Connection connexion ;
     Statement stm;

    @FXML
    private TableColumn<Livraison, String> tfAdresseExp;
    @FXML
    private TableColumn<Livraison, String> tfAdresseDest;
    @FXML
    private TableColumn<Livraison, Float> tfPrix;
    @FXML
    private TableColumn<Livraison, String> TfEtat;
    @FXML
    private TableColumn<Colis, Integer> tfNBObj;
    @FXML
    private TableColumn<Colis, String> tfDescription;
    @FXML
    private TableColumn<Colis, Float> tfPoids;
    private ObservableList<Livraison> dataList = FXCollections.observableArrayList();
    private ObservableList<Colis> dataList2 = FXCollections.observableArrayList();

    @FXML
    private TableView<Colis> table;
    @FXML
    private TableView<Livraison> table2;
    @FXML
    private TextField AdExp;
    @FXML
    private TextField AdDest;
    @FXML
    private TextField Prix;
    @FXML
    private TextField tf_description;
    int index = -1;

    @FXML
    private TextField etat;
    @FXML
    private TextField NbObj;
    @FXML
    private TextField poids;
    @FXML
    private TableColumn<?, ?> tfidLivraison;
    @FXML
    private TableColumn<?, ?> tfidColis;
    @FXML
    private TextField idLiv;
    @FXML
    private TextField idColis;
    LivraisonService ls = new LivraisonService();
    ColisService cs = new ColisService();

    /**
     * Initializes the controller class.
     */
    
    public FXMLLivraisonController() {
         connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher();
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

    public ObservableList<Colis> getColis(List<Colis> c) {
        ObservableList<Colis> dataList2 = FXCollections.observableArrayList();
        for (int i = 0; i <= c.size() - 1; i++) {
            dataList2.add(c.get(i));
        }
        return dataList2;
    }

    public void afficher() throws SQLException {

        tfidLivraison.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tfidColis.setCellValueFactory(new PropertyValueFactory<>("id"));
        tfNBObj.setCellValueFactory(new PropertyValueFactory<>("nb_items"));
        tfDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tfPoids.setCellValueFactory(new PropertyValueFactory<>("poids"));
        table2.setItems(getLivraison(ls.afficheListe()));
        table.setItems(getColis(cs.afficheListe()));

    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException {
       
        Livraison l = table2.getSelectionModel().getSelectedItem();
             
        l.setAdresse_expedition(AdExp.getText());
        l.setAdresse_destinataire(AdDest.getText());
        String prix2 = Prix.getText();
        l.setPrix(Float.parseFloat(prix2));
        l.setEtat(etat.getText());
        ls.modifier(l);
        afficher();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Livraison Modifiée avec succès");
        alert.show();
         idLiv.setText("");
        AdExp.setText("");
        AdDest.setText("");
        Prix.setText("");
        etat.setText("");
        idColis.setText("");
        NbObj.setText("");
        poids.setText("");
        tf_description.setText("");
  
    }
    
  @FXML
    private void ModifierColis(ActionEvent event) throws SQLException {
        String req2 = "UPDATE `colis` SET `nb_items`='" + NbObj.getText() + "',`description`='" + tf_description.getText() + "',`poids`='" + poids.getText() + "' WHERE id= " + idColis.getText() + " ";
       
           stm = connexion.createStatement();
           stm.executeUpdate(req2);
         
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("succes!");
            alert.setContentText("Modification effectuée avec succès!");
            alert.show();
              idLiv.setText("");
        AdExp.setText("");
        AdDest.setText("");
        Prix.setText("");
        etat.setText("");
        idColis.setText("");
        NbObj.setText("");
        poids.setText("");
        tf_description.setText("");

        afficher();

        }
      
        /*String nb_items = NbObj.getText();
        String poids2 = poids.getText();
        Colis c = new Colis(Integer.parseInt(nb_items), tf_description.getText(), Float.parseFloat(poids2));
        String Nb_items = NbObj.getText();
        c.setNb_items(Integer.parseInt(Nb_items));
        String poids3 = poids.getText();
        c.setPoids(Float.parseFloat(poids2));
        c.setDescription(tf_description.getText()); 
        cs.modifier(c);
        afficher();  */  
    

    @FXML
    private void getSelected(javafx.scene.input.MouseEvent event) {
        index = table2.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idLiv.setText(tfidLivraison.getCellData(index).toString());
        AdExp.setText(tfAdresseExp.getCellData(index).toString());
        AdDest.setText(tfAdresseDest.getCellData(index).toString());
        Prix.setText(tfPrix.getCellData(index).toString());
        etat.setText(TfEtat.getCellData(index).toString());
        idColis.setText(tfidColis.getCellData(index).toString());
        NbObj.setText(tfNBObj.getCellData(index).toString());
        tf_description.setText(tfDescription.getCellData(index).toString());
        poids.setText(tfPoids.getCellData(index).toString());
    }

    @FXML
    private void Supprimer(javafx.event.ActionEvent event) throws SQLException {

        Colis c = new Colis(table.getSelectionModel().getSelectedItem().getId());
        cs.supprimer(c);
        afficher();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Livraison Supprimée avec succès");
        alert.show();
        idLiv.setText("");
        AdExp.setText("");
        AdDest.setText("");
        Prix.setText("");
        etat.setText("");
        idColis.setText("");
        NbObj.setText("");
        poids.setText("");
        tf_description.setText("");

    }

  
  

   

}
