package com.sendemail.email_send;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailImpl {

	public static void sendEmail(String text,String subject,String to,String from) {
		try {
		//getting system properties
		Properties property=System.getProperties();
		System.out.println("System Properies :"+property);
		
		//setting Gmail information  to property object
		property.put("mail.smtp.host",EmailConstants.HOST);
		property.put("mail.smtp.port",EmailConstants.PORT);
		property.put("mail.smtp.ssl.enable",EmailConstants.SSLENABLE);
		property.put("mail.smtp.auth",EmailConstants.AUTHENTICATION);
		
		
		// Step-I  :  get the Session object
		
		Session session=Session.getDefaultInstance(property, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(EmailConstants.USERNAME,EmailConstants.PASSWORD);
			}
		});
		
		session.setDebug(true);
		
		//Step-II : Compose the message 
		MimeMessage mm=new MimeMessage(session);
		
		//FROM EMAIL
		mm.setFrom(EmailConstants.FROM);
		
		//Adding recipient 
		
		mm.addRecipient(Message.RecipientType.TO,new InternetAddress(EmailConstants.TO));
		
		//Adding Subject 
		
		mm.setSubject(EmailConstants.SUBJECT);
		
		//Addind Text
		
		mm.setText(EmailConstants.MESSAGE);
		
		//Step-III  : Send the email
		Transport.send(mm);
		
		System.out.println("Email Sent Successfully to "+EmailConstants.TO+"......");
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
