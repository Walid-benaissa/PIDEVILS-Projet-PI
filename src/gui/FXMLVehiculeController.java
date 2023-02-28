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
import utils.CommonController;
import static utils.CommonController.setSceneContent;
import utils.Context;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLVehiculeController extends CommonController implements Initializable {
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
    private VehiculeService vs = new VehiculeService();
 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
          
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
        Date datef=(Date) Context.getInstance().getContextObject("DateF"); 
        Date dateD=(Date) Context.getInstance().getContextObject("DateD"); 
        String lieu=(String) Context.getInstance().getContextObject("lieu"); 
        TableVehicule.setItems(FXCollections.observableList(vs.afficherVehiculesDisponibles(lieu, dateD, datef)));
        colonnenom_v.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonnetype.setCellValueFactory(new PropertyValueFactory<>("type"));
        colonneville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        PrixColone.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colonneidPROMOTION.setCellValueFactory(new PropertyValueFactory<>("idPromotion"));
        colonnedescription.setCellValueFactory(new PropertyValueFactory<>("description"));

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


