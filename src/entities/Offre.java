/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bough
 */
public class Offre {
private int id_offre ;
private int matricule_vehicule ;
private int cin_conducteur ;
private int nb_passagers ;
private String options_offre ;
private String statut_offre ;

    public Offre(int matricule_vehicule, int cin_conducteur, int nb_passagers, String options_offre, String statut_offre) {
        this.matricule_vehicule = matricule_vehicule;
        this.cin_conducteur = cin_conducteur;
        this.nb_passagers = nb_passagers;
        this.options_offre = options_offre;
        this.statut_offre = statut_offre;
    }

    public Offre(int id_offre, int matricule_vehicule, int cin_conducteur, int nb_passagers, String options_offre, String statut_offre) {
        this.id_offre = id_offre;
        this.matricule_vehicule = matricule_vehicule;
        this.cin_conducteur = cin_conducteur;
        this.nb_passagers = nb_passagers;
        this.options_offre = options_offre;
        this.statut_offre = statut_offre;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getMatricule_vehicule() {
        return matricule_vehicule;
    }

    public void setMatricule_vehicule(int matricule_vehicule) {
        this.matricule_vehicule = matricule_vehicule;
    }

    public int getCin_conducteur() {
        return cin_conducteur;
    }

    public void setCin_conducteur(int cin_conducteur) {
        this.cin_conducteur = cin_conducteur;
    }

    public int getNb_passagers() {
        return nb_passagers;
    }

    public void setNb_passagers(int nb_passagers) {
        this.nb_passagers = nb_passagers;
    }

    public String getOptions_offre() {
        return options_offre;
    }

    public void setOptions_offre(String options_offre) {
        this.options_offre = options_offre;
    }

    public String getStatut_offre() {
        return statut_offre;
    }

    public void setStatut_offre(String statut_offre) {
        this.statut_offre = statut_offre;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", matricule_vehicule=" + matricule_vehicule + ", cin_conducteur=" + cin_conducteur + ", nb_passagers=" + nb_passagers + ", options_offre=" + options_offre + ", statut_offre=" + statut_offre + '}';
    }

   
}
