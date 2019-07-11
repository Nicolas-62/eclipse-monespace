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
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class JavaSendMail {
	public static void sendMail(String args[], List<String> content) {
		// Declare recipient's & sender's e-mail id.
//		String sendrmailid = "nicolas.lourdel@laposte.net";
//		String destmailid = "droffig@hotmail.com";
//		String subject = "Accusé de reception";
//		String mailer = "sendhtml";
//		String filename = args[0];
		String sendrmailid = args[0];
		String destmailid = args[1];
		String subject = args[2];
		String mailer = "sendhtml";
		String filename="";
		if(args[3]!=null) {
			filename = args[3];
		}
		// serveur de mail de la connection courante
		String smtphost = "smtp.bbox.fr";
//		String smtphost = "smtp.free.fr";
		
		// Set properties and their values
		Properties propvls = new Properties();
		propvls.put("mail.smtp.host", smtphost);
		propvls.put("mail.smtp.port", "25");
		propvls.put("mail.debug", "true");
		
		// Create a Session object & authenticate uid and pwd
		Session sessionobj = Session.getInstance(propvls);
		sessionobj.setDebug(true);
		try {
			// Create MimeMessage object & set values
			Message messageobj = new MimeMessage(sessionobj);
			messageobj.setFrom(new InternetAddress(sendrmailid));
			messageobj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destmailid));
			messageobj.setSubject(subject);
			messageobj.setHeader("X-Mailer", mailer);
			messageobj.setSentDate(new Date());
			
			// create and fill the first message part
			MimeBodyPart mbp1 = new MimeBodyPart();
//		    mbp1.setText(subject);
			collect(content, mbp1);

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
			for (Enumeration<Header> e = messageobj.getAllHeaders(); e.hasMoreElements();) {
				System.out.println("header" + e.nextElement().getValue());
			}
			Transport.send(messageobj);
			System.out.println("Your email sent successfully....");
		} catch (Exception exp) {
			exp.getMessage();
		}
	}

	public static void collect(List<String> content, MimeBodyPart msg) throws MessagingException, IOException {

//		String subject = msg.getSubject();
		StringBuffer sb = new StringBuffer();
		sb.append("<HTML>\n");
		sb.append("<HEAD>\n");
		sb.append("<TITLE>\n");
//		sb.append(subject + "\n");
		sb.append("</TITLE>\n");
		sb.append("</HEAD>\n");

		sb.append("<BODY>\n");
//		sb.append("<H3>" + subject + "</H3>" + "\n");

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
