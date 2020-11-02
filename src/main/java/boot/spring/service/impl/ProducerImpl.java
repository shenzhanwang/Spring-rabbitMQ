package boot.spring.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boot.spring.po.Mail;
import boot.spring.service.Producer;

@Transactional
@Service("producer")
public class ProducerImpl implements Producer{
	@Autowired
	RabbitTemplate rabbitTemplate;
	public void sendMail(String queue,Mail mail) {
		rabbitTemplate.setQueue(queue);
		rabbitTemplate.convertAndSend(queue,mail);
	}

}
