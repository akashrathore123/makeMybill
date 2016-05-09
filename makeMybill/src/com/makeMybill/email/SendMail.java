package com.makeMybill.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;






import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;

import com.makeMybill.dto.BillDTO;


class MyPasswordAuthenticator extends Authenticator
{
String user;
String pw;

public MyPasswordAuthenticator (String username, String password)
{
super();
this.user = username;
this.pw = password;
}
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(user, pw);
}
}
public class SendMail {
     

	public static int sendEmail(BillDTO billData) throws MessagingException, UnsupportedEncodingException {
	    ResourceBundle rb = ResourceBundle.getBundle("db");

			 String username= rb.getString("username");
	         String password = rb.getString("password");
	         Properties props = new Properties();
	         props.put("mail.smtp.auth", "true");
	 		props.put("mail.smtp.starttls.enable", "true");
	 		props.put("mail.smtp.host", "smtp.gmail.com");
	 		props.put("mail.smtp.port", "587");

	 		Session session = Session.getInstance(props,
	 		  new javax.mail.Authenticator() {
	 			protected PasswordAuthentication getPasswordAuthentication() {
	 				return new PasswordAuthentication(username, password);
	 			}
	 		  });

	 		try {

	 			Message message = new MimeMessage(session);
	 			message.setFrom(new InternetAddress(username));
	 			message.setRecipients(Message.RecipientType.TO,
	 				InternetAddress.parse(billData.getUserId()));
	 			message.setSubject("Electricity Bill");
	 			message.setContent("","text/html; charset=utf-8");
              Transport.send(message);
        
         return 1;
         } catch (AddressException e) {
              
              e.printStackTrace();
         } catch (MessagingException e) {
              
              e.printStackTrace();
         }
         return 0;
		} 
		
	
		
	
}