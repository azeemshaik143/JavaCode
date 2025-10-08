package com.aja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aja.entity.Notification;
import com.aja.repo.NotificationRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepo notificationRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String emailSender;

	public Notification saveInfo(Notification notification) {
		return notificationRepo.save(notification);
	}

	public void sendMail(EmailFields emailFields) throws MessagingException {

		String personalizedBody = String.format(
				"Hi %s,\n\nYou are now registered and can now login.\n\nRegards,\nTeam AJA", emailFields.getName());

		if (emailFields.getBody() != null && !emailFields.getBody().isEmpty()) {
			personalizedBody += "\n\n";
		}

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		helper.setFrom(emailSender);
		helper.setTo(emailFields.getTo());
		helper.setSubject(emailFields.getSubject());
		helper.setText(personalizedBody, false);

		javaMailSender.send(message);
	}
}
