package com.rabbitMQ.consumer;

import org.springframework.stereotype.Service;

@Service
public class ReceiveMessageHandler {

	public void handleMessage(String messageBody)
	{
		System.out.println("Message : " + messageBody);
	}
}
