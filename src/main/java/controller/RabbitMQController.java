package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Mail;
import service.impl.ProducerImpl;
import service.impl.PublisherImpl;

@Controller
public class RabbitMQController {
	
	
	@Autowired
	ProducerImpl producer;
	
	@Autowired
	PublisherImpl publisher;
	
	@RequestMapping(value="/produce",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void produce(@ModelAttribute("mail")Mail mail) throws Exception{
		producer.sendMail("myqueue",mail);
	}
	
	@RequestMapping(value="/topic",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void topic(@ModelAttribute("mail")Mail mail) throws Exception{
		publisher.publishMail(mail);
	}
	
	@RequestMapping("demo")
	public String demo(){
		return "demo";
	}
	
	
	
}
