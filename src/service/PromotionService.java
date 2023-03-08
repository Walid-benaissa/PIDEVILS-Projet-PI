/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Promotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;


public class PromotionService implements IService<Promotion>{
    
     Statement stm;
    Connection conn;

    public PromotionService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Promotion> afficheListe() {
        List<Promotion> list = new ArrayList<>();
        try {
            String req = "Select * from  `promotion`";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Promotion p = new Promotion();
                p.setId_promotion(RS.getInt("id_promotion"));
                p.setTaux(RS.getFloat("taux"));
                list.add(p);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void ajouter(Promotion p) {
        try {
            String req = "INSERT INTO  `promotion`(`taux`) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(req);

            ps.setFloat(1,p.getTaux());
    
            ps.executeUpdate();
            
            System.out.println("Promotion inséré");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Promotion p) {
        try {
            String req = "DELETE FROM `promotion` WHERE id_promotion="+ p.getId_promotion();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Promotion supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Promotion p) {
        try {

            String req = "UPDATE `promotion` SET `taux` = ? WHERE id_promotion=?";
            PreparedStatement ps = conn.prepareStatement(req);
           
        
            ps.setFloat(1,p.getTaux());
            ps.setInt(2, p.getId_promotion());

            ps.executeUpdate();
            System.out.println("Promotion mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
