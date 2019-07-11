package org.o7planning.hellospringboot.model;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
 
public class ContactSendMail {
 
  public static void envoyer(String from, String to, String sujet, List<String> content) {
 
//    String smtpHost = "smtp.bbox.fr";
    String smtpHost = "smtp.free.fr";
    String mailer = "sendhtml";
 
    Properties props = new Properties();
    props.put("mail.smtp.host", smtpHost);
    props.put("mail.smtp.auth", "false");
    props.put("mail.debug","true");
 
    Session session = Session.getInstance(props);
    session.setDebug(true);
 
    try {
    Message message = new MimeMessage(session);   
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject(sujet);
    collect(content, message);
    message.setHeader("X-Mailer", mailer);
    message.setSentDate(new Date());
 
//    Transport tr = session.getTransport("smtp");
//    tr.connect(smtpHost, username, password);
//    message.saveChanges();
 
     Transport.send(message);
     System.out.println("Your email sent successfully....");
    /** Genere l'erreur. Avec l authentification, oblige d utiliser sendMessage meme pour une seule adresse... */
//    tr.sendMessage(message,message.getAllRecipients());
//    tr.close();
    }catch (Exception exp) {
    	exp.getMessage();
        throw new RuntimeException(exp);
    }
 
  }
	public static void collect(List<String> content, Message msg) throws MessagingException, IOException {

		String subject = msg.getSubject();
		StringBuffer sb = new StringBuffer();
		sb.append("<HTML>\n");
		sb.append("<HEAD>\n");
		sb.append("<TITLE>\n");
		sb.append(subject + "\n");
		sb.append("</TITLE>\n");
		sb.append("</HEAD>\n");

		sb.append("<BODY>\n");
		sb.append("<H3>" + subject + "</H3>" + "\n");
		
		sb.append("<p>");
		for(String line : content) {
			sb.append(line);
			sb.append("</br>");
		}
		sb.append("</p>");

		sb.append("</BODY>\n");
		sb.append("</HTML>\n");
//		System.out.println("stringBuffer : "+sb.toString());

		msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));
	}
}