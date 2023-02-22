/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLVehiculeController implements Initializable {

    @FXML
    private TextArea desc;
    @FXML
    private TextArea prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Selectionner(ActionEvent event) {
    }

    public TextArea getDesc() {
        return desc;
    }

    public void setDesc(String message) {
        this.desc.setText(message);
    }

    public TextArea getPrix() {
        return prix;
    }

    public void setPrix(TextArea prix) {
        this.prix = prix;
    }
    
  
     
  
        
    }

