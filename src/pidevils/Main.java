/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.CommonController;

/**
 *
 * @author walid
 */
public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
     Application.launch(args);  
   } 

    @Override
    public void start(Stage stage)  {
        try {  
            CommonController.setSceneContentStartup(stage);  
     } catch (IOException ex) {  
            System.out.println(ex.getMessage());  
     }      }
    
}
