package com.microservice.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.microservice.email.dto.EmailRecordDto;
import com.microservice.email.models.EmailModel;
import com.microservice.email.service.EmailService;

@Component
public class EmailConsumer {

	final EmailService emailService;

	public EmailConsumer(EmailService emailService) {
		this.emailService = emailService;
	}

	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listEmailQueues(@Payload EmailRecordDto email) {
		System.out.println("RabbitMQ :::" + email.emailTo());
		var emailModel = new EmailModel();
		BeanUtils.copyProperties(email, emailModel);
		emailService.sendEmail(emailModel);

	}

}
