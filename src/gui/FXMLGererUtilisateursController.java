/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.UtilisateurService;
import utils.CommonController;
import java.io.FileWriter;
import java.util.Arrays;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLGererUtilisateursController extends CommonController implements Initializable {

    @FXML
    private TableView<Utilisateur> TableUsers;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> nomCol;
    @FXML
    private TableColumn<?, ?> prenomCol;
    @FXML
    private TableColumn<?, ?> mailCol;
    @FXML
    private TableColumn<?, ?> numtelCol;
    @FXML
    private TableColumn<?, ?> roleCol;
    @FXML
    private TableColumn<?, ?> evaluationCol;
    @FXML
    private TextField txtID;
    @FXML
    private Button btnSupprimer;
    UtilisateurService us = new UtilisateurService();
    private String[] roles = {"Client", "Conducteur", "Locateur"};
    @FXML
    private ChoiceBox choix_type;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField rechercheNom;
    @FXML
    private TextField recherchePrenom;
    @FXML
    private Button telecharger;
    @FXML
    private Button btnBloquer;
    @FXML
    private TableColumn<?, ?> bloqueCol;
    @FXML
    private Pane details;
    @FXML
    private Button btnDetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherUsers(us.afficheListe());
        choix_type.getItems().addAll(roles);

    }

    public void afficherUsers(List<Utilisateur> list) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        mailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
        numtelCol.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        evaluationCol.setCellValueFactory(new PropertyValueFactory<>("evaluation"));
        bloqueCol.setCellValueFactory(new PropertyValueFactory<>("bolque"));
        ObservableList<Utilisateur> L = FXCollections.observableArrayList(list);
        TableUsers.setItems(L);
        System.out.println(L);

    }
    boolean etatbloque;

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Utilisateur u = TableUsers.getSelectionModel().getSelectedItem();
        txtID.setText("Id: " + u.getId());
        choix_type.setValue(u.getRole());
        etatbloque = u.isBolque();
        if (u.isBolque()) {
            btnBloquer.setText("Débloquer");
        } else {
            btnBloquer.setText("Bloquer");

        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        Utilisateur u = new Utilisateur(TableUsers.getSelectionModel().getSelectedItem().getId());
        us.supprimer(u);
        afficherUsers(us.afficheListe());
    }

    @FXML
    private void modifierReclamation(ActionEvent event) {
        Utilisateur u = TableUsers.getSelectionModel().getSelectedItem();
        u.setRole(choix_type.getValue().toString());
        us.modifier(u);
        afficherUsers(us.afficheListe());

    }

    @FXML
    private void rechercherN(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            afficherUsers(us.rechercherNom(rechercheNom.getText()));
        }
    }

    @FXML
    private void rechercherP(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            afficherUsers(us.rechercherPrenom(recherchePrenom.getText()));
        }
    }

    @FXML
    private void telecharger(ActionEvent event) {

        String[] items1 = {"ID", "Nom", "Prénom", "mail", "numero de téléphone", "Role", "evaluation"};

        List<String[]> entries = new ArrayList<>();
        entries.add(items1);

        for (Utilisateur i : us.afficheListe()) {
            String[] items2 = {Integer.toString(i.getId()), i.getNom(), i.getPrenom(),
                i.getMail(), i.getNum_tel(), i.getRole(), Float.toString(i.getEvaluation())};
            entries.add(items2);
        }

        String fileName = "src/main/resources/items.csv";

        try (FileOutputStream fos = new FileOutputStream("output.csv");
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                CSVWriter writer = new CSVWriter(osw)) {

            writer.writeAll(entries);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLGererUtilisateursController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererUtilisateursController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void bloquer(ActionEvent event) {
        Utilisateur u = TableUsers.getSelectionModel().getSelectedItem();
        u.setBolque(!u.isBolque());
        us.modifier(u);
        afficherUsers(us.afficheListe());
        if (u.isBolque()) {
            btnBloquer.setText("Débloquer");
        } else {
            btnBloquer.setText("Bloquer");

        }

    }

    @FXML
    private void details(ActionEvent event) {
        Context.getInstance().addContextObject("user", TableUsers.getSelectionModel().getSelectedItem());
        Context.getInstance().addContextObject("role", TableUsers.getSelectionModel().getSelectedItem().getRole());
        try {
            setSceneContent("FXMLDetailsUtilisateur");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
