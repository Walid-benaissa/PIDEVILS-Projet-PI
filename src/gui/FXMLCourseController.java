/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Course;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.MyDB;


/**
 * FXML Controller class
 *
 * @author bough
 */
public class FXMLCourseController implements Initializable {
    Connection connexion ;
     Statement stm;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficherCourse();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        StatutChoice.getItems().addAll(statut);
        StatutChoice.setValue("En attente");
    }    
    public FXMLCourseController() {
        connexion = MyDB.getInstance().getConnexion();
    }
    
     @FXML
    private TextField txtID;

    @FXML
    private TextField txtDepart;

    @FXML
    private TextField txtDestination;

    @FXML
    private TextField txtDistance;

    @FXML
    private TextField txtPrix;


    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnMettreajour;
    
     @FXML
    private ChoiceBox<String> StatutChoice;
    
    private String[] statut={"En attente","En cours","Termine"} ;
     
    @FXML
    private TableView<Course> TableCourse;
  
    @FXML
    private TableColumn<Course, Integer> IDColone;

    @FXML
    private TableColumn<Course, String> DepartColone;

    @FXML
    private TableColumn<Course, String> DestinationColone;

    @FXML
    private TableColumn<Course, Float> DistanceColone;

    @FXML
    private TableColumn<Course, Float> PrixColone;

    @FXML
    private TableColumn<Course, String> StatutColone;
    

    @FXML
    private void Ajouter(javafx.event.ActionEvent event) throws SQLException {
        String req = "INSERT INTO `course` (`id_course`,`point_depart`, `point_destination`, `distance`, `prix`, `statut_course`) VALUES (  '" + txtID.getText()+ "','" + txtDepart.getText()+ "', '" + txtDestination.getText()+ "', '" + txtDistance.getText()+ "', '" + txtPrix.getText() + "', '" + StatutChoice.getValue()+ "') ";
        if(txtID.getText().isEmpty()||txtDepart.getText().isEmpty()||txtDestination.getText().isEmpty()||txtDistance.getText().isEmpty()||txtPrix.getText().isEmpty()) {
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
             alert.setContentText("Ajout validé !");
             alert.show();

        }
        txtID.setText("");
        txtDepart.setText("");
        txtDestination.setText("");
        txtDistance.setText("");
        txtPrix.setText("");
        StatutChoice.setValue("En attente");
        afficherCourse();
      
    }
          

    @FXML
    private void Supprimer(javafx.event.ActionEvent event) throws SQLException {
        String req = "DELETE FROM `course` WHERE id_course = " + txtID.getText() + " " ;
         if(txtID.getText().isEmpty()||txtDepart.getText().isEmpty()||txtDestination.getText().isEmpty()||txtDistance.getText().isEmpty()||txtPrix.getText().isEmpty()) {
              
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
        txtID.setText("");
        txtDepart.setText("");
        txtDestination.setText("");
        txtDistance.setText("");
        txtPrix.setText("");
        StatutChoice.setValue("En attente");
        afficherCourse();
    }

    @FXML
    private void Metrreajour(javafx.event.ActionEvent event) throws SQLException {
        
        String req = "UPDATE `course` SET `point_depart`='" + txtDepart.getText() + "',`point_destination`='" + txtDestination.getText() + "',`distance`='"+txtDistance.getText() + "',`prix`='" + txtPrix.getText() + "',`statut_course`='" + StatutChoice.getValue() + "' WHERE id_course = " + txtID.getText() + " " ;
          if(txtID.getText().isEmpty()||txtDepart.getText().isEmpty()||txtDestination.getText().isEmpty()||txtDistance.getText().isEmpty()||txtPrix.getText().isEmpty()) {
              
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
        txtID.setText("");
        txtDepart.setText("");
        txtDestination.setText("");
        txtDistance.setText("");
        txtPrix.setText("");
        StatutChoice.setValue("En attente");
        afficherCourse();
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public ObservableList<Course> getCourse() throws SQLException {
        ObservableList<Course> courses;
        courses = FXCollections.observableArrayList();
        String req = "select * from course";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Course c = new Course(rst.getInt("id_course"),//or rst.getInt(1)
                    rst.getString("point_depart"),
                    rst.getString("point_destination"),
                    rst.getFloat("distance"),
                    rst.getFloat("prix"),
                    rst.getString("statut_course"));
            courses.add(c);
        }
        return courses;
    }
    
    public void afficherCourse() throws SQLException{
        ObservableList<Course> list = getCourse() ;
        IDColone.setCellValueFactory(new PropertyValueFactory<>("id_course"));
        DepartColone.setCellValueFactory(new PropertyValueFactory<>("point_depart"));
        DestinationColone.setCellValueFactory(new PropertyValueFactory<>("point_destination"));
        DistanceColone.setCellValueFactory(new PropertyValueFactory<>("distance"));
        PrixColone.setCellValueFactory(new PropertyValueFactory<>("prix"));
        StatutColone.setCellValueFactory(new PropertyValueFactory<>("Statut_course"));
        TableCourse.setItems(list);
        
    } 
    
    @FXML
    private void handleMouseAction(javafx.scene.input.MouseEvent event) {
       Course c = TableCourse.getSelectionModel().getSelectedItem() ;
        txtID.setText(""+c.getId_course());
        txtDepart.setText(c.getPoint_depart());
        txtDestination.setText(c.getPoint_destination());
        txtDistance.setText(""+c.getDistance());
        txtPrix.setText(""+c.getPrix());
        StatutChoice.setValue(c.getStatut_course());   
    }
}
