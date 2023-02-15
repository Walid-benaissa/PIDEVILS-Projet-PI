/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Reclamation;
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
 * @author walid
 */
public class ReclamationService implements IService<Reclamation> {

    Statement stm;
    Connection conn;

    public ReclamationService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Reclamation> afficheListe()   {
        List<Reclamation> list = new ArrayList<>();
        try {
            String req = "Select * from  `reclamation`";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Reclamation p = new Reclamation();
                p.setId(RS.getInt("id"));
                p.setMessage(RS.getString("message"));
                p.setEtat(RS.getString("etat"));
                p.setCinAdmin(RS.getString("cinAdmin"));
                p.setCinUser(RS.getString("cinUser"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void ajouter(Reclamation p)   {
        try {
            String req = "INSERT INTO  `reclamation`(`id`, `message`, `etat`,`cinAdmin`,`cinUser`) VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getMessage());
            ps.setString(3, p.getEtat());
            ps.setString(4, p.getCinAdmin());
            ps.setString(5, p.getCinUser());
            ps.executeUpdate();

            System.out.println("Reclamation inséré");
        } catch (SQLException ex) {
            System.out.println("Reclamation non inséré");
        }
    }

    @Override
    public void supprimer(Reclamation p)   {
        try {
            String req = "DELETE FROM `reclamation` WHERE id = " + p.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reclamation p)   {
        try {
            
            String req = "UPDATE `reclamation` SET `message` = ?, `etat` = ?, WHERE `reclamation`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getMessage());
            ps.setString(2, p.getEtat());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
            System.out.println("reclamation mise a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
