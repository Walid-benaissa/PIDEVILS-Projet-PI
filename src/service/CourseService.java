/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
import entities.Course ;

/**
 *
 * @author bough
 */
public class CourseService implements ICourse<Course>{
     Connection connexion;
    Statement stm;

    /**
     *
     */
    public CourseService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    /**
     *
     * @param c
     * @throws SQLException
     */
    @Override
    public void ajouterC(Course c) throws SQLException {
        String req = "INSERT INTO `course` (`id_course`,`point_depart`, `point_destination`, `distance`, `prix`, `statut_course`) VALUES (  '" + c.getId_course()+ "','" + c.getPoint_depart()+ "', '" + c.getPoint_destination()+ "', '" + c.getDistance()+ "', '" + c.getPrix() + "', '" + c.getStatut_course()+ "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }

     @Override
    public void ajouterCC(Course c) throws SQLException {
        String req = "INSERT INTO `course` (`id_course`, `point_depart`, `point_destination`, `distance`, `prix`, `statut_course`) "
                + "VALUES (?,?, ?, ?, ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, c.getId_course());
        ps.setString(2, c.getPoint_depart());
        ps.setString(3, c.getPoint_destination());
        ps.setFloat(4, c.getDistance());
        ps.setFloat(5, c.getPrix());
        ps.setString(6, c.getStatut_course());
        ps.executeUpdate();
    }

    @Override
    public List<Course> afficherCourse() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String req = "select * from course";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Course c = new Course(rst.getInt("id_course"),
                    rst.getString("point_depart"),
                    rst.getString("point_destination"),
                    rst.getFloat("distance"),
                    rst.getFloat("prix"),
                    rst.getString("statut_course"));
            courses.add(c);
        }
        return courses;
    }

    @Override
    public void supprimerC(Course c) throws SQLException {
       String req = "DELETE FROM `course` WHERE id_course=?";
       PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, c.getId_course());
        ps.executeUpdate();
    }

    @Override
    public void modifierC(Course c) throws SQLException {
        String req = "UPDATE `course` SET id_course=? , point_depart=?, point_destination=?, distance=?, prix=?, statut_course=? WHERE id_course=?";
       PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, c.getId_course());
        ps.setString(2, c.getPoint_depart());
        ps.setString(3, c.getPoint_destination());
        ps.setFloat(4, c.getDistance());
        ps.setFloat(5, c.getPrix());
        ps.setString(6, c.getStatut_course());
        ps.executeUpdate();
    }
    
}
