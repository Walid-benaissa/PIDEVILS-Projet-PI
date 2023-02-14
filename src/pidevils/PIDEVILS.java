/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevils;

import entities.Reclamation;
import entities.Utilisateur;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ReclamationService;
import service.UtilisateurService;
import utils.MyDB;

/**
 *
 * @author walid
 */
public class PIDEVILS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReclamationService rs = new ReclamationService();
        //Reclamation r = new Reclamation("Site trop lent","Closed");

        UtilisateurService us = new UtilisateurService();
        Utilisateur user1 = new Utilisateur("1440427658","salah","Ben Salah","salah@gmail.com","123456","+21626555555","client",2.5F);
      //  us.ajouter(user1);
        System.out.println(MyDB.getInstance().getConnexion());
    }

}
