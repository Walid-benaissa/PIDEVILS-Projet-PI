/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.CommonController;

/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLAvisSurConducteurController extends CommonController implements Initializable {

    @FXML
    private Button eval1;
    @FXML
    private Button eval2;
    @FXML
    private Button eval3;
    @FXML
    private Button eval4;
    @FXML
    private Button eval5;
    @FXML
    private TextArea tf_comment;
    @FXML
    private ImageView etoile1;
    @FXML
    private ImageView etoile2;
    @FXML
    private ImageView etoile3;
    @FXML
    private ImageView etoile4;
    @FXML
    private ImageView etoile5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void evaluation(ActionEvent event) {
        switch(((Node) event.getSource()).getId()){
            case "eval1":
                etoile1.setImage(new Image("/images/star (1).png/"));
                break;
        }
    }
    
}
