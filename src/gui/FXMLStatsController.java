/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Offre;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author bough
 */
public class FXMLStatsController implements Initializable {
     Connection connexion ;
      Statement stm;
    @FXML
    private PieChart pieChart;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
       try {
            afficherPie();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLStatsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public FXMLStatsController() {
        connexion = MyDB.getInstance().getConnexion();
    }    
    
    public void afficherPie() throws SQLException{
        int activeOffersCount=0 ;
        int inactiveOffersCount=0 ;
         String req = "SELECT COUNT(*) AS count FROM offre_course WHERE statut_offre='Actif' ";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
           activeOffersCount = rst.getInt(1);
        }
         PieChart.Data qtr1= new PieChart.Data("Offre Actif", +activeOffersCount) ;
         String req1 = "SELECT COUNT(*) AS count FROM offre_course WHERE statut_offre='Inactif' ";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst1 = stm.executeQuery(req1);

        while (rst1.next()) {
         inactiveOffersCount = rst1.getInt(1);
        }
         PieChart.Data qtr2= new PieChart.Data("Offre Inctif", +inactiveOffersCount) ;
         pieChart.getData().addAll(qtr1,qtr2) ;
        
    }
    
}
