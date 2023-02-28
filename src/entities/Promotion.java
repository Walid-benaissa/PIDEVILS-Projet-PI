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

private float taux ;

    public Promotion() {
    }

    public Promotion(int id_promotion, float taux) {
        this.id_promotion = id_promotion;
        this.taux = taux;
    }

    public Promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public Promotion(float taux) {
        this.taux = taux;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id_promotion=" + id_promotion + ", taux=" + taux + '}';
    }

   

     
}
