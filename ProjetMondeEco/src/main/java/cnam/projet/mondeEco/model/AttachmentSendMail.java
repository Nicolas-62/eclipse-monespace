package cnam.projet.mondeEco.model;

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
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class AttachmentSendMail {
	public static void sendMail(String from, String to, String sujet, List<String> content, String filename) {

		// boite mail de l'envoyeur
		String username = from;
		// mot de passe de la boite mail de l'envoyeur
		String password = "porkiki";

//		String smtpHost = "smtp.bbox.fr";
		String smtpHost = "smtp.free.fr";
		String mailer = "sendhtml";

		// Set properties and their values
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", 25);
		props.put("mail.debug", "true");

//	    Session session = Session.getInstance(props);

		// connexion à la boite mail de l'envoyeur
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		session.setDebug(true);

		try {
			// Create MimeMessage object & set values
			Message messageobj = new MimeMessage(session);
			messageobj.setFrom(new InternetAddress(from));
			messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//			messageobj.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
//			messageobj.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
			messageobj.setSubject(sujet);
//			collect(content, messageobj);
			messageobj.setHeader("X-Mailer", mailer);
			messageobj.setSentDate(new Date());
			// create and fill the first message part
			MimeBodyPart mbp1 = new MimeBodyPart();
//		    mbp1.setText(sujet);
			collect(sujet, content, mbp1);

			// create the second message part
			MimeBodyPart mbp2 = new MimeBodyPart();

			// attach the file to the message
			mbp2.attachFile(filename);

			// create the Multipart and add its parts to it
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);

			// add the Multipart to the message
			messageobj.setContent(mp);
			// Now send the message
			System.out.println("content type :" + messageobj.getContentType());
//			for (Enumeration<Header> e = messageobj.getAllHeaders(); e.hasMoreElements();) {
//				System.out.println("header" + e.nextElement().getValue());
//			}
			Transport.send(messageobj);
			System.out.println("Your email sent successfully....");
		} catch (Exception exp) {
			exp.getMessage();
//			throw new RuntimeException(exp);
		}
	}

	public static void collect(String sujet, List<String> content, MimeBodyPart msg)
			throws MessagingException, IOException {

//		String sujet = msg.getsujet();
		StringBuffer sb = new StringBuffer();
		sb.append("<HTML>\n");
		sb.append("<HEAD>\n");
		sb.append("<TITLE>\n");
		sb.append(sujet + "\n");
		sb.append("</TITLE>\n");
		sb.append("</HEAD>\n");

		sb.append("<BODY>\n");
//		sb.append("<H3>" + sujet + "</H3>" + "\n");

		sb.append("<p>");
		for (String line : content) {
			sb.append(line);
			sb.append("</br>");
		}
		sb.append("</p>");

		sb.append("</BODY>\n");
		sb.append("</HTML>\n");
		System.out.println("stringBuffer : " + sb.toString());

		msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));
	}
}