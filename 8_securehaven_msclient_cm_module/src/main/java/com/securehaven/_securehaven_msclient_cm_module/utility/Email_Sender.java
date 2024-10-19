package com.securehaven._securehaven_msclient_cm_module.utility;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.securehaven._securehaven_msclient_cm_module.model.Customer_Loan_Application;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.annotation.MultipartConfig;

@Component
public class Email_Sender {
	
	@Autowired
	JavaMailSender jms;
	
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	public void sendSanctionEmail(Customer_Loan_Application c,MultipartFile f) throws MessagingException
	{
		MimeMessage message=jms.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		
		helper.setTo(c.getEmail());
		helper.setFrom(fromEmail);
		helper.setSubject("Sanction Letter");
		helper.addAttachment(f.getOriginalFilename(),f);
		
		jms.send(message);
	}
	

}
