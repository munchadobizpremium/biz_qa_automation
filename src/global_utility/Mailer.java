package global_utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

	
	public void MailtoQC()
	{
		 String host="smtp.office365.com";  
		  final String user="no-reply@munchado.biz";//change accordingly  
		  final String password="Duy43753";//change accordingly  
		    
		  String to="asangal@bravvura.in";//change accordingly  
		  
		   //Get the session object  
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host",host);
		   props.put("mail.smtp.port", "587");
		   props.put("mail.transport.protocol", "smtp");
		   props.put("mail.smtp.user", user);
		   props.put("mail.smtp.password", password);
		   
		     
		   Session session=null;
		try {
			session = Session.getDefaultInstance(props,  
			    new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(user,password);  
			      }  
			    });
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("hello");
		}  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		     message.addRecipient(Message.RecipientType.CC,new InternetAddress("rkumar@bravvura.in"));
		     message.setSubject("BizQc Automation Execution Status");  
		     StringBuilder template=new StringBuilder();
		     template.append("message template here");
		     template.append("\n");
		     template.append("http://htmlpreview.github.io/?https://github.com/njalanbr/biz_qa_automation/blob/master/reports/testReport.html");
		     message.setText(template.toString());  
		     message.setSentDate(new Date());   
		    //send the message  
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
	}
}
