/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Voiture;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author USER
 */
public class VoitureService implements IService<Voiture> {

    Statement stm;
    Connection conn;

    public VoitureService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Voiture> afficheListe() {
        List<Voiture> list = new ArrayList<>();
        try {
            String req = "Select * from  `vehicule`";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Voiture p = new Voiture();
                p.setImmatriculation(RS.getString("immatriculation"));
                p.setModele(RS.getString("modele"));
                p.setMarque(RS.getString("marque"));
                p.setEtat(RS.getString("etat"));
                p.setPhoto(RS.getString("photo"));
                p.setId(RS.getInt("id"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void ajouter(Voiture p) {
        try {
            String req = "INSERT INTO  `vehicule`(`immatriculation`,`modele`, `marque`,`etat`,`photo`,`id`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getImmatriculation());
            ps.setString(2, p.getModele());
            ps.setString(3, p.getMarque());
            ps.setString(4, p.getEtat());
            FileInputStream fin1 = new FileInputStream(p.getPhoto());
            ps.setBinaryStream(5, fin1, fin1.available());
            ps.setInt(6, p.getId());
            ps.executeUpdate();

            System.out.println("Vehicule inséré");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Voiture p) {
        try {
            String req = "DELETE FROM `vehicule` WHERE immatriculation = " + p.getImmatriculation();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Vehicule supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Voiture p) {
        try {

            String req = "UPDATE `vehicule` SET modele=?, `marque` = ?, `etat` = ? , `photo` = ?  WHERE `immatriculation` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getModele());
            ps.setString(2, p.getMarque());
            ps.setString(3, p.getEtat());
            FileInputStream fin1 = new FileInputStream(p.getPhoto());
            ps.setBinaryStream(4, fin1, fin1.available());
            ps.setString(5, p.getImmatriculation());

            ps.executeUpdate();
            System.out.println("Vehicule mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
