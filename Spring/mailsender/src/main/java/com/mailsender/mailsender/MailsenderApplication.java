package com.mailsender.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class MailsenderApplication {

	
	@Autowired
	private EmailSenderService service;
	public static void main(String[] args) {
		SpringApplication.run(MailsenderApplication.class, args);
	}
@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendSimpleEmail("ab.groups.maharashtra@gmail.com",
				"Hello this is JADUUUUUUUUUUUUU",
				"Jadu"
				);

	}
}
