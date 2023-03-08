/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bough
 */
public class Chatbot {
    public String processInput(String input) {
       if(null == input)return "Malheuresement j'ai pas une reponse à ce genre de Message , merci d'attendez nos mise à jour systeme !";
       else switch (input) {
            case "Salut":
                return "Bonjour, comment puis-je vous aider ?";
            case "comment je peux creer une course":
                return "Tout d'abord acceder au interface Course , clicker le button choisir votre trajet pour \n distinger la distance de ce dernier , retourner vers l'interface Course et remplissez \n la formulaire et au finale cliquer sur Ajouter et une notifaction sera envoyer \n contenant les informations du course enregistrer " ;
            case "Avez vous des plans à faire en attendant le course":
                return "Bien sur , vous pouvez cliquer sur Entertainement pour jouez notre jeu";
            case "Pouvez vous m'expliquer le concept de cette application":
                return "Fi thnity , est une application qui facilite la tache du deplacement en reservant une \n course , louer une voiture et de plus livrer votre produit sans bougés !  " ;
            case "Merci":
                return "A tout moment , je suis là pour vous aidez !";
              
            default:
                return "Malheuresement j'ai pas une reponse à ce genre de Message , merci d'attendez nos mise à jour systeme !";
        }
    }
}
