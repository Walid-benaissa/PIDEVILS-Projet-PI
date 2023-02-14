/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author user
 */
public class Offre_livraison {
    private int id;
    private float prix_livraison;

    public Offre_livraison() {
    }

    public Offre_livraison(int id, float prix_livraison) {
        this.id = id;
        this.prix_livraison = prix_livraison;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix_livraison() {
        return prix_livraison;
    }

    public void setPrix_livraison(float prix_livraison) {
        this.prix_livraison = prix_livraison;
    }

    @Override
    public String toString() {
        return "Offre_livraison{" + "id=" + id + ", prix_livraison=" + prix_livraison + '}';
    }
    
    
   
    
}
