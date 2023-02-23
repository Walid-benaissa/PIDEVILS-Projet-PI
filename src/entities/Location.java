/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author azizi
 */
public class Location { 
   
    private int id_contrat;
    private String cin;
    private String id_vehicule; 
    private Date date_debut;
    private Date date_fin;
 
    
    
    public Location() {
    }

    public Location(int id_contrat, String cin, String id_vehicule, Date date_debut, Date date_fin) {
        this.id_contrat = id_contrat;
        this.cin = cin;
        this.id_vehicule = id_vehicule;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Location(String cin, String id_vehicule, Date date_debut, Date date_fin) {
        this.cin = cin;
        this.id_vehicule = id_vehicule;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(int id_contrat) {
        this.id_contrat = id_contrat;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(String id_vehicule) {
        this.id_vehicule = id_vehicule;
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
    

    @Override
    public String toString() {
        return "Location{" + "id_contrat=" + id_contrat + ", cin=" + cin + ", id_vehicule=" + id_vehicule + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }

   
  
}