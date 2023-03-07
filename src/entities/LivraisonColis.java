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

public class LivraisonColis {
     private int id_livraison;
    private String adresse_expedition;
    private String adresse_destinataire;
    private float prix;
    private String etat ;
    private int id;
    private int nb_items;
    private String description;
    private float poids;
    private int id_livreur;

    public int getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }
   

    public LivraisonColis(Livraison l, Colis c) {
        this.id_livraison=l.getId_livraison();
        this.adresse_destinataire=l.getAdresse_destinataire();
        this.adresse_expedition=l.getAdresse_expedition();
        this.prix=l.getPrix();
        this.etat=l.getEtat();
        this.id=c.getId();
        this.nb_items=c.getNb_items();
        this.description=c.getDescription();
        this.poids=c.getPoids();
        
        
        
    }

    public LivraisonColis() {
    }

    public LivraisonColis(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_items() {
        return nb_items;
    }

    public void setNb_items(int nb_items) {
        this.nb_items = nb_items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "LivraisonColis{" + "id_livraison=" + id_livraison + ", adresse_expedition=" + adresse_expedition + ", adresse_destinataire=" + adresse_destinataire + ", prix=" + prix + ", etat=" + etat + ", id=" + id + ", nb_items=" + nb_items + ", description=" + description + ", poids=" + poids + ", id_livreur=" + id_livreur + '}';
    }
    
    
    
    
}
