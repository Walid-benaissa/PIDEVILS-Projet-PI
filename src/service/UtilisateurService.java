/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String req = "Select * from  `utilisateur` order by id";
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
                p.setBolque(RS.getBoolean("bloque"));
                list.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public Map<String, Integer> statistiquesUtilisateurs() {
        Map<String, Integer> res = new HashMap<String, Integer>();
        try {
            String req = "Select role,count(*) from  `utilisateur` where `role`!='Admin' group by role";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                res.put(RS.getString("role"), RS.getInt("count(*)"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
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
            p.setBolque(RS.getBoolean("bloque"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public Utilisateur authentification(String mail, String mdp) {
        Utilisateur p = new Utilisateur();
        try {
            String req = "Select * from  `utilisateur` where mail ='" + mail + "' AND mdp ='" + mdp + "'";
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
            p.setBolque(RS.getBoolean("bloque"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public Utilisateur rechUtilisateurByMail(String mail) {
        Utilisateur p = new Utilisateur();
        try {
            String req = "Select * from  `utilisateur` where mail ='" + mail + "'";
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

    public void evaluer(int id_c, float evaluation) {
        try {
            String req = "Select evaluation from  `utilisateur` where id=" + id_c;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            RS.next();
            float eval = RS.getInt("evaluation");
            eval = (eval + evaluation) / (float) 2;
            req = "Update utilisateur set evaluation=? where id=" + id_c;
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setFloat(1, eval);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    @Override
    public void ajouter(Utilisateur p) {
        try {
            String req = "INSERT INTO  `utilisateur`(`id`, `nom`, `prenom`, `mail`,`mdp`, `num_tel`, `role`,`evaluation`) VALUES (?,?,?,?,?,?,?,?)";
            if (estChaineValide(p.getNom()) && estChaineValide(p.getPrenom())) {

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
            } else {
                System.out.println(estChaineValide(p.getNom()) + " et " + estChaineValide(p.getPrenom()));

            }

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

            String req = "UPDATE `utilisateur` SET nom=?, `prenom` = ?, `mail` = ?, `mdp` = ?, `num_tel` = ?, `role` = ?, `evaluation` = ? , `bloque` = ? WHERE `utilisateur`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getMail());
            ps.setString(4, p.getMdp());
            ps.setString(5, p.getNum_tel());
            ps.setString(6, p.getRole());
            ps.setFloat(7, p.getEvaluation());
            ps.setBoolean(8, p.isBolque());
            ps.setInt(9, p.getId());
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
            System.out.println(p);
            ps.executeUpdate();
            System.out.println("Utilisateur mis a jour");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String HashagePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Utilisateur> rechercherNom(String Nom) {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "Select * from  `utilisateur` where nom like '%" + Nom + "%'";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Utilisateur p = new Utilisateur();
                p.setId(RS.getInt("id"));
                p.setNom(RS.getString("nom"));
                p.setPrenom(RS.getString("prenom"));
                p.setMail(RS.getString("mail"));
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

    public List<Utilisateur> rechercherPrenom(String Prenom) {
        List<Utilisateur> list = new ArrayList<>();
        try {
            String req = "Select * from  `utilisateur` where prenom like '%" + Prenom + "%'";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Utilisateur p = new Utilisateur();
                p.setId(RS.getInt("id"));
                p.setNom(RS.getString("nom"));
                p.setPrenom(RS.getString("prenom"));
                p.setMail(RS.getString("mail"));
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

    public String sendMail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modifiermdp(String mail, String mdp) {
        try {

            String req = "UPDATE `utilisateur` SET  `mdp` = ? WHERE `utilisateur`.`mail` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, mdp);
            ps.setString(2, mail);
            ps.executeUpdate();
            System.out.println("Mot de passe changé");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public boolean verifMail(String mail) {
        Utilisateur p = new Utilisateur();
        int nbr=0;
        try {
            String req = "Select count(*) from  `utilisateur` where mail ='" + mail + "'";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            RS.next();
           nbr=RS.getInt("count(*)");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nbr==0;
    }

}
