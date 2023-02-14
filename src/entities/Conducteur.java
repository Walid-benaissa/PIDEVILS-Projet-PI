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
public class Conducteur extends Utilisateur {
    private String permis;
    private String b3;

    public Conducteur() {
    }

    public Conducteur(String permis, String b3, String cin, String nom, String prenom, String mail, String mdp, String num_tel, String role, float evaluation) {
        super(cin, nom, prenom, mail, mdp, num_tel, role, evaluation);
        this.permis = permis;
        this.b3 = b3;
    }

    public String getPermis() {
        return permis;
    }

    public String getB3() {
        return b3;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "cin=" + getCin() + ", nom=" + getNom() + ", prenom=" + getPrenom() + 
                ", mail=" + getMail() + ", mdp=" + getMdp() + ", num_tel=" + getNum_tel() + ", role=" + getRole() +
                ", evaluation=" + getEvaluation() + "Conducteur{" + "permis=" + permis + ", b3=" + b3 + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
