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

    @Override
    public String toString() {
        return "Location{" + "id_contrat=" + id_contrat + ", cin=" + cin + ", id_vehicule=" + id_vehicule + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }

   
  
}