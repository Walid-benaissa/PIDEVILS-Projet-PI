/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import service.VehiculeService;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLAjouterVehiculeController implements Initializable {

    @FXML
    private TextField txtdesc;
    @FXML
    private TextField txtnomv;
    @FXML
    private TextField txtville;
    @FXML
    private TextField txtprix;
    @FXML
    private TextField txtphoto;
    private TextField txttype;
    
        @FXML
    private Button btnAjouter;
        private VehiculeService VehiculeService = new VehiculeService();
    @FXML
   private ChoiceBox choix_type;
       private String[] type = {"voiture", "velo", "trottinette"};
    @FXML
    private Button btnBack;
    @FXML
       private ChoiceBox choix_taux;
       private String[] taux = {"0","5", "10", "15","20", "25", "30","35", "40", "45","50", "55", "60","65", "70", "85","90"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                    choix_type.getItems().addAll(type);
            choix_type.setValue("voiture");
                choix_taux.getItems().addAll(taux);
                choix_taux.setValue("0");

    }    

    @FXML
    private void AjouterV(ActionEvent event) {
          VehiculeService sp=new VehiculeService();
          String nom_v =txtnomv.getText();
          String ville = txtville.getText();
          String photo = txtphoto.getText();
          float prix = Float.parseFloat(txtprix.getText());
          String type = (String) choix_type.getValue();
          String taux = (String) choix_taux.getValue();
          String description = txtdesc.getText();
          int id_promotion =0;
     switch(taux) {
  case "5":
    // code block
      id_promotion=2 ;
    break;
  case "10":
    // code block
      id_promotion=3 ;
    break;
  case "15":
    // code block
      id_promotion=4 ;
    break;
    case "20":
    // code block
      id_promotion=5 ;
    break;
    case "25":
    // code block
      id_promotion=6 ;
    break;
    case "30":
    // code block
      id_promotion=7 ;
    break;
    case "35":
    // code block
      id_promotion=8 ;
    break;
    case "40":
    // code block
      id_promotion=9 ;
    break;
    case "45":
    // code block
      id_promotion=10 ;
    break;
    case "50":
    // code block
      id_promotion=11;
    break;
    case "55":
    // code block
      id_promotion=12 ;
    break;
    case "60":
    // code block
      id_promotion=13 ;
    break;
    case "65":
    // code block
      id_promotion=14;
    break;
    case "70":
    // code block
      id_promotion=15;
    break;
    case "75":
    // code block
      id_promotion=16;
    break;
    case "80":
    // code block
      id_promotion=17;
    break;
    case "85":
    // code block
      id_promotion=18;
    break;
    case "90":
    // code block
      id_promotion=19 ;
    break;
    
  default:
    // code block
      id_promotion=1 ;
}
         
 
   Vehicule a = new Vehicule(nom_v,  photo,  ville,  prix, id_promotion,  description,  type);
   sp.ajouter(a);
    }

    @FXML
    private void back(ActionEvent event) {
        
        try {  
            setSceneContent("FXMLGererVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

