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
public class Vehicule {
    private String id_vehicule;
    private String cin;
    private String photo;
    private String ville;
    private float prix;
    private int id_promotion;
    private boolean disponibilite;
    private String description;
    private String type;

    public Vehicule() {
    }

    public Vehicule(String id_vehicule, String cin, String photo, String ville, float prix, int id_promotion, boolean disponibilite, String description, String type) {
        this.id_vehicule = id_vehicule;
        this.cin = cin;
        this.photo = photo;
        this.ville = ville;
        this.prix = prix;
        this.id_promotion = id_promotion;
        this.disponibilite = disponibilite;
        this.description = description;
        this.type = type;
    }

    public Vehicule(String id_vehicule, String ville, float prix, String description, String type) {
        this.id_vehicule = id_vehicule;
        this.ville = ville;
        this.prix = prix;
        this.description = description;
        this.type = type;
    }

 
    

    public String getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(String id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String id) {
        this.cin = cin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "id_vehicule=" + id_vehicule + ", cin=" + cin + ", photo=" + photo + ", ville=" + ville + ", prix=" + prix + ", id_promotion=" + id_promotion + ", disponibilite=" + disponibilite + ", description=" + description + ", type=" + type + '}';
    }

    
}
