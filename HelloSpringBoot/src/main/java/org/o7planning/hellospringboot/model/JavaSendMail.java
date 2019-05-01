package org.o7planning.hellospringboot.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

public class JavaSendMail {
	public static void sendMail() {
		// Declare recipient's & sender's e-mail id.
		String sendrmailid = "nicolas.lourdel@laposte.net";
		String destmailid = "droffig@hotmail.com";
		String subject = "Accusé de reception";
		String mailer = "sendhtml";
		List<String> content= new ArrayList<String>();
		content.add("Bienvenue Nicolas");
		content.add("Nous avons bien reçu ton inscription");
		content.add("\n");
		content.add("<a href=\"https://www.openclassrooms.com\">A bientot sur openclassroom</a>");
		
		// Mention user name and password as per your configuration
//      final String uname = "username";
//      final String pwd = "password";
		// We are using relay.jangosmtp.net for sending emails
//		String smtphost = "smtp.bbox.fr";
		String smtphost = "smtp.free.fr";
		// Set properties and their values
		Properties propvls = new Properties();
		
		/*
		 * si connexion securisée avec mdp
		 */
//      propvls.put("mail.smtp.auth", "true");
//		propvls.put("mail.smtp.starttls.enable", "true");
		
		propvls.put("mail.smtp.host", smtphost);
		propvls.put("mail.smtp.port", "25");
		propvls.put("mail.debug","true");
		// Create a Session object & authenticate uid and pwd
		Session sessionobj = Session.getInstance(propvls
		/*
		 * si connexion securisée avec mdp
		 */
//         new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//               return new PasswordAuthentication(uname, pwd);
//	   }
//         }
		);

		try {
			// Create MimeMessage object & set values
			Message messageobj = new MimeMessage(sessionobj);
			messageobj.setFrom(new InternetAddress(sendrmailid));
			messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destmailid));
			messageobj.setSubject(subject);
			collect(content, messageobj);
			messageobj.setHeader("X-Mailer", mailer);
			messageobj.setSentDate(new Date());
			// Now send the message
			System.out.println("content type :"+messageobj.getContentType());
			for (Enumeration<Header> e = messageobj.getAllHeaders(); e.hasMoreElements();) {
			       System.out.println("header"+e.nextElement().getValue());
			}
			Transport.send(messageobj);
			System.out.println("Your email sent successfully....");
		} catch (Exception exp) {
			exp.getMessage();
//			throw new RuntimeException(exp);
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
		System.out.println("stringBuffer : "+sb.toString());

		msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));
	}
}
