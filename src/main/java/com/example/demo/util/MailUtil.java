package com.example.demo.util;

import java.nio.charset.StandardCharsets;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	@Autowired
	private JavaMailSender emailSender;
	
	public void sendMail(byte[] pdfBytes, String mimeType) throws MessagingException {
		DataSource dataSource = new ByteArrayDataSource(pdfBytes, mimeType);
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.setTo("vinod.kolli234@gmail.com");
		helper.setSubject("invoice1");
		helper.setText("erferf");
		helper.setFrom("vinod.kolli65@gmail.com");
		helper.addAttachment("invoice.pdf", dataSource);

		emailSender.send(message);
	}
	
}
