package com.liquid.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.liquid.notification.util.MailSender;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private MailSender mailSender;

	@Override
	public void send(String to, String subject, String message) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(to);
		smm.setSubject(subject);
		smm.setText(message);
		mailSender.send().send(smm);;
	}

//    @Override
//    public void sendMultiMedia() {
//        MimeMessage mimeMessage=mailSender.createMimeMessage();
//        MimeMessageHelper message=new MimeMessageHelper(mimeMessage,true);
//        message.setFrom("noreply@metsoft.com");
//        message.setTo("mustafatpe23@gmail.com");
//        message.setText("Selamlar Bu Mesaj Size Gönderildi");
//        message.setSubject("Sakın Açmaaa!!!!");
//        FileSystemResource file=new FileSystemResource(new File("D:\\Background\\mongodb.png"));
//        message.addAttachment("mongo.png",file);
//        mailSender.send(mimeMessage);
//    }

}
