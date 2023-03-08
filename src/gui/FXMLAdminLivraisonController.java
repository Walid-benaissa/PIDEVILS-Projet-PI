/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableColumn;
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
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entities.LivraisonColis;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.CommonController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLAdminLivraisonController extends CommonController implements Initializable {

    @FXML
    private TableView<LivraisonColis> table2;
    @FXML
    private TableColumn<?, ?> tfidLivraison;
    @FXML
    private TableColumn<?, ?> tfAdresseExp;
    @FXML
    private TableColumn<?, ?> tfAdresseDest;
    @FXML
    private TableColumn<?, ?> tfPrix;
    @FXML
    private TableColumn<?, ?> TfEtat;
    @FXML
    private TableColumn<?, ?> tfidColis;
    @FXML
    private TableColumn<?, ?> tfNBObj;
    @FXML
    private TableColumn<?, ?> tfPoids;
    @FXML
    private TableColumn<?, ?> tfDescription;
    LivraisonService ls = new LivraisonService();

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
        table2.setItems(getLivraisonColis(ls.afficherAdmin()));
      

    }

    @FXML
    private void Save(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ObservableList<LivraisonColis> dataList = table2.getItems();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Data");
        File file = fileChooser.showSaveDialog(stage);
        //file.canRead();
        if (file != null) {
            try (BufferedWriter outWriter = new BufferedWriter(new FileWriter(file))) {
                for (LivraisonColis LivraisonColiss : dataList) {
                    outWriter.write(LivraisonColiss.toString());
                    outWriter.newLine();
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Save Successful");
                alert.setHeaderText(null);
                alert.setContentText("Data saved to file: " + file.getAbsolutePath());
                alert.showAndWait();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Save Failed");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while saving the data: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

}
