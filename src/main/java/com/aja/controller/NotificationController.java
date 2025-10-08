package com.aja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aja.entity.Notification;
import com.aja.service.EmailFields;
import com.aja.service.NotificationService;

import jakarta.mail.MessagingException;

@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("/sendmail")
	public String sendMail(@RequestBody EmailFields emailField) throws MessagingException {
		notificationService.sendMail(emailField);
		return "Emails sent!";
	}
}
