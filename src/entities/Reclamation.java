/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author walid
 */
public class Reclamation {
    private int id;

    public Reclamation() {
    }
    private String message,etat; 

    public Reclamation(int id, String message, String etat) {
        this.id = id;
        this.message = message;
        this.etat = etat;
    }

    public Reclamation(String message, String etat) {
        this.message = message;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", message=" + message + ", etat=" + etat + '}';
    }
    
}
