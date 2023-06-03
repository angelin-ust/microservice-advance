package com.ust.rabbitmq.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;



@Configuration
public class MessagingConfig {

	
	///step1: 
//	public static final String QUEUE= "ust_queue";
//	public static final String EXCHANGE="ust_exchange";
//	public static final String ROUTING_KEY="ust_routingkey"; //tag is like 
	//routingkey //which bind the exchange and queue
	
	//command the above and inject in applicationa
	
	
	
	//injecting using value
	
	@Value("${ust.rabbitmq.queue}")

	
	 String queueName;
	
	@Value("${ust.rabbitmq.exchange}")
public  static	String exchange;
	
	
	@Value("${ust.rabbitmq.routingkey}")
	public static String routingkey;
	
	
	@Bean
	public Queue queue() ///we are creating the queue
	{
		return new Queue(queueName);
	}
	
	
	@Bean
	public TopicExchange exchange()
	{
		return new TopicExchange(exchange);
	}
	
	
	
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange)
	{
		return BindingBuilder.
				bind(queue).
				to(exchange).
				with(routingkey);
	}
	
	//then creating message coverter(java object to jaison we tell
	//jackson to jason
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory)
	//with the template the message will be send
	//it will same like restcontroller like as we need data to the
	//java to database it will be like
	//from where the connectionfactory if the anytime@bean the 
	
	//spring container will be called by the springcontainer
	//connection b/w the producer and consumer
	//exchange to queue to consumer.....like that goes on
	//connectionfactory also use to create many connections
	{
      RabbitTemplate template =new RabbitTemplate(connectionFactory);
      template.setMessageConverter(converter());
      return template;
	}


	
	
	
}
