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
    private int id_livraison;
    private String adresse_expedition;
    private String adresse_destinataire;
    private float prix;
    private String etat ;
    private int id_colis;
    

    public Livraison() {
    }

    public Livraison(int id_livraison, String adresse_expedition, String adresse_destinataire, float prix, String etat, int id_colis) {
        this.id_livraison = id_livraison;
        this.adresse_expedition = adresse_expedition;
        this.adresse_destinataire = adresse_destinataire;
        this.prix = prix;
        this.etat = etat;
        this.id_colis = id_colis;
    }

    public Livraison(int id_livraison, String adresse_expedition, String adresse_destinataire, float prix, String etat) {
        this.id_livraison = id_livraison;
        this.adresse_expedition = adresse_expedition;
        this.adresse_destinataire = adresse_destinataire;
        this.prix = prix;
        this.etat = etat;
    }

    public Livraison(String adresse_expedition, String adresse_destinataire, float prix, String etat) {
        this.adresse_expedition = adresse_expedition;
        this.adresse_destinataire = adresse_destinataire;
        this.prix = prix;
        this.etat = etat;
    }

    public Livraison(String adresse_expedition, String adresse_destinataire, float prix, String etat, int id_colis) {
        this.adresse_expedition = adresse_expedition;
        this.adresse_destinataire = adresse_destinataire;
        this.prix = prix;
        this.etat = etat;
        this.id_colis = id_colis;
    }

    public Livraison(String adresse_expedition, String adresse_destinataire, float prix) {
        this.adresse_expedition = adresse_expedition;
        this.adresse_destinataire = adresse_destinataire;
        this.prix = prix;
    }

 

    
    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_colis() {
        return id_colis;
    }

    public void setId_colis(int id_colis) {
        this.id_colis = id_colis;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", adresse_expedition=" + adresse_expedition + ", adresse_destinataire=" + adresse_destinataire + ", prix=" + prix + ", etat=" + etat + ", id_colis=" + id_colis + '}';
    }
    

  
   
  

    
   

}
