/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author azizi
 */
public class Location { 
   
    private int id_contrat;
    private Date date_debut;
    private Date date_fin;
    private int id;
    private String id_vehicule; 
    
    
    public Location() {
    }

    public Location(int id_contrat, Date date_debut, Date date_fin, int id, String id_vehicule) {
        this.id_contrat = id_contrat;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id = id;
        this.id_vehicule = id_vehicule;
    }

    public int getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(int id_contrat) {
        this.id_contrat = id_contrat;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(String id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    @Override
    public String toString() {
        return "Location{" + "id_contrat=" + id_contrat + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", id=" + id + ", id_vehicule=" + id_vehicule + '}';
    }

   
  
}