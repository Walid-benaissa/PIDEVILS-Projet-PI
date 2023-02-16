/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Offre_livraison;
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
 * @author user
 */
public class OffreLivraisonService implements IService<Offre_livraison> {

    Connection conn;
    Statement stm;

    public OffreLivraisonService() {
         conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Offre_livraison> afficheListe() {
        List<Offre_livraison> list = new ArrayList<>();
        try {
            String req = "Select * from  `offre_livraison`";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Offre_livraison o = new Offre_livraison();
                o.setId(RS.getInt("id"));
                o.setPrix_livraison(RS.getFloat("prix_livraison"));
                list.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;

    }

    
    @Override
    public void ajouter(Offre_livraison o) {
        try {
            String req = "INSERT INTO `offre_livraison`(`id`, `prix_livraison`) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.setFloat(2, o.getPrix_livraison());
            ps.executeUpdate();

            System.out.println("Offre de livraison ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Offre_livraison o) {
        try {
            String req = "DELETE FROM `offre_livraison`  WHERE id = " + o.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("offre de livraison supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Offre_livraison o) {

        try {

            String req = "UPDATE `offre_livraison` SET `prix_livraison` = ? WHERE `offre_livraison`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setFloat(1, o.getPrix_livraison());
            ps.setInt(2, o.getId());
            ps.executeUpdate();
            System.out.println("offre de Livraison modifiée avec succès");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
