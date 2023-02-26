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
public class Promotion {
private int id_promotion;
private int id_vehicule;
private String libelle ;
private float taux ;

    public Promotion() {
    }

    public Promotion(int id_vehicule, String libelle, float taux) {
        this.id_vehicule = id_vehicule;
        this.libelle = libelle;
        this.taux = taux;
    }
    

    public Promotion(int id_promotion, int id_vehicule, String libelle, float taux) {
        this.id_promotion = id_promotion;
        this.id_vehicule = id_vehicule;

        this.libelle = libelle;
        this.taux = taux;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

   

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id_promotion=" + id_promotion + ", id_vehicule=" + id_vehicule + ", libelle=" + libelle + ", taux=" + taux + '}';
    }

  

     
}
