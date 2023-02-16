/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author azizi
 */
public class Location {
    private String ville;
    private float prix_location;
    private boolean disponibilité ; 

    public Location() {
    }

    public Location(String ville, float prix_location, boolean disponibilité) {
        this.ville = ville;
        this.prix_location = prix_location;
        this.disponibilité = disponibilité;
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

    @Override
    public String toString() {
        return "Location{" + "ville=" + ville + ", prix_location=" + prix_location + ", disponibilit\u00e9=" + disponibilité + '}';
    }
    
    


}