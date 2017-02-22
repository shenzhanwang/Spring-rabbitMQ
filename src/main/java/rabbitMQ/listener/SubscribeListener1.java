package rabbitMQ.listener;

import java.io.IOException;

import po.Mail;

public class SubscribeListener1 {
	public void subscribe(Mail mail) throws IOException {
		System.out.println("订阅者1收到消息"+mail.toString());
	}
}
