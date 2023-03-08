/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Random;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.*;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import service.UtilisateurService;
import utils.CommonController;
import static utils.CommonController.setSceneContent;
import utils.Context;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLMdpoublieController extends CommonController implements Initializable {

    @FXML
    private TextField fxLog;
    @FXML
    private Text cdsEnvoyer;
    @FXML
    private Text cdsPass;
    UtilisateurService uc = new UtilisateurService();
    Utilisateur u = new Utilisateur();
    @FXML
    private Text vPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void EnvoyerBTN(ActionEvent event) {
        String To = fxLog.getText();
        System.out.println(To.isEmpty());
        if (To.isEmpty()){
            cdsEnvoyer.setVisible(true);
            return;
        } else if (uc.verifMail(To)) {
            cdsPass.setVisible(false);
            vPass.setVisible(true);

        } else {
            vPass.setVisible(false);

            envoyerMail(To);
            Context.getInstance().addContextObject("mail", To);

            try {
                setSceneContent("FXMLCodeConfirmation");
            } catch (IOException ex) {
                Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void envoyerMail(String To) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pfe.mailer2022@gmail.com", "yfytvfimsgddnwgs");
            }
        }
        );
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pfe.mailer2022@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            String code = generateRandomCode();
            message.setSubject("code de validation");
            String content = "<!DOCTYPE html>\n"
                    + "<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "	<title></title>\n"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                    + "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "	<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n"
                    + "	<!--[if !mso]><!-->\n"
                    + "	<link href=\"https://fonts.googleapis.com/css?family=Oswald\" rel=\"stylesheet\" type=\"text/css\">\n"
                    + "	<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n"
                    + "	<!--<![endif]-->\n"
                    + "	<style>\n"
                    + "		* {\n"
                    + "			box-sizing: border-box;\n"
                    + "		}\n"
                    + "\n"
                    + "		body {\n"
                    + "			margin: 0;\n"
                    + "			padding: 0;\n"
                    + "		}\n"
                    + "\n"
                    + "		a[x-apple-data-detectors] {\n"
                    + "			color: inherit !important;\n"
                    + "			text-decoration: inherit !important;\n"
                    + "		}\n"
                    + "\n"
                    + "		#MessageViewBody a {\n"
                    + "			color: inherit;\n"
                    + "			text-decoration: none;\n"
                    + "		}\n"
                    + "\n"
                    + "		p {\n"
                    + "			line-height: inherit\n"
                    + "		}\n"
                    + "\n"
                    + "		.desktop_hide,\n"
                    + "		.desktop_hide table {\n"
                    + "			mso-hide: all;\n"
                    + "			display: none;\n"
                    + "			max-height: 0px;\n"
                    + "			overflow: hidden;\n"
                    + "		}\n"
                    + "\n"
                    + "		.image_block img+div {\n"
                    + "			display: none;\n"
                    + "		}\n"
                    + "\n"
                    + "		@media (max-width:885px) {\n"
                    + "			.desktop_hide table.icons-inner {\n"
                    + "				display: inline-block !important;\n"
                    + "			}\n"
                    + "\n"
                    + "			.icons-inner {\n"
                    + "				text-align: center;\n"
                    + "			}\n"
                    + "\n"
                    + "			.icons-inner td {\n"
                    + "				margin: 0 auto;\n"
                    + "			}\n"
                    + "\n"
                    + "			.image_block img.big,\n"
                    + "			.row-content {\n"
                    + "				width: 100% !important;\n"
                    + "			}\n"
                    + "\n"
                    + "			.mobile_hide {\n"
                    + "				display: none;\n"
                    + "			}\n"
                    + "\n"
                    + "			.stack .column {\n"
                    + "				width: 100%;\n"
                    + "				display: block;\n"
                    + "			}\n"
                    + "\n"
                    + "			.mobile_hide {\n"
                    + "				min-height: 0;\n"
                    + "				max-height: 0;\n"
                    + "				max-width: 0;\n"
                    + "				overflow: hidden;\n"
                    + "				font-size: 0px;\n"
                    + "			}\n"
                    + "\n"
                    + "			.desktop_hide,\n"
                    + "			.desktop_hide table {\n"
                    + "				display: table !important;\n"
                    + "				max-height: none !important;\n"
                    + "			}\n"
                    + "		}\n"
                    + "	</style>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n"
                    + "	<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\">\n"
                    + "		<tbody>\n"
                    + "			<tr>\n"
                    + "				<td>\n"
                    + "					<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f3f2f7;\">\n"
                    + "						<tbody>\n"
                    + "							<tr>\n"
                    + "								<td>\n"
                    + "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; background-position: center top; width: 865px;\" width=\"865\">\n"
                    + "										<tbody>\n"
                    + "											<tr>\n"
                    + "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
                    + "													<table class=\"image_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
                    + "														<tr>\n"
                    + "															<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n"
                    + "																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\"><img src=\"https://d15k2d11r6t6rl.cloudfront.net/public/users/Integrators/BeeProAgency/793226_777017/Artboard%201%20copy%203-100.jpg\" style=\"display: block; height: auto; border: 0; width: 346px; max-width: 100%;\" width=\"346\"></div>\n"
                    + "															</td>\n"
                    + "														</tr>\n"
                    + "													</table>\n"
                    + "													<table class=\"image_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
                    + "														<tr>\n"
                    + "															<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n"
                    + "																<div class=\"alignment\" align=\"center\" style=\"line-height:10px\"><img class=\"big\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/1741/top.png\" style=\"display: block; height: auto; border: 0; width: 865px; max-width: 100%;\" width=\"865\"></div>\n"
                    + "															</td>\n"
                    + "														</tr>\n"
                    + "													</table>\n"
                    + "												</td>\n"
                    + "											</tr>\n"
                    + "										</tbody>\n"
                    + "									</table>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "						</tbody>\n"
                    + "					</table>\n"
                    + "					<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f3f2f7;\">\n"
                    + "						<tbody>\n"
                    + "							<tr>\n"
                    + "								<td>\n"
                    + "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 865px;\" width=\"865\">\n"
                    + "										<tbody>\n"
                    + "											<tr>\n"
                    + "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 35px; padding-left: 10px; padding-right: 10px; padding-top: 15px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
                    + "													<table class=\"text_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"20\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n"
                    + "														<tr>\n"
                    + "															<td class=\"pad\">\n"
                    + "																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n"
                    + "																	<div class style=\"font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 21.6px; color: #000000; line-height: 1.8;\">\n"
                    + "																		<p style=\"margin: 0; font-size: 12px; text-align: left; mso-line-height-alt: 50.4px;\"><span style=\"font-size:28px;\"><strong><span style>Votre code de confirmation est:</span></strong></span></p>\n"
                    + "																	</div>\n"
                    + "																</div>\n"
                    + "															</td>\n"
                    + "														</tr>\n"
                    + "													</table>\n"
                    + "													<table class=\"heading_block block-2\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
                    + "														<tr>\n"
                    + "															<td class=\"pad\">\n"
                    + "																<h1 style=\"margin: 0; color: #2729a0; direction: ltr; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; font-size: 64px; font-weight: 700; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong>"+code+"</strong></h1>\n"
                    + "															</td>\n"
                    + "														</tr>\n"
                    + "													</table>\n"
                    + "													<table class=\"paragraph_block block-3\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n"
                    + "														<tr>\n"
                    + "															<td class=\"pad\">\n"
                    + "																<div style=\"color:#393d47;direction:ltr;font-family:Oswald, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:24px;font-weight:400;letter-spacing:0px;line-height:120%;text-align:left;mso-line-height-alt:28.799999999999997px;\">\n"
                    + "																	<p style=\"margin: 0;\">Nous avons reçu une demande changement de mot de passe de la part de ce mail, si vous n'etes pas le responsable veuillez ignorer ce mail.</p>\n"
                    + "																</div>\n"
                    + "															</td>\n"
                    + "														</tr>\n"
                    + "													</table>\n"
                    + "												</td>\n"
                    + "											</tr>\n"
                    + "										</tbody>\n"
                    + "									</table>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "						</tbody>\n"
                    + "					</table>\n"
                    + "					<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
                    + "						<tbody>\n"
                    + "							<tr>\n"
                    + "								<td>\n"
                    + "									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 865px;\" width=\"865\">\n"
                    + "										<tbody>\n"
                    + "											<tr>\n"
                    + "												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n"
                    + "													<table class=\"icons_block block-1\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
                    + "														<tr>\n"
                    + "															<td class=\"pad\" style=\"vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n"
                    + "																<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n"
                    + "																	<tr>\n"
                    + "																		<td class=\"alignment\" style=\"vertical-align: middle; text-align: center;\">\n"
                    + "																			<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n"
                    + "																			<!--[if !vml]><!-->\n"
                    + "																			<table class=\"icons-inner\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n"
                    + "																				<!--<![endif]-->\n"
                    + "																				<tr>\n"
                    + "																					<td style=\"vertical-align: middle; text-align: center; padding-top: 5px; padding-bottom: 5px; padding-left: 5px; padding-right: 6px;\"><a href=\"https://www.designedwithbee.com/?utm_source=editor&utm_medium=bee_pro&utm_campaign=free_footer_link\" target=\"_blank\" style=\"text-decoration: none;\"><img class=\"icon\" alt=\"Designed with BEE\" src=\"https://d15k2d11r6t6rl.cloudfront.net/public/users/Integrators/BeeProAgency/53601_510656/Signature/bee.png\" height=\"32\" width=\"34\" align=\"center\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\"></a></td>\n"
                    + "																					<td style=\"font-family: Oswald, Arial, Helvetica Neue, Helvetica, sans-serif; font-size: 15px; color: #9d9d9d; vertical-align: middle; letter-spacing: undefined; text-align: center;\"><a href=\"https://www.designedwithbee.com/?utm_source=editor&utm_medium=bee_pro&utm_campaign=free_footer_link\" target=\"_blank\" style=\"color: #9d9d9d; text-decoration: none;\">Designed with BEE</a></td>\n"
                    + "																				</tr>\n"
                    + "																			</table>\n"
                    + "																		</td>\n"
                    + "																	</tr>\n"
                    + "																</table>\n"
                    + "															</td>\n"
                    + "														</tr>\n"
                    + "													</table>\n"
                    + "												</td>\n"
                    + "											</tr>\n"
                    + "										</tbody>\n"
                    + "									</table>\n"
                    + "								</td>\n"
                    + "							</tr>\n"
                    + "						</tbody>\n"
                    + "					</table>\n"
                    + "				</td>\n"
                    + "			</tr>\n"
                    + "		</tbody>\n"
                    + "	</table><!-- End -->\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            message.setContent(content, "text/html; charset=utf-8");
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "code envoyer");
            Context.getInstance().addContextObject("codeValidation", code);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static String generateRandomCode() {
        int codeLength = 8;
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(numbers.length());
            char digit = numbers.charAt(index);
            code.append(digit);
        }

        return code.toString();
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            setSceneContent("FXMLAuthentification");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
