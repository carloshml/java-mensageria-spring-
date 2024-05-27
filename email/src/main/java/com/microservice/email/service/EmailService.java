package com.microservice.email.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.microservice.email.enums.StatusEmail;
import com.microservice.email.models.EmailModel;
import com.microservice.email.repositories.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {
	
	final EmailRepository emailRepository;	
	final JavaMailSender emailSender;
	
	public EmailService(  EmailRepository emailRepository , JavaMailSender javaMailSender ) {
		this.emailRepository = emailRepository;
		this.emailSender = javaMailSender;	 
	}
	
	@Value("${spring.mail.username}")
	private String emailFrom;
	
	@Transactional
	public EmailModel sendEmail(EmailModel emailModel) {
	    try {
	        emailModel.setSendDateEmail(LocalDateTime.now());
	        emailModel.setEmailFrom(emailFrom); // (emailFrom is not defined in this snippet)
	        
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(emailModel.getEmailTo());
	        message.setSubject(emailModel.getSubject());
	        message.setText(emailModel.getText());
	        emailSender.send(message);
	        
	        emailModel.setStatusEmail(StatusEmail.SENT);
	        return emailRepository.save(emailModel);
	    } catch (MailException e) {
	        emailModel.setStatusEmail(StatusEmail.ERROR);
	        throw e;
	    } finally {
	      
	    }
	}


}
