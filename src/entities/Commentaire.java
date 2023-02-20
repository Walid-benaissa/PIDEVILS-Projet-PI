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
public class Commentaire {
    
    private int id1,id2;
    private String message;

    public Commentaire() {
    }

    public Commentaire(int id1, int id2, String message) {
        this.id1 = id1;
        this.id2 = id2;
        this.message = message;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Commentaire{" + "id1=" + id1 + ", id2=" + id2 + ", message=" + message + '}';
    }

    
}
