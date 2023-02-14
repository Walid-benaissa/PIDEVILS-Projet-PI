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
                p.setCin(RS.getString("cin"));
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

    @Override
    public void ajouter(Utilisateur p) {
        try {
            String req = "INSERT INTO  `utilisateur`(`cin`, `nom`, `prenom`, `mail`,`mdp`, `num_tel`, `role`,`evaluation`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getCin());
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
            String req = "DELETE FROM `utilisateur` WHERE cin = " + p.getCin();
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

            String req = "UPDATE `utilisateur` SET nom=?, `prenom` = ?, `mail` = ?, `mdp` = ?, `num_tel` = ?, `role` = ?, `evaluation` = ? WHERE `utilisateur`.`cin` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getMail());
            ps.setString(4, p.getMdp());
            ps.setString(5, p.getNum_tel());
            ps.setString(6, p.getRole());
            ps.setFloat(7, p.getEvaluation());
            ps.setString(8, p.getCin());

            ps.executeUpdate();
            System.out.println("Utilisateur mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
