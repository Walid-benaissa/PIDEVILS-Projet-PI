/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Conducteur;
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
public class ConducteurService implements IService<Conducteur> {

    Statement stm;
    Connection conn;

    public ConducteurService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Conducteur> afficheListe() {
        List<Conducteur> list = new ArrayList<>();
        try {
            String req = "Select * from  `conducteur` c, `utlisateur` u where c.cin=u.cin";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Conducteur p = new Conducteur();
                p.setCin(RS.getString("cin"));
                p.setNom(RS.getString("nom"));
                p.setPrenom(RS.getString("prenom"));
                p.setMail(RS.getString("mail"));
                p.setMdp(RS.getString("mdp"));
                p.setNum_tel(RS.getString("num_tel"));
                p.setRole(RS.getString("role"));
                p.setEvaluation(RS.getFloat("evaluation"));
                p.setEvaluation(RS.getFloat("permis"));
                p.setEvaluation(RS.getFloat("b3"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void ajouter(Conducteur p) {
        try {
            String req = "INSERT INTO  `Conducteur`(`cin`,`permis`, `b3`) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getCin());
            FileInputStream fin1 = new FileInputStream(p.getPermis());
            ps.setBinaryStream(2, fin1, fin1.available());
            FileInputStream fin2 = new FileInputStream(p.getB3());
            ps.setBinaryStream(3, fin2, fin2.available());
            ps.executeUpdate();

            System.out.println("Conducteur inséré");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(Conducteur p) {
        try {
            String req = "DELETE FROM `conducteur` WHERE cin = " + p.getCin();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Conducteur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Conducteur p) {
        try {

            String req = "UPDATE `conducteur` SET permis=?, `b3` = ?  WHERE `cin` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getPermis());
            FileInputStream fin1 = new FileInputStream(p.getPermis());
            ps.setBinaryStream(2, fin1, fin1.available());
            FileInputStream fin2 = new FileInputStream(p.getB3());
            ps.setBinaryStream(3, fin2, fin2.available());

            ps.executeUpdate();
            System.out.println("Conducteur mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConducteurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
