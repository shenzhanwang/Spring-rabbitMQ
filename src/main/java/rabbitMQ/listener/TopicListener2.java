package rabbitMQ.listener;

import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;
import po.Mail;

public class TopicListener2 {
	@Transactional
	public void displayTopic(Mail mail) throws IOException {
		System.out.println(mail.toString());
		}
}
