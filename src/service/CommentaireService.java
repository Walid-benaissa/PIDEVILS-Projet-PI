/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Commentaire;
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
 * @author walid
 */
public class CommentaireService implements IService<Commentaire> {

    Statement stm;
    Connection conn;

    public CommentaireService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Commentaire> afficheListe() {
        List<Commentaire> list = new ArrayList<>();
        try {
            String req = "Select * from  `commentaire`";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Commentaire p = new Commentaire();
                p.setCin1(RS.getString("cin1"));
                p.setCin2(RS.getString("cin2"));
                p.setMessage(RS.getString("message"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void ajouter(Commentaire p) {
        try {
            String req = "INSERT INTO  `commentaire`(`cin1`, `cin2`, `message`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getCin1());
            ps.setString(2, p.getCin2());
            ps.setString(3, p.getMessage());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(Commentaire p) {
        try {
            String req = "DELETE FROM `commentaire` WHERE cin1 = ? AND cin2= ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getCin1());
            ps.setString(2, p.getCin2());
            ps.executeUpdate(req);
            System.out.println("Commentaire supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Commentaire p) {
        try {
            String req = "UPDATE `commentaire` SET message=?, WHERE cin1 = ? AND cin2= ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getMessage());
            ps.setString(2, p.getCin1());
            ps.setString(3, p.getCin2());
            ps.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
