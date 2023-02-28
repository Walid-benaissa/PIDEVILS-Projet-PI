/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import service.VehiculeService;
import static utils.CommonController.setSceneContent;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLVehiculeController implements Initializable {
  //  public class VehiculeService implements IService<Vehicule>{
    
     Statement stm;
    Connection conn;
       public FXMLVehiculeController() {
        conn = MyDB.getInstance().getConnexion();
    }


  
    @FXML
    private Button btnBack;
   
    @FXML
    private TableColumn<?, ?> colonnenom_v;
    @FXML
    private TableColumn<?, ?> colonnetype;
    @FXML
    private TableColumn<?, ?> colonneville;
    @FXML
    private TableColumn<?, ?> PrixColone;
    @FXML
    private TableColumn<?, ?> colonneidPROMOTION;
    @FXML
    private TableColumn<?, ?> colonnedescription;
      @FXML
    private TableView<Vehicule> TableVehicule;
    private VehiculeService vehiculesDisponibles = new VehiculeService();
 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
          
       /*  colonneville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        PrixColone.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colonneidPROMOTION.setCellValueFactory(new PropertyValueFactory<>("id_promotion"));
        colonnedescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colonnetype.setCellValueFactory(new PropertyValueFactory<>("type"));
         colonnenom_v.setCellValueFactory(new PropertyValueFactory<>("nom_v"));

            // récupère les données des utilisateurs depuis la base de données
            List<Vehicule> vleList = VehiculeService.afficheListe();
            
      
        
        // affiche les données dans le tableau
        TableVehicule.getItems().setAll(vleList);*/

       public void afficherVehiculesDisponibles(String lieu, Date date_debut, Date date_fin)  {
        List<Vehicule> vehiculesDisponibles = new ArrayList<>();
        try {
        String query = "SELECT * FROM vehicule WHERE disponibilite = 'true' AND lieu = ? AND id_vehicule NOT IN " +
                "(SELECT id_vehicule FROM location WHERE (date_debut <= ? AND date_fin >= ?))";
         PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, lieu);
        st.setDate(2, date_fin);
        st.setDate(3, date_debut);
        ResultSet RS = st.executeQuery();
        while (RS.next()) {
            int id_vehicule = RS.getInt("id_vehicule");
            String nom = RS.getString("nom_v");
            double taux = RS.getDouble("taux");
            String photo = RS.getString("photo");
            String villeV = RS.getString("ville");
            double prix = RS.getDouble("prix");
            String disponibilite = RS.getString("disponibilite");
            String description = RS.getString("description");
            String type = RS.getString("type");
            Vehicule a = new Vehicule(id_vehicule,nom_v ,  id,  photo,  ville,  prix,  id_promotion,  description,  type);
            vehiculesDisponibles.add(a);
        }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        TableVehicule.setItems(FXCollections.observableList(vehiculesDisponibles));
        colonnenom_v.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonnetype.setCellValueFactory(new PropertyValueFactory<>("type"));
        colonneville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        PrixColone.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colonneidPROMOTION.setCellValueFactory(new PropertyValueFactory<>("idPromotion"));
        colonnedescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

  }

       


    @FXML
    private void back(ActionEvent event) {
          try {  
            setSceneContent("FXMLlouerVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }

    
    
  
     
  
        
    }


