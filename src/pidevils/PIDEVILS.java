/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevils;

import entities.Reclamation;
import entities.Utilisateur;
import entities.Vehicule;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ReclamationService;
import service.UtilisateurService;
import service.VehiculeService;
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
//        ReclamationService rs = new ReclamationService();
//        UtilisateurService us = new UtilisateurService();
//        Utilisateur user1 = new Utilisateur("1323566", "abir", "kh", "abir@gmail.com", "abir", "26578467", "client", 0);
//        us.ajouter(user1);
////////////////////// Gestion Course //////////////////////////////
//             MyDB db1 =  MyDB.getInstance();
//               System.out.println(db1);
//                  Course c = new Course(1,"Tunis","Ariana",2,10,"en cours");
//                  Course c2 = new Course(2,"bardo","m5",5,15,"termine");
//                  Course c3 = new Course(3,"m9","m6",1,12,"en attente");
//                  
//                  Offre o= new Offre(1, 111, 1111, 11,"NC", "actif") ;
//                  Offre o2= new Offre(2, 222, 2222, 22,"NC", "inactif") ;
//                  Offre o3= new Offre(3, 333, 3333, 33,"NC", "actif") ;
//
//                  
//        
//        CourseService sc = new CourseService();
//        OffreService so = new OffreService();
//        //////// CRUD COURSE ///////////////
//        /*
//        try {
//        sc.ajouterC(c);
//        System.out.println("ajout avec succes");
//        } catch (SQLException ex) {
//        System.out.println(ex.getMessage());
//        }    */
//        /*      try {
//        sc.supprimerC(c3);
//        System.out.println("Suppression avec succes");
//        } catch (SQLException ex) {
//        System.out.println(ex.getMessage());
//        }*/
//            /*   try {
//            /*   sc.modifierC(c);
//            System.out.println("Modification avec succes");
//            } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            }    */
//        try {
//            System.out.println(sc.afficherCourse());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//         //////// CRUD OFFRE_COURSE ///////////////
//          
//         /*   try {
//         so.ajouterO(o);
//         System.out.println("ajout avec succes");
//         } catch (SQLException ex) {
//         System.out.println(ex.getMessage());
//         }    */
//        /*      try {
//        so.supprimerO(o3);
//        System.out.println("Suppression avec succes");
//        } catch (SQLException ex) {
//        System.out.println(ex.getMessage());
//        }*/
//            /*   try {
//            /*   so.modifierO(o);
//            System.out.println("Modification avec succes");
//            } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            }    */
//        try {
//            System.out.println(so.afficherOffre());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    ///////////////////////////////////////////////////////////////
//         
//      
//        VehiculeService vs = new VehiculeService();
//        Vehicule v= new Vehicule("46587","R7","Audi","Occasion","C://Users//walid//Downloads//home.png","1323566");
//        vs.supprimer(v);
    }

}
