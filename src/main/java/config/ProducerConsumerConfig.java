package config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rabbitMQ.listener.QueueListener1;
import rabbitMQ.listener.QueueListener2;
//生产者消费者模式的配置,包括一个队列和两个对应的消费者
@Configuration
public class ProducerConsumerConfig {
		@Autowired
		RabbitConfig rabbitconfig;
	
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
		    container.setConnectionFactory(rabbitconfig.connectionFactory());
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
		    container.setConnectionFactory(rabbitconfig.connectionFactory());
		    container.setMessageListener(mailListenerAdapter2());
		    container.setQueues(myQueue());
		    return container;
	    }
}
