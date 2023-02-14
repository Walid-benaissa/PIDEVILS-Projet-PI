/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author USER
 */
public class Vehicule {

    private String immatriculation;
    private String modele;
    private String marque;
    private String etat;
    private String photo;

    public Vehicule() {
    }

    public Vehicule(String immatriculation, String modele, String marque, String etat, String photo) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.marque = marque;
        this.etat = etat;
        this.photo = photo;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "vehicule{" + "immatriculation=" + immatriculation + ", modele=" + modele + ", marque=" + marque + ", etat=" + etat + ", photo=" + photo + '}';
    }

    
    
}
