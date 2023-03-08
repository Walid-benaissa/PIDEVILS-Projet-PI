/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author bough
 */
public class FXMLAfficherOffreController implements Initializable {
    Connection connexion ;
      Statement stm;
      private Stage stage;
      private Scene scene;
      private Parent root;

    @FXML
    private TextField txtIDoffre;
    @FXML
    private TextField txtMatricule;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtNbpassagers;
    @FXML
    private Button btnSupprimerOffre;
    @FXML
    private Button btnMettreajourOffre;
    @FXML
    private TableView<Offre> TableOffre;
    @FXML
    private TableColumn<?, ?> IDOffreColone;
    @FXML
    private TableColumn<?, ?> MatriculeColone;
    @FXML
    private TableColumn<?, ?> CinColone;
    @FXML
    private TableColumn<?, ?> NbpassagersColone;
    @FXML
    private TableColumn<?, ?> OptionsColone;
    @FXML
    private TableColumn<?, ?> StatutOffreColone;
    @FXML
    private ChoiceBox<String> StatutOffreChoice;
    private String[] statut={"Actif","Inactif"} ;
    @FXML
    private Button btnPagehome;
    @FXML
    private ChoiceBox<String> OptionsOffreChoice;
      private String[] options={"Economy","Comfort","Premuim"} ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            afficherOffre();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAfficherOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StatutOffreChoice.getItems().addAll(statut);
        StatutOffreChoice.setValue("Inactif");
        OptionsOffreChoice.getItems().addAll(options);
        OptionsOffreChoice.setValue("Economy");
    }   
     public FXMLAfficherOffreController() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @FXML
    private void SupprimerOffre(ActionEvent event) throws SQLException {
         String req = "DELETE FROM `offre_course` WHERE id_offre = " + txtIDoffre.getText() + " " ;
          if(txtIDoffre.getText().isEmpty()||txtMatricule.getText().isEmpty()||txtCin.getText().isEmpty()||txtNbpassagers.getText().isEmpty()) {
              
                Alert alert = new Alert(Alert.AlertType.ERROR); 
                alert.setTitle("Erreur!");
                alert.setContentText("Champ vide !");
                alert.show();
         
        
    }
         else {   
         stm = connexion.createStatement();
         stm.executeUpdate(req);
         Alert alert = new Alert(Alert.AlertType.INFORMATION); 
         alert.setTitle("succes!");
         alert.setContentText("Suppression validée !");
         alert.show();
         }
       txtIDoffre.setText("");
        txtMatricule.setText("");
        txtCin.setText("");
        txtNbpassagers.setText("");
        OptionsOffreChoice.setValue("Economy");
        StatutOffreChoice.setValue("Inactif");
        afficherOffre();
    }

    @FXML
    private void MetrreajourOffre(ActionEvent event) throws SQLException {
         String req = "UPDATE `offre_course` SET `matricule_vehicule`='" + txtMatricule.getText() + "',`cin_conducteur`='" + txtCin.getText() + "',`nb_passagers`='"+txtNbpassagers.getText() + "',`options_offre`='" + OptionsOffreChoice.getValue()+ "',`statut_offre`='" + StatutOffreChoice.getValue() + "' WHERE id_offre = " + txtIDoffre.getText() + " " ;
          if(txtIDoffre.getText().isEmpty()||txtMatricule.getText().isEmpty()||txtCin.getText().isEmpty()||txtNbpassagers.getText().isEmpty()) {
              
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur!");
                alert.setContentText("Champ vide !");
                alert.show();
         
        
    }
        else {
        
            stm = connexion.createStatement();
            stm.executeUpdate(req);
             Alert alert = new Alert(Alert.AlertType.INFORMATION); 
             alert.setTitle("succes!");
             alert.setContentText("Modification validé !");
             alert.show();
              

        }
        txtIDoffre.setText("");
        txtMatricule.setText("");
        txtCin.setText("");
        txtNbpassagers.setText("");
        OptionsOffreChoice.setValue("Economy");
        StatutOffreChoice.setValue("Inactif");
        afficherOffre();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
         Offre o = TableOffre.getSelectionModel().getSelectedItem() ;
        txtIDoffre.setText(""+o.getId_offre());
        txtMatricule.setText(""+o.getMatricule_vehicule());
        txtCin.setText(""+o.getCin_conducteur());
        txtNbpassagers.setText(""+o.getNb_passagers());
        OptionsOffreChoice.setValue(o.getOptions_offre());   
        StatutOffreChoice.setValue(o.getStatut_offre());  
    }


    @FXML
    private void Pagehome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/gui/FXMLPagehome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
     public ObservableList<Offre> getOffre() throws SQLException {
        ObservableList<Offre> offres;
        offres = FXCollections.observableArrayList();
        String req = "select * from offre_course";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Offre o = new Offre(rst.getInt("id_offre"),//or rst.getInt(1)
                    rst.getInt("matricule_vehicule"),
                    rst.getInt("cin_conducteur"),
                    rst.getInt("nb_passagers"),
                    rst.getString("options_offre"),
                    rst.getString("statut_offre"));
            offres.add(o);
        }
        return offres;
    }
    
    /**
     *
     * @throws SQLException
     */
    public void afficherOffre() throws SQLException{
        ObservableList<Offre> list = getOffre();
        IDOffreColone.setCellValueFactory(new PropertyValueFactory<>("id_offre"));
        MatriculeColone.setCellValueFactory(new PropertyValueFactory<>("matricule_vehicule"));
        CinColone.setCellValueFactory(new PropertyValueFactory<>("cin_conducteur"));
        NbpassagersColone.setCellValueFactory(new PropertyValueFactory<>("nb_passagers"));
        OptionsColone.setCellValueFactory(new PropertyValueFactory<>("options_offre"));
        StatutOffreColone.setCellValueFactory(new PropertyValueFactory<>("Statut_offre"));
        TableOffre.setItems(list);
        
    } 
}
