/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevils;

import entities.Colis;
import entities.Livraison;
import entities.Offre_livraison;
import entities.Reclamation;
import entities.Utilisateur;
import entities.Vehicule;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ColisService;
import service.LivraisonService;
import service.OffreLivraisonService;
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

//Livraison
        //  LivraisonService ls = new LivraisonService();
        // Livraison livraison1 = new Livraison(1,"Boumhal", "Ariana");
        // Livraison livraison2 = new Livraison(1,"Ezzahra", "Tunis");
        //Livraison livraison3 = new Livraison(3,"aaa", "bbbb");
        //ls.ajouter(livraison1);
        // ls.ajouter(livraison2);
        // ls.ajouter(livraison3);
        // ls.supprimer(livraison3);
        //  Livraison livraison4 = new Livraison(2,"ccc", "xxx");
        // ls.modifier(livraison4);
        // System.out.println(ls.afficheListe());
        
 //Offre Livraison
        OffreLivraisonService ol = new OffreLivraisonService();
        Offre_livraison offre1 = new Offre_livraison(1,6.3f); 
        // Offre_livraison offre2 = new Offre_livraison(2,4.1f); 
        ol.ajouter(offre1);
        //ol.ajouter(offre2);
        //ol.supprimer(offre1);
        //   Offre_livraison offre3 = new Offre_livraison(2,7);
        // ol.modifier(offre3);
        // System.out.println(ol.afficheListe());
        
  //Colis
        //ColisService c = new ColisService();
       //Colis colis1 = new Colis(1, 2, "aa", 2.5f);
      //  Colis colis2 = new Colis(2,3,"oo",5.1f);
        //c.ajouter(colis1);
        //c.ajouter(colis2);
      //  c.supprimer(colis1);
       // Colis colis3 = new Colis(2, 1, "pp", 5);
       // c.modifier(colis3);
       // System.out.println(c.afficheListe());

    }

}
