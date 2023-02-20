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
private String id;
private Date debut_promotion;
private Date fin_promotion ;
private String libelle ;
private float taux ;

    public Promotion() {
    }

    public Promotion(int id_promotion, String id, Date debut_promotion, Date fin_promotion, String libelle, float taux) {
        this.id_promotion = id_promotion;
        this.id = id;
        this.debut_promotion = debut_promotion;
        this.fin_promotion = fin_promotion;
        this.libelle = libelle;
        this.taux = taux;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDebut_promotion() {
        return debut_promotion;
    }

    public void setDebut_promotion(Date debut_promotion) {
        this.debut_promotion = debut_promotion;
    }

    public Date getFin_promotion() {
        return fin_promotion;
    }

    public void setFin_promotion(Date fin_promotion) {
        this.fin_promotion = fin_promotion;
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
        return "Promotion{" + "id_promotion=" + id_promotion + ", id=" + id + ", debut_promotion=" + debut_promotion + ", fin_promotion=" + fin_promotion + ", libelle=" + libelle + ", taux=" + taux + '}';
    }

    
    
}
