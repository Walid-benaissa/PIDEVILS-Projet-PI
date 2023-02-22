/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Utilisateur;
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
 * @author abir
 */
public class UtilisateurService implements IService<Utilisateur> {

    Statement stm;
    Connection conn;

    public UtilisateurService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Utilisateur> afficheListe() {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "Select * from  `utilisateur`";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Utilisateur p = new Utilisateur();
                p.setId(RS.getInt("id"));
                p.setNom(RS.getString("nom"));
                p.setPrenom(RS.getString("prenom"));
                p.setMail(RS.getString("mail"));
                p.setMdp(RS.getString("mdp"));
                p.setNum_tel(RS.getString("num_tel"));
                p.setRole(RS.getString("role"));
                p.setEvaluation(RS.getFloat("evaluation"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public Utilisateur afficheUser(int id) {
        Utilisateur p = new Utilisateur();
        try {
            String req = "Select * from  `utilisateur` where id=" + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            RS.next();
            p.setId(RS.getInt("id"));
            p.setNom(RS.getString("nom"));
            p.setPrenom(RS.getString("prenom"));
            p.setMail(RS.getString("mail"));
            p.setMdp(RS.getString("mdp"));
            p.setNum_tel(RS.getString("num_tel"));
            p.setRole(RS.getString("role"));
            p.setEvaluation(RS.getFloat("evaluation"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public boolean authentification(String mail, String mdp) {
        int count = 0;
        try {
            String req = "Select mail from  `utilisateur` where mail ='" + mail + "' AND mdp ='" + mdp + "'";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                count++;
            }
            System.out.println(count);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count == 1;
    }

    @Override
    public void ajouter(Utilisateur p) {
        try {
            String req = "INSERT INTO  `utilisateur`(`id`, `nom`, `prenom`, `mail`,`mdp`, `num_tel`, `role`,`evaluation`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNom());
            ps.setString(3, p.getPrenom());
            ps.setString(4, p.getMail());
            ps.setString(5, p.getMdp());
            ps.setString(6, p.getNum_tel());
            ps.setString(7, p.getRole());
            ps.setFloat(8, p.getEvaluation());
            ps.executeUpdate();

            System.out.println("Utilisateur inséré");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Utilisateur p) {
        try {
            String req = "DELETE FROM `utilisateur` WHERE id = " + p.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Utilisateur p) {
        try {

            String req = "UPDATE `utilisateur` SET nom=?, `prenom` = ?, `mail` = ?, `mdp` = ?, `num_tel` = ?, `role` = ?, `evaluation` = ? WHERE `utilisateur`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getMail());
            ps.setString(4, p.getMdp());
            ps.setString(5, p.getNum_tel());
            ps.setString(6, p.getRole());
            ps.setFloat(7, p.getEvaluation());
            ps.setInt(8, p.getId());

            ps.executeUpdate();
            System.out.println("Utilisateur mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void modifierWithmdp(Utilisateur p) {
        try {

            String req = "UPDATE `utilisateur` SET nom=?, `prenom` = ?, `mail` = ?, `mdp` = ?, `num_tel` = ? WHERE `utilisateur`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getMail());
            ps.setString(4, p.getMdp());
            ps.setString(5, p.getNum_tel());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
            System.out.println("Utilisateur mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifierSansmdp(Utilisateur p) {
        try {

            String req = "UPDATE `utilisateur` SET nom=?, `prenom` = ?, `mail` = ?, `num_tel` = ? WHERE `utilisateur`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getMail());
            ps.setString(4, p.getNum_tel());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
            System.out.println("Utilisateur mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

}
