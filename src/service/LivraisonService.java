/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Livraison;
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
public class LivraisonService implements IService<Livraison> {

    Connection conn;
    Statement stm;

    public LivraisonService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List afficheListe() {
        List<Livraison> list = new ArrayList<>();
        try {
            String req = "Select * from  `livraisons`";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Livraison l = new Livraison();
                l.setId(RS.getInt("id"));
                l.setAdresse_expedition(RS.getString("Adresse_expedition"));
                l.setAdresse_destinataire(RS.getString("Adresse_destinataire"));
                list.add(l);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void ajouter(Livraison l) {
        try {
            String req = "INSERT INTO `livraisons`(`id`,`adresse_expedition`, `adresse_destinataire`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, l.getId());
            ps.setString(2, l.getAdresse_expedition());
            ps.setString(3, l.getAdresse_destinataire());
            ps.executeUpdate();

            System.out.println("Livraison ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Livraison l) {
        try {
            String req = "DELETE FROM `livraisons` WHERE id = " + l.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("livraison supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Livraison l) {
        try {

            String req = "UPDATE `livraisons` SET `adresse_expedition` = ?, `adresse_destinataire`= ? WHERE `livraisons`.`id` = ? ";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, l.getId());
            ps.setString(2, l.getAdresse_expedition());
            ps.setString(3, l.getAdresse_destinataire());
            ps.executeUpdate();
            System.out.println("Livraison modifiée avec succès");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
