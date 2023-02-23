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
public class Colis {
    private int id;
    private int nb_items;
    private String description;
    private float poids;

    public Colis() {
    }

    public Colis(int id, int nb_items, String description, float poids) {
        this.id = id;
        this.nb_items = nb_items;
        this.description = description;
        this.poids = poids;
    }

    public Colis(int nb_items, String description, float poids) {
        this.nb_items = nb_items;
        this.description = description;
        this.poids = poids;
    }  

    public Colis(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_items() {
        return nb_items;
    }

    public void setNb_items(int nb_items) {
        this.nb_items = nb_items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Colis{" + "id=" + id + ", nb_items=" + nb_items + ", description=" + description + ", poids=" + poids + '}';
    }
    
    
    
}
