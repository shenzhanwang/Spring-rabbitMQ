package boot.spring.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.spring.po.Mail;
import boot.spring.service.Publisher;


@Service("publisher")
public class PublisherImpl implements Publisher{
	@Autowired
	RabbitTemplate rabbitTemplate;

	public void publishMail(Mail mail) {
		rabbitTemplate.convertAndSend("fanout", "", mail);
	}

	public void senddirectMail(Mail mail, String routingkey) {
		rabbitTemplate.convertAndSend("direct", routingkey, mail);
	}

	public void sendtopicMail(Mail mail, String routingkey) {
		rabbitTemplate.convertAndSend("mytopic", routingkey, mail);
	}

	
	
}
