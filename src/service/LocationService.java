/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entities.Location;
import java.sql.Connection;
import java.sql.Date;
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
    public class LocationService implements IService<Location>{
          Statement stm;
          Connection conn;

    public LocationService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Location> afficheListe() {
        List<Location> list = new ArrayList<>();
        try {
            String req = "Select * from  `location`";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Location p = new Location();
                p.setId_contrat(RS.getInt("id_contrat"));
                p.setCin(RS.getString("cin"));
                p.setId_vehicule(RS.getString("id_vehicule"));
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
    public void ajouter(Location p) {
        try {
            String req = "INSERT INTO  `location`(`cin`, `id_vehicule`,`date_debut`, `date_fin`) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
       
            ps.setString(1, p.getCin());
            ps.setString(2, p.getId_vehicule());
           // ps.setDate(3, new java.sql.Date(p.getDate_debut().getTime()));
            //ps.setDate(4, new java.sql.Date(p.getDate_fin().getTime()));
            ps.setDate(3, (Date)p.getDate_debut());
            ps.setDate(4, (Date)p.getDate_fin());
            ps.executeUpdate();
            
            System.out.println("Location inséré");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Location p) {
        try {
            String req = "DELETE FROM `location` WHERE id_contrat = " + p.getId_contrat  ();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("location supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Location p) {
        try {

            String req = "UPDATE `location` SET  cin=?, `id_vehicule` = ?,`date_debut` = ?, `date_fin` = ? WHERE `location`.`id_contrat` = ? ";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getCin());
            ps.setString(2, p.getId_vehicule());
            ps.setDate(3,new java.sql.Date(p.getDate_debut().getTime()));
            ps.setDate(4, new java.sql.Date(p.getDate_fin().getTime()));
            ps.setInt(5, p.getId_contrat());
          

            ps.executeUpdate();
            System.out.println("Location mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

    

