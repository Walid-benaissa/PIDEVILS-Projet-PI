/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Colis;
import entities.Livraison;
import entities.LivraisonColis;
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
            String req = "Select * from  `livraison`";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Livraison l = new Livraison();
                l.setId_livraison(RS.getInt("id_livraison"));
                l.setAdresse_expedition(RS.getString("Adresse_expedition"));
                l.setAdresse_destinataire(RS.getString("Adresse_destinataire"));
                l.setPrix(RS.getFloat("Prix"));
                l.setEtat(RS.getString("Etat"));
                l.setId_colis(RS.getInt("id_colis"));
                list.add(l);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public List afficher() {
        List<LivraisonColis> list = new ArrayList<>();
        try {
            String req = "Select * from  `livraison`,`colis` WHERE `livraison`.`id_livraison` =`colis`.`id` ";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                LivraisonColis l = new LivraisonColis();
                
                l.setId_livraison(RS.getInt("id_livraison"));
                l.setAdresse_expedition(RS.getString("Adresse_expedition"));
                l.setAdresse_destinataire(RS.getString("Adresse_destinataire"));
                l.setPrix(RS.getFloat("Prix"));
                l.setEtat(RS.getString("Etat"));
                l.setId(RS.getInt("id"));
                l.setDescription(RS.getString("Description"));
                l.setNb_items(RS.getInt("Nb_items"));
                l.setPoids(RS.getFloat("Poids"));
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
            String req = "Select max(id) as id from  `colis`";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            RS.next();
            int id = RS.getInt("id");
            req = "INSERT INTO `livraison`(`id_livraison`,`adresse_expedition`, `adresse_destinataire`, `prix`,`etat`, `id_colis`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, l.getId_livraison());
            ps.setString(2, l.getAdresse_expedition());
            ps.setString(3, l.getAdresse_destinataire());
            ps.setFloat(4, l.getPrix());
            ps.setString(5, l.getEtat());
            ps.setInt(6, id);
            ps.executeUpdate();

            System.out.println("Livraison ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Livraison l) {
        try {
            String req = "DELETE FROM `livraison` WHERE id_livraison = " + l.getId_livraison();
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

            String req = "UPDATE `livraison` SET `adresse_expedition` = ?, `adresse_destinataire`= ?, `prix`= ?, `etat`= ? WHERE `livraison`.`id_livraison` = ? ";
            PreparedStatement ps = conn.prepareStatement(req);

            ps.setString(1, l.getAdresse_expedition());
            ps.setString(2, l.getAdresse_destinataire());
            ps.setFloat(3, l.getPrix());
            ps.setString(4, l.getEtat());
            ps.setInt(5, l.getId_livraison());
            ps.executeUpdate();
            System.out.println("Livraison modifiée avec succès");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
