/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Colis;
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
 * @author user
 */
public class ColisService implements IService<Colis> {

    Connection conn;
    Statement stm;

    public ColisService() {
        conn = MyDB.getInstance().getConnexion();
    }

    @Override
    public List<Colis> afficheListe() {
        List<Colis> list = new ArrayList<>();
        try {
            String req = "Select * from  `colis`";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Colis c = new Colis();
                c.setId(RS.getInt("id"));
                c.setDescription(RS.getString("Description"));
                c.setNb_items(RS.getInt("Nombre items"));
                c.setPoids(RS.getFloat("Poids"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public void ajouter(Colis c) {
        try {
            String req = "INSERT INTO `colis`(`nb_items`, `description`, `poids`) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getNb_items());
            ps.setFloat(4, c.getPoids());
            ps.executeUpdate();

            System.out.println("colis ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Colis c) {
        try {
            String req = "DELETE FROM `colis` WHERE id = " + c.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Colis supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Colis c) {
        try {

            String req = "UPDATE `colis` SET `nb_items` = ?, `description`= ?, `poids`= ?, WHERE `colis`.`id` = ?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, c.getNb_items());
            ps.setString(2, c.getDescription());
            ps.setFloat(3, c.getPoids());
            ps.executeUpdate();
            System.out.println("Colis modifié avec succès");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
