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
    private int id,idAdmin,idUser;
    private String message,etat; 

    public Reclamation() {
    }
    
    public Reclamation(int id, String message, String etat,int idAdmin,int idUser) {
        this.id = id;
        this.message = message;
        this.etat = etat;
        this.idAdmin = idAdmin;
        this.idUser = idUser;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        return "Reclamation{" + "id=" + id + ", idAdmin=" + idAdmin + ", idUser=" + idUser + ", message=" + message + ", etat=" + etat + '}';
    }

  
    
}
