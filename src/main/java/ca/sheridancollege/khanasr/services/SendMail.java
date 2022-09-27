package ca.sheridancollege.khanasr.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class SendMail {

	
	@Autowired
	private JavaMailSender  mailSender;
	
	
	
public void sendMail(String fromEmail, String subject, String body
	//	,MultipartFile[]file
		) {
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("1khan.asra@gmail.com");
		message.setTo(fromEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		
		System.out.print("Mail denf successful");
		
	}
	
}
