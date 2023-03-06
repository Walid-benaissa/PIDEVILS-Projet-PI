/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import service.ReclamationService;
import service.UtilisateurService;


/**
 * FXML Controller class
 *
 * @author walid
 */
public class FXMLStatistiquesReclamationController implements Initializable {

    @FXML
    private SwingNode chart1;
    ReclamationService rs=new ReclamationService();
    UtilisateurService us= new UtilisateurService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Map<String,Integer> res=us.statistiquesUtilisateurs();
        DefaultPieDataset data=new DefaultPieDataset();
        for (Map.Entry<String,Integer> i :res.entrySet() ){
            data.setValue(i.getKey(),i.getValue());
        }
        JFreeChart chart = ChartFactory.createPieChart(
                "Repartition d'utilisateurs",
                data,
                true,
                true,
                false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300, 300));
        chart1.setContent(chartPanel);
    }    
    
}
