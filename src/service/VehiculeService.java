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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
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
                p.setId_vehicule(RS.getInt("id_vehicule"));
                p.setNom_v(RS.getString("nom_v"));
                p.setId(RS.getInt("id"));
                p.setId_promotion(RS.getInt("taux"));
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
            String req = "INSERT INTO  `vehicule`(`nom_v`,`id`,`taux`, `photo`, `ville`,`prix`, `disponibilite`, `description`,`type`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
           p.setVille(p.getVille().trim());
            p.setType(p.getType().trim());
         if (estChaineValide(p.getVille())&&estChaineValide(p.getType())&&isStringLength(p.getType())) {
            ps.setString(1, p.getNom_v());
            ps.setInt(2, p.getId());
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

            String req = "UPDATE `vehicule` SET `nom_v`= ? ,`id`=?, `photo` = ?,`taux`=?,`ville` = ?, `prix` = ?, `disponibilite` = ?, `description` = ?, `type` = ? WHERE id_vehicule= ?";
            PreparedStatement ps = conn.prepareStatement(req);
             p.setVille(p.getVille().trim());
            p.setType(p.getType().trim());
         if (estChaineValide(p.getVille())&&estChaineValide(p.getType())&&isStringLength(p.getType())) {
            ps.setString(1, p.getNom_v());
            ps.setInt(2, p.getId());
            ps.setString(3, p.getPhoto());
            ps.setInt(4, p.getId_promotion());
            ps.setString(5, p.getVille());
            ps.setFloat(6, p.getPrix());
            ps.setBoolean(7, p.isDisponibilite());
            ps.setString(8, p.getDescription());
            ps.setString(9, p.getType());
            ps.setInt(10, p.getId_vehicule());

            ps.executeUpdate();}
            else{
             System.out.println("erreur");
         }
            System.out.println("Vehicule mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public List<Vehicule> afficherVehiculesDisponibles(String lieu, Date date_debut, Date date_fin)  {
        List<Vehicule> vehiculesDisponibles = new ArrayList<>();
        try {
        String query = "SELECT * FROM vehicule WHERE disponibilite = 'true' AND lieu = ? AND id_vehicule NOT IN " +
                "(SELECT id_vehicule FROM location WHERE (date_debut <= ? AND date_fin >= ?))";
         PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, lieu);
        st.setDate(2, date_fin);
        st.setDate(3, date_debut);
        ResultSet RS = st.executeQuery();
        while (RS.next()) {
            Vehicule p = new Vehicule();
                p.setId_vehicule(RS.getInt("id_vehicule"));
                p.setNom_v(RS.getString("nom_v"));
                p.setId(RS.getInt("id"));
                p.setId_promotion(RS.getInt("taux"));
                p.setPhoto(RS.getString("photo"));
                p.setVille(RS.getString("ville"));
                p.setPrix(RS.getFloat("prix"));
                p.setDisponibilite(RS.getBoolean("disponibilite"));
                p.setDescription(RS.getString("description"));
                p.setType(RS.getString("type"));
              vehiculesDisponibles.add(p);
              return vehiculesDisponibles ;
        }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return null;
    }

    
}
