/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Contrat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
/**
 *
 * @author azizi
 */
public class ContratService implements IService<Contrat>{

        
    Statement stm;
    Connection conn;

    public ContratService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Contrat> afficheListe() {
        List<Contrat> list = new ArrayList<>();
        try {
            String req = "Select * from  `contrat`";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Contrat p = new Contrat();
                p.setId_contrat(RS.getInt("id"));
                p.setDate_debut(RS.getDate("date_debut"));
                p.setDate_fin(RS.getDate("date_fin"));
             
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void ajouter(Contrat p) {
        try {
            String req = "INSERT INTO  `contrat`(`id`, `date_debut`, `date_fin`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, p.getId_contrat());
            ps.setDate(2, p.getDate_debut());
            ps.setDate(3, p.getDate_fin());
          
            ps.executeUpdate();
            
            System.out.println("Contrat inséré");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Contrat p) {
        try {
            String req = "DELETE FROM `contrat` WHERE id = " + p.getId_contrat();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Contrat supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Contrat p) {
        try {

            String req = "UPDATE `contrat` SET  `date_debut` = ?, `date_fin` = ? WHERE `contrat`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setDate(1, p.getDate_debut());
            ps.setDate(2, p.getDate_fin());
            ps.setInt(3, p.getId_contrat());
         

            ps.executeUpdate();
            System.out.println("Contrat mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

    

