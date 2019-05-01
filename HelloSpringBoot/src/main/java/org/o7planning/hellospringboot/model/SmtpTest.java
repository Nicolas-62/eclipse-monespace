package org.o7planning.hellospringboot.model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;import javax.management.RuntimeErrorException;
 
public class SmtpTest {
 
  public static void envoyer() throws Exception {
 
    String smtpHost = "smtp.bbox.fr";
    String from = "nicolas.lourdel@laposte.net";
    String to = "droffig@hotmail.com";
//    String username = "moi";
//    String password = "mon_mot_secret";
 
    Properties props = new Properties();
    props.put("mail.smtp.host", smtpHost);
    props.put("mail.smtp.auth", "true");
 
    Session session = Session.getDefaultInstance(props);
    session.setDebug(true);
 
    try {
    MimeMessage message = new MimeMessage(session);   
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject("Hello");
    message.setText("Hello World");
 
//    Transport tr = session.getTransport("smtp");
//    tr.connect(smtpHost, username, password);
//    message.saveChanges();
 
     Transport.send(message);
     System.out.println("Your email sent successfully....");
    /** Genere l'erreur. Avec l authentification, oblige d utiliser sendMessage meme pour une seule adresse... */
//    tr.sendMessage(message,message.getAllRecipients());
//    tr.close();
    }catch (MessagingException exp) {
        throw new RuntimeException(exp);
    }
 
  }
}