package com.homelibrary.service;

public interface EmailService {

	boolean sendEmail(String recipientEmail, String subject, String content);
}
