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
public class Livraison {
    private int id;
    private String adresse_expedition;
    private String adresse_destinataire;
    

    public Livraison() {
    }

    public Livraison(int id, String adresse_expedition, String adresse_destinataire) {
        this.id = id;
        this.adresse_expedition = adresse_expedition;
        this.adresse_destinataire = adresse_destinataire;
       
    }

    public Livraison(String adresse_expedition, String adresse_destinataire) {
        this.adresse_expedition = adresse_expedition;
        this.adresse_destinataire = adresse_destinataire;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse_expedition() {
        return adresse_expedition;
    }

    public void setAdresse_expedition(String adresse_expedition) {
        this.adresse_expedition = adresse_expedition;
    }

    public String getAdresse_destinataire() {
        return adresse_destinataire;
    }

    public void setAdresse_destinataire(String adresse_destinataire) {
        this.adresse_destinataire = adresse_destinataire;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", adresse_expedition=" + adresse_expedition + ", adresse_destinataire=" + adresse_destinataire + '}';
    }

}
