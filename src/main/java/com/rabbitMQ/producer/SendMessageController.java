package com.rabbitMQ.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitMQ.configuration.RabbitMQConfiguration;
import com.rabbitMQ.entity.Message;

@RestController
public class SendMessageController {

	private final RabbitTemplate rabbitTemplate;
	
	public SendMessageController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@PostMapping("/sendMessage")
	public String sendMessage(@RequestBody Message message)
	{
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME, 
				RabbitMQConfiguration.ROUTING_KEY, message);
		return "message sent";
	}
}
