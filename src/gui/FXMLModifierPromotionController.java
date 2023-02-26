/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Promotion;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.PromotionService;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLModifierPromotionController implements Initializable {

    @FXML
    private Button btnmodifier;
    @FXML
    private TextField txtid_p;
    @FXML
    private TextField txtlibillé;
    @FXML
    private TextField txtid_v;
    @FXML
    private TextField txttaux;
     @FXML
    private PromotionService PromotionService = new PromotionService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Modifier(ActionEvent event) {
                int id_vehicule = Integer.parseInt(txtid_v.getText());
  
      
        float taux = Float.parseFloat(txttaux.getText());
        int id_promotion = Integer.parseInt(txtid_p.getText());
    
        String libelle = txtlibillé.getText();
  
           PromotionService sp=new PromotionService();
  Promotion a = new Promotion( id_promotion,  id_vehicule,  libelle,  taux);
   sp.modifier(a);
    List<Promotion> vList = PromotionService.afficheListe();
    }
    
}
