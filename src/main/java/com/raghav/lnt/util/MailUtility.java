package com.raghav.lnt.util;


import org.springframework.mail.SimpleMailMessage;

public class MailUtility {
public static  SimpleMailMessage sendMailForgotPassword(String from, String to, String subject, String body) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);
	return mail;	
	}
}
