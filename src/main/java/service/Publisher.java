package service;

import po.Mail;

public interface Publisher {
	public void publishMail(Mail mail);//发布消息给所有队列
}
