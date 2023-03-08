/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Utilisateur;
import entities.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.VehiculeService;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class FXMLModifierVehiculeController implements Initializable {
    Utilisateur k = (Utilisateur) Context.getInstance().getContextObject("UtilisateurCourant");

    @FXML
    private Button btnModifier;
    @FXML
    private TextField txtdesc;
    @FXML
    private TextField txtnomv;
    @FXML
    private TextField txtville;
    @FXML
    private TextField txtprix;
    private TextField txtidp;
    private TextField txtphoto;
    private TextField txttype;
    private TextField txtidv;
    private VehiculeService VehiculeService = new VehiculeService();
    @FXML
    private ChoiceBox choix_taux;
    private String[] taux = {"0", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "85", "90"};
    @FXML
    private ChoiceBox choix_type;
    private String[] type = {"voiture", "velo", "trottinette"};
    Vehicule u = (Vehicule) Context.getInstance().getContextObject("Vehicule");

    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choix_type.getItems().addAll(type);

        choix_taux.getItems().addAll(taux);

        choix_type.setValue(u.getType());
        txtnomv.setText(u.getNom_v());

        txtville.setText(u.getVille());
        txtprix.setText(String.valueOf(u.getPrix()));
        switch (u.getId_promotion()) {
            case 2:
                // code block
                choix_taux.setValue("5");
                break;
            case 3:
                // code block
                choix_taux.setValue("10");
                break;
            case 4:
                // code block
                choix_taux.setValue("15");
                break;
            case 5:
                // code block
                choix_taux.setValue("20");
                break;
            case 6:
                // code block
                choix_taux.setValue("25");
                break;
            case 7:
                // code block
                choix_taux.setValue("30");
                break;
            case 8:
                // code block
                choix_taux.setValue("35");
                break;
            case 9:
                // code block
                choix_taux.setValue("40");
                break;
            case 10:
                // code block
                choix_taux.setValue("45");
                break;
            case 11:
                // code block
                choix_taux.setValue("50");
                break;
            case 12:
                // code block
                choix_taux.setValue("55");
                break;
            case 13:
                // code block
                choix_taux.setValue("60");
                break;
            case 14:
                // code block
                choix_taux.setValue("65");
                break;
            case 15:
                // code block
                choix_taux.setValue("70");
                break;
            case 16:
                // code block
                choix_taux.setValue("75");
                break;
            case 17:
                // code block
                choix_taux.setValue("80");
                break;
            case 18:
                // code block
                choix_taux.setValue("85");
                break;
            case 19:
                // code block
                choix_taux.setValue("90");
                break;

            default:
                // code block
                choix_taux.setValue("0");
        }
        choix_taux.setValue(taux);

        txtdesc.setText(u.getDescription());

        //      choix_id.setValue(a.getIdVehicule());
    }

    @FXML
    private void ModifierV(ActionEvent event) {

        String type = choix_type.getValue().toString();
        String nom_v = txtnomv.getText();

        String ville = txtville.getText();
        float prix = Float.parseFloat(txtprix.getText());
        String taux = choix_taux.getValue().toString();
        String description = txtdesc.getText();
        int id_promotion;
        switch (taux) {
            case "5":
                // code block
                id_promotion = 2;
                break;
            case "10":
                // code block
                id_promotion = 3;
                break;
            case "15":
                // code block
                id_promotion = 4;
                break;
            case "20":
                // code block
                id_promotion = 5;
                break;
            case "25":
                // code block
                id_promotion = 6;
                break;
            case "30":
                // code block
                System.out.println("test");
                id_promotion = 7;
                break;
            case "35":
                // code block
                id_promotion = 8;
                break;
            case "40":
                // code block
                id_promotion = 9;
                break;
            case "45":
                // code block
                id_promotion = 10;
                break;
            case "50":
                // code block
                id_promotion = 11;
                break;
            case "55":
                // code block
                id_promotion = 12;
                break;
            case "60":
                // code block
                id_promotion = 13;
                break;
            case "65":
                // code block
                id_promotion = 14;
                break;
            case "70":
                // code block
                id_promotion = 15;
                break;
            case "75":
                // code block
                id_promotion = 16;
                break;
            case "80":
                // code block
                id_promotion = 17;
                break;
            case "85":
                // code block
                id_promotion = 18;
                break;
            case "90":
                // code block
                id_promotion = 19;
                break;

            default:
                // code block
                id_promotion = 1;
        }

        VehiculeService sp = new VehiculeService();
        Vehicule a = new Vehicule(u.getId_vehicule(), nom_v,  ville, prix, id_promotion, description, type);
           a.setId(k.getId());
        sp.modifier(a);
        List<Vehicule> vList = VehiculeService.afficheListe();
    }

//    private void promotion(ActionEvent event) {
//         try {
//            Parent root = FXMLLoader.load(getClass().getResource("/gui/FXMLCreePromotion.fxml"));
//            
//            Scene sc = new Scene(root);
//            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
//            stage.setScene(sc);
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLModifierVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @FXML
    private void back(ActionEvent event) {
        try {
            setSceneContent("FXMLGererVehicule");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
