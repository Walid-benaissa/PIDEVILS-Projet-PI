/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bough
 */
public class Course {
private int id_course ;
private String point_depart ;
private String point_destination ;
private float distance ;
private float prix ;
private String statut_course ;

    public Course(String point_depart, String point_destination, float distance, float prix, String statut_course) {
        this.point_depart = point_depart;
        this.point_destination = point_destination;
        this.distance = distance;
        this.prix = prix;
        this.statut_course = statut_course;
    }

    public Course(int id_course, String point_depart, String point_destination, float distance, float prix, String statut_course) {
        this.id_course = id_course;
        this.point_depart = point_depart;
        this.point_destination = point_destination;
        this.distance = distance;
        this.prix = prix;
        this.statut_course = statut_course;
    }


    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String getPoint_depart() {
        return point_depart;
    }

    public void setPoint_depart(String point_depart) {
        this.point_depart = point_depart;
    }

    public String getPoint_destination() {
        return point_destination;
    }

    public void setPoint_destination(String point_destination) {
        this.point_destination = point_destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getStatut_course() {
        return statut_course;
    }

    public void setStatut_course(String statut_course) {
        this.statut_course = statut_course;
    }

    @Override
    public String toString() {
        return "Course{" + "id_course=" + id_course + ", point_depart=" + point_depart + ", point_destination=" + point_destination + ", distance=" + distance + ", prix=" + prix + ", statut_course=" + statut_course + '}';
    }
     
    
    
}
