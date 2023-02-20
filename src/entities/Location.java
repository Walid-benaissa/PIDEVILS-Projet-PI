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
    private String ville;
    private float prix_location;
    //private int id_contrat ;
    private Date date_debut;
    private Date date_fin;
    
    
    public Location() {
    }

    public Location(String ville, float prix_location, boolean disponibilité, int id_contrat, Date date_debut, Date date_fin) {
        this.ville = ville;
        this.prix_location = prix_location;
        this.disponibilité = disponibilité;
        this.id_contrat = id_contrat;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public float getPrix_location() {
        return prix_location;
    }

    public void setPrix_location(float prix_location) {
        this.prix_location = prix_location;
    }

    public boolean isDisponibilité() {
        return disponibilité;
    }

    public void setDisponibilité(boolean disponibilité) {
        this.disponibilité = disponibilité;
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

    @Override
    public String toString() {
        return "Location{" + "id_contrat=" + id_contrat + ", ville=" + ville + ", prix_location=" + prix_location + ", disponibilit\u00e9=" + disponibilité + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }

    


}