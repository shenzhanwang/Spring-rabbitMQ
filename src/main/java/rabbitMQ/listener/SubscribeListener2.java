package rabbitMQ.listener;

import java.io.IOException;

import po.Mail;

public class SubscribeListener2 {
	public void subscribe(Mail mail) throws IOException {
		System.out.println(mail.toString());
	}
}
