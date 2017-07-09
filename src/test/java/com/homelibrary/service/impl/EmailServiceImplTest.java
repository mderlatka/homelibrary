package com.homelibrary.service.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.homelibrary.service.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/test-applicationContext.xml" })
@Transactional
public class EmailServiceImplTest {

	@Autowired
	private EmailService emailService;

	@Test
	public void testSendEmail() throws MessagingException, IOException{
		
		  String subject = "Test subject";
		  String content = "test message";

		emailService.sendEmail("derlei123@gmail.com", subject, content);
		
		Session session = Session.getDefaultInstance(new Properties());
		Store store = session.getStore("pop3");
		store.connect("gmail.com", "derlei123", "M@rdeR123");
		
		Folder folder = store.getFolder("inbox");
		folder.open(Folder.READ_ONLY);
		Message [] message = folder.getMessages();
		
		assertTrue(message.length == 1);
		assertEquals(subject, message[0].getSubject());
		assertEquals(content, message[0].getContent());
		folder.close(true);
		store.close();
	}

}
