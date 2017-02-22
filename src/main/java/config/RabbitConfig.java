package config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitMQ.listener.*;

@Configuration
public class RabbitConfig {
	 	@Bean
	    public ConnectionFactory connectionFactory() {
	 		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.229.129");
	 		connectionFactory.setUsername("wsz");
	 		connectionFactory.setPassword("123");
	 		connectionFactory.setPort(5672);
	 		return connectionFactory;
	    }

	    @Bean
	    public AmqpAdmin amqpAdmin() {
	        return new RabbitAdmin(connectionFactory());
	    }

	    @Bean
	    public RabbitTemplate rabbitTemplate() {
	        return new RabbitTemplate(connectionFactory());
	    }

	    @Bean
	    public Queue myQueue() {
	       Queue queue=new Queue("myqueue");
	       return queue;
	    }
	    
	    //消费者监听器1
	    @Bean
	    public QueueListener1 queueListener1() {
	    	return new QueueListener1();
	    }
	    
	    @Bean
	    public MessageListenerAdapter mailListenerAdapter() {
		    MessageListenerAdapter adapter = new MessageListenerAdapter();
		    adapter.setDelegate(queueListener1());
		    adapter.setDefaultListenerMethod("displayMail");
		    return adapter;
	    }
	    
	    @Bean
	    public SimpleMessageListenerContainer messageListenerContainer() {
		    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		    container.setConnectionFactory(connectionFactory());
		    container.setMessageListener(mailListenerAdapter());
		    container.setQueues(myQueue());
		    return container;
	    }
	    
	    //消费者监听器2
	    @Bean
	    public QueueListener2 queueListener2() {
	    	return new QueueListener2();
	    }
	    
	    @Bean
	    public MessageListenerAdapter mailListenerAdapter2() {
		    MessageListenerAdapter adapter = new MessageListenerAdapter();
		    adapter.setDelegate(queueListener2());
		    adapter.setDefaultListenerMethod("displayMail");
		    return adapter;
	    }
	    
	    @Bean
	    public SimpleMessageListenerContainer messageListenerContainer2() {
		    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		    container.setConnectionFactory(connectionFactory());
		    container.setMessageListener(mailListenerAdapter2());
		    container.setQueues(myQueue());
		    return container;
	    }
}
