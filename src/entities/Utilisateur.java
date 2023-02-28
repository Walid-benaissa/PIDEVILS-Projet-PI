/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author abir
 */
public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String num_tel;
    private String role;
    private float evaluation;

    public Utilisateur() {
    }

    public Utilisateur(int id) {
        this.id = id;
    }

    public Utilisateur(String nom, String prenom, String mail, String num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.num_tel = num_tel;
    }

    public Utilisateur(String nom, String prenom, String mail, String mdp, String num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
        this.num_tel = num_tel;
    }

    
    public Utilisateur(int id, String nom, String prenom, String mail, String mdp, String num_tel, String role, float evaluation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
        this.num_tel = num_tel;
        this.role = role;
        this.evaluation = evaluation;
    }

    public Utilisateur(String nom, String prenom, String mail, String mdp, String num_tel, String role, float evaluation) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
        this.num_tel = num_tel;
        this.role = role;
        this.evaluation = evaluation;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
        String hashedMdp;
        hashedMdp = Crypt.hash(mdp);
        this.mdp = hashedMdp;
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
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp=" + mdp + ", num_tel=" + num_tel + ", role=" + role + ", evaluation=" + evaluation + '}';
    }


                



    
}
