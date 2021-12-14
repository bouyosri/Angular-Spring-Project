package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.EmailService;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/email")
public class EmailController {
	@Autowired
	EmailService emailService ;
	
	@GetMapping("/mailtest/{content}/{subject}/{email}")
	@ResponseBody
	public String send(@PathVariable("subject") String subject,@PathVariable("content") String content,@PathVariable("email") String email) {
		return emailService.sendEmail(content,subject,email);
	
	}

}
