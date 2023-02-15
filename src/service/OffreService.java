/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Offre;
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
 * @author bough
 */
public class OffreService implements IOffre<Offre>{
    
       Connection connexion;
    Statement stm;

    /**
     *
     */
    public OffreService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouterO(Offre o) throws SQLException {
        String req = "INSERT INTO `offre_course` (`id_offre`,`matricule_vehicule`, `cin_conducteur`, `nb_passagers`, `options_offre`, `statut_offre`) VALUES (  '" + o.getId_offre()+ "','" + o.getMatricule_vehicule()+ "', '" + o.getCin_conducteur()+ "', '" + o.getNb_passagers()+ "', '" + o.getOptions_offre()+ "', '" + o.getStatut_offre()+ "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void ajouterOO(Offre o) throws SQLException {
         String req = "INSERT INTO `offre_course` (`id_offre`,`matricule_vehicule`, `cin_conducteur`, `nb_passagers`, `options_offre`, `statut_offre`) "
                + "VALUES (?,?, ?, ?, ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, o.getId_offre());
        ps.setInt(2, o.getMatricule_vehicule());
        ps.setInt(3, o.getCin_conducteur());
        ps.setInt(4, o.getNb_passagers());
        ps.setString(5, o.getOptions_offre());
        ps.setString(6, o.getStatut_offre());
        ps.executeUpdate();
    }

    @Override
    public List<Offre> afficherOffre() throws SQLException {
       List<Offre> offres = new ArrayList<>();
        String req = "select * from offre_course";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Offre o = new Offre(rst.getInt("id_offre"),//or rst.getInt(1)
                    rst.getInt("matricule_vehicule"),
                    rst.getInt("cin_conducteur"),
                    rst.getInt("nb_passagers"),
                    rst.getString("options_offre"),
                    rst.getString("statut_offre"));
            offres.add(o);
        }
        return offres;
    }

    @Override
    public void supprimerO(Offre o) throws SQLException {
         String req = "DELETE FROM `offre_course` WHERE id_offre=?";
       PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, o.getId_offre());
        ps.executeUpdate();
    }

    @Override
    public void modifierO(Offre o) throws SQLException {
         String req = "UPDATE `offre_course` SET id_offre=? , matricule_vehicule=?, cin_conducteur=?, nb_passagers=?, options_offres=?, statut_offre=? WHERE id_offre=?";
       PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, o.getId_offre());
        ps.setInt(2, o.getMatricule_vehicule());
        ps.setInt(3, o.getCin_conducteur());
        ps.setInt(4, o.getNb_passagers());
        ps.setString(5, o.getOptions_offre());
        ps.setString(6, o.getStatut_offre());
        ps.executeUpdate();
    
    }
    
}
