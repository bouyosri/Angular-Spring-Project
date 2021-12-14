package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
@Autowired
JavaMailSender javaMailSender ;


public String sendEmail(String content , String subject,String email) {
	SimpleMailMessage message= new SimpleMailMessage();
	message.setFrom("magasingestion4@gmail.com");
	System.out.print("maiiiiiladrr"+email);
	message.setTo(email);
	message.setSubject(subject);
	message.setText(content);
	
	javaMailSender.send(message);
	
	return "email sent !!! ";
}

}
