package com.microservice.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.microservice.user.dtos.EmailRecordDto;
import com.microservice.user.models.UserModel;

@Component
public class UserProducer {

	final RabbitTemplate rabbitTemplate;

	public UserProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Value("${broker.queue.email.name}")
	private String routingKey;

	public void publishMensageEmail(UserModel user) {
		var emailDto = new EmailRecordDto(
				user.getId(), 
				user.getEmail(), 
				"Cadastro Realizado com Sucesso",
				user.getName() + " seja bem vindo, seu cadastro foi  realizado com Sucesso!"
				);
		rabbitTemplate.convertAndSend("", routingKey, emailDto);

	}

}
