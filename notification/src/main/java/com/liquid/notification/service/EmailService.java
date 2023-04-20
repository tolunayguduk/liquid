package com.liquid.notification.service;

public interface EmailService {

	void send(String to, String subject, String message);
}
