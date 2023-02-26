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
    private int id_vehicule;
    private String nom_v;
    private int id;
    private String photo;
    private String ville;
    private float prix;
    private int id_promotion;
    private boolean disponibilite;
    private String description;
    private String type;

    public Vehicule() {
    }

    public Vehicule(int id_vehicule,String nom_v, int id, String photo, String ville, float prix, int id_promotion, boolean disponibilite, String description, String type) {
        this.id_vehicule = id_vehicule;
        this.nom_v=nom_v;
        this.id = id;
        this.photo = photo;
        this.ville = ville;
        this.prix = prix;
        this.id_promotion = id_promotion;
        this.disponibilite = disponibilite;
        this.description = description;
        this.type = type;
    }

    public Vehicule(int id_vehicule,String nom_v, int id, String photo, String ville, float prix, int id_promotion, String description, String type) {
        this.id_vehicule = id_vehicule;
        this.nom_v=nom_v;
        this.id = id;
        this.photo = photo;
        this.ville = ville;
        this.prix = prix;
        this.id_promotion = id_promotion;
        this.description = description;
        this.type = type;
    }
    

    public Vehicule(int id_vehicule,String nom_v, String ville, float prix, String description, String type) {
        this.id_vehicule = id_vehicule;
        this.nom_v=nom_v;
        this.ville = ville;
        this.prix = prix;
        this.description = description;
        this.type = type;
    }

    public Vehicule(int id_vehicule,String nom_v, String photo, String ville, float prix, String description, String type) {
        this.id_vehicule = id_vehicule;
        this.nom_v=nom_v;
        this.photo = photo;
        this.ville = ville;
        this.prix = prix;
        this.description = description;
        this.type = type;
    }

    public Vehicule(String nom_v, String photo, String ville, float prix, String description, String type) {
        this.nom_v = nom_v;
        this.photo = photo;
        this.ville = ville;
        this.prix = prix;
        this.description = description;
        this.type = type;
    }

    public Vehicule(int id_vehicule, String nom_v, String photo, String ville, float prix, int id_promotion, String description, String type) {
        this.id_vehicule = id_vehicule;
        this.nom_v = nom_v;
        this.photo = photo;
        this.ville = ville;
        this.prix = prix;
        this.id_promotion = id_promotion;
        this.description = description;
        this.type = type;
    }
    

    public Vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public Vehicule(int id_vehicule, String nom_v) {
        this.id_vehicule = id_vehicule;
        this.nom_v = nom_v;
    }

    public String getNom_v() {
        return nom_v;
    }

    public void setNom_v(String nom_v) {
        this.nom_v = nom_v;
    }
    

 
    

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Vehicule{" + "id_vehicule=" + id_vehicule + ", nom_v=" + nom_v + ", id=" + id + ", photo=" + photo + ", ville=" + ville + ", prix=" + prix + ", id_promotion=" + id_promotion + ", disponibilite=" + disponibilite + ", description=" + description + ", type=" + type + '}';
    }

    

    
}
