/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livraison;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

import service.LivraisonService;
import utils.CommonController;

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

    public ObservableList<Livraison> getLivraison(List<Livraison> l) {
        ObservableList<Livraison> dataList = FXCollections.observableArrayList();
        for (int i = 0; i <= l.size() - 1; i++) {
            dataList.add(l.get(i));
        }
        return dataList;
    }

    public void afficher() throws SQLException {

        tfAdresseExp.setCellValueFactory(new PropertyValueFactory<>("adresse_expedition"));
        tfAdresseDest.setCellValueFactory(new PropertyValueFactory<>("adresse_destinataire"));
        tfPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        TfEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));

        table2.setItems(getLivraison(ls.afficheListe()));

    }


   /* @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        Livraison l = new Livraison(table2.getSelectionModel().getSelectedItem().getId_livraison());
        ls.supprimer(l);
        afficher();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("sucess");
        alert.setContentText("Livraison Supprimée avec succès");
        alert.show();

        etat.setText("");

    }*/

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

}
