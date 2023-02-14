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
    private String cin1,cin2,message;

    public Commentaire() {
    }

    public Commentaire(String cin1, String cin2, String message) {
        this.cin1 = cin1;
        this.cin2 = cin2;
        this.message = message;
    }

    public String getCin1() {
        return cin1;
    }

    public void setCin1(String cin1) {
        this.cin1 = cin1;
    }

    public String getCin2() {
        return cin2;
    }

    public void setCin2(String cin2) {
        this.cin2 = cin2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "cin1=" + cin1 + ", cin2=" + cin2 + ", message=" + message + '}';
    }
        
}
