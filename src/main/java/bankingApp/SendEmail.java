package bankingApp;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

   public static void sendPassword (String email, String userpassword) {    
	 
	      String from = "harshitamandloi25@gmail.com";//change accordingly
	      final String username = "harshitamandloi25";//change accordingly
	      final String password = "princess251291";//change accordingly

	      
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });
       //compose message    
       try {    
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
        message.setSubject("Retrived Password !!!");    
        message.setText("Your password is: " + userpassword);    
        //send message  
        Transport.send(message);    
        System.out.println("message sent successfully");    
       } catch (MessagingException e) {throw new RuntimeException(e);}    
          
 } 
   
   public static void sendAccountInfo (String email, long accountNumber) {    
		 
	      String from = "harshitamandloi25@gmail.com";//change accordingly
	      final String username = "harshitamandloi25";//change accordingly
	      final String password = "princess251291";//change accordingly

	      
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });
    //compose message    
    try {    
     MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(from));
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
     message.setSubject("HN BANK- Account Info !!!");    
     message.setText("Your accountNumber is: " + accountNumber+"\n\r"+"Please use this accountNumber for your transaction with HN Bank."+"\n\r"
     +"Your account has been credited with $10,000 initially"+"\n\r"+"\n\r"+"Regards,"+"\n\r"+"HN Bank" );    
     //send message  
     Transport.send(message);    
     System.out.println("message sent successfully");    
    } catch (MessagingException e) {throw new RuntimeException(e);}    
       
} 
   public static void sendActivities (String email, ArrayList<Activities> activities) {    
		 
	      String from = "harshitamandloi25@gmail.com";//change accordingly
	      final String username = "harshitamandloi25";//change accordingly
	      final String password = "princess251291";//change accordingly

	      
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });
 //compose message    
 try {    
  MimeMessage message = new MimeMessage(session);
  message.setFrom(new InternetAddress(from));
  message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
  message.setSubject("HN BANK- Monthly Statement !!!");    
  String mailMessage= "Greetings, \n\r \n\r";  
  for(Activities activity : activities) {
	  mailMessage = mailMessage + activity.getAccountNumber() +" "+ activity.getDate() +" "+ activity.getTransactionType()+" "+ activity.getAmount() + " \n\r";   
  }
  message.setText(mailMessage + "Regards,"+"\n\r"+"HN Bank");
  //send message  
  Transport.send(message);    
  System.out.println("message sent successfully");    
 } catch (MessagingException e) {throw new RuntimeException(e);}    
    
}  
}  


