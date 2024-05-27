package com.microservice.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.microservice.email.dto.EmailRecordDto;

@Component
public class EmailConsumer {
	
	@RabbitListener(queues = "${broker.queue.email.name}" )
	public void listEmailQueues(@Payload EmailRecordDto email) {
		System.out.println("mesangem RabbitMQ :: "+ email.emailTo());
		
	}

}
