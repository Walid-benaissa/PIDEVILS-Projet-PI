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
        UtilisateurService us = new UtilisateurService();
        Utilisateur user1 = new Utilisateur("1323566", "abir", "kh", "abir@gmail.com", "abir", "26578467", "client", 0);
        us.ajouter(user1);
    }

}
