/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author azizi
 */

import entities.Vehicule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

public class VehiculeService implements IService<Vehicule>{
    
     Statement stm;
    Connection conn;

    public VehiculeService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Vehicule> afficheListe() {
        List<Vehicule> list = new ArrayList<>();
        try {
            String req = "Select * from  `vehicule`";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Vehicule p = new Vehicule();
                p.setId_vehicule(RS.getString("id_vehicule"));
                p.setCin(RS.getString("cin"));
                p.setId_promotion(RS.getInt("id_promotion"));
                p.setPhoto(RS.getString("photo"));
                p.setVille(RS.getString("ville"));
                p.setPrix(RS.getFloat("prix"));
                p.setDisponibilite(RS.getBoolean("disponibilite"));
                p.setDescription(RS.getString("description"));
                p.setType(RS.getString("type"));
              
                list.add(p);
            }
            
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

public static boolean estChaineValide(String chaine) {
    // Vérifier si la chaîne est vide ou nulle
   
    // Vérifier si la chaîne ne contient que des lettres
    if (!chaine.matches("[a-zA-Z ]+") || chaine.trim().isEmpty()) {
        return false;
    }
    
    // La chaîne est valide si elle passe toutes les vérifications
    return true;
}
  public boolean isStringLength(String str) {
    return str.length() < 30;
}

    
    @Override
    public void ajouter(Vehicule p) {
        try {
            String req = "INSERT INTO  `vehicule`(`id_vehicule`, `cin`,`id_promotion`, `photo`, `ville`,`prix`, `disponibilite`, `description`,`type`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
           p.setVille(p.getVille().trim());
            p.setType(p.getType().trim());
         if (estChaineValide(p.getVille())&&estChaineValide(p.getType())&&isStringLength(p.getType())) {
            ps.setString(1, p.getId_vehicule());
            ps.setString(2, p.getCin());
            ps.setInt(3, p.getId_promotion());
            ps.setString(4, p.getPhoto());
            ps.setString(5, p.getVille());
            ps.setFloat(6, p.getPrix());
            ps.setBoolean(7, p.isDisponibilite());
            ps.setString(8, p.getDescription());
            ps.setString(9, p.getType());
            ps.executeUpdate();}
         else{
             System.out.println("erreur");
         }
         
            System.out.println("Vehicule inséré");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
        public void supprimer(Vehicule p) {
        try {
           String req = "DELETE FROM `vehicule` WHERE `id_vehicule` = " + p.getId_vehicule();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Vehicule supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Vehicule p) {
        try {

            String req = "UPDATE `vehicule` SET cin=?, `photo` = ?,`id_promotion`=?,`ville` = ?, `prix` = ?, `disponibilite` = ?, `description` = ?, `type` = ? WHERE id_vehicule= ?";
            PreparedStatement ps = conn.prepareStatement(req);
             p.setVille(p.getVille().trim());
            p.setType(p.getType().trim());
         if (estChaineValide(p.getVille())&&estChaineValide(p.getType())&&isStringLength(p.getType())) {
            ps.setString(1, p.getCin());
            ps.setString(2, p.getPhoto());
            ps.setInt(3, p.getId_promotion());
            ps.setString(4, p.getVille());
            ps.setFloat(5, p.getPrix());
            ps.setBoolean(6, p.isDisponibilite());
            ps.setString(7, p.getDescription());
            ps.setString(8, p.getType());
            ps.setString(9, p.getId_vehicule());

            ps.executeUpdate();}
            else{
             System.out.println("erreur");
         }
            System.out.println("Vehicule mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
