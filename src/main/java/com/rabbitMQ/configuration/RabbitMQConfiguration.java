package com.rabbitMQ.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitMQ.consumer.ReceiveMessageHandler;

@Configuration
public class RabbitMQConfiguration {

	public static final String QUEUE_NAME = "TestQueue";
	public static final String EXCHANGE_NAME = "TestExchange";
	public static final String ROUTING_KEY = "route1";
	
	@Bean
	Queue createQueue()
	{
		return new Queue(QUEUE_NAME);
	}
	
	@Bean
	TopicExchange topicExchange()
	{
		return new TopicExchange(EXCHANGE_NAME);
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, 
//			MessageListenerAdapter messageListenerAdapter)
//	{
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(QUEUE_NAME);
//		container.setMessageListener(messageListenerAdapter);
//		return container;
//	}
//	
//	@Bean
//	MessageListenerAdapter messageListenerAdapter(ReceiveMessageHandler messageHandler)
//	{
//		return new MessageListenerAdapter(messageHandler, "handleMessage");
//	}
}
