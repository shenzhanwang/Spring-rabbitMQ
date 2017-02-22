package rabbitMQ.listener;


import po.Mail;

public class QueueListener1 {
	public void displayMail(Mail mail) throws Exception {
		System.out.println("队列监听器1号收到消息"+mail.toString());
	}
}
