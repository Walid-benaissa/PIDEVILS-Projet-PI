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
public class Utilisateur {
    private String cin;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String num_tel;
    private String role;
    private float evaluation;

    public Utilisateur() {
    }

    
    public Utilisateur(String cin, String nom, String prenom, String mail, String mdp, String num_tel, String role, float evaluation) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
        this.num_tel = num_tel;
        this.role = role;
        this.evaluation = evaluation;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public String getRole() {
        return role;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp=" + mdp + ", num_tel=" + num_tel + ", role=" + role + ", evaluation=" + evaluation + '}';
    }


                



    
}
