/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static utils.CommonController.setSceneContent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLColisQrController implements Initializable {

    @FXML
    private TextField LINK;
    @FXML
    private Button jButton1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void jButton1ActionPerformed(ActionEvent event) {
              try{
           String QrCodeData= LINK.getText();
    String filePath= "C:\\Users\\user\\Documents\\NetBeansProjects\\QR_Code\\qr.png";
     String charset= "UTF-8";
    Map <EncodeHintType,ErrorCorrectionLevel> hintMap= new HashMap <EncodeHintType,ErrorCorrectionLevel> ();
    hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    BitMatrix  matrix= new MultiFormatWriter().encode(
    new String (QrCodeData.getBytes(charset),charset),
    BarcodeFormat.QR_CODE,200,200,hintMap);
    
    MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.')+1),new File(filePath));
        System.out.println("Qr code has been generated at the location "+filePath);
        
           JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\QR_Code\\qr.png");
        JLabel label = new JLabel(icon);
        frame.add(label);
  frame.setDefaultCloseOperation
         (JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);    

      }
     catch(Exception e){
        System.out.println(e);
          
      }
    }

    @FXML
    private void retour(ActionEvent event) {
                 try {
            setSceneContent("FXMLLivreurLivraison");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGererReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
