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
public class LivraisonLivreur {

    private int id_livraison;
    private String adresse_expedition;
    private String adresse_destinataire;
    private float prix;
    private String etat;
    private int id;
    private String nom;
    private String prenom;
    private String num_tel;

    public LivraisonLivreur(Livraison l, Utilisateur u) {
        this.id_livraison = l.getId_livraison();
        this.adresse_destinataire = l.getAdresse_destinataire();
        this.adresse_expedition = l.getAdresse_expedition();
        this.prix = l.getPrix();
        this.etat = l.getEtat();
        this.id = u.getId();
        this.nom = u.getNom();
        this.prenom = u.getPrenom();
        this.num_tel = u.getNum_tel();
    }

    public LivraisonLivreur() {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }
    

}
