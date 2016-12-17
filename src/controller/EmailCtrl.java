package controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import resources.Constants;

public class EmailCtrl {

	public void sendEmail(String email, String subject, String noidung) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Constants.GMAIL_USERNAME, Constants.GMAIL_PASSWORD);
			}
		});

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(Constants.GMAIL_USERNAME));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			msg.setSubject("troSV " + subject, "utf-8");
			msg.setContent(noidung, "text/html; charset=utf-8");
			Transport.send(msg);
		} catch (MessagingException e) {
			System.out.println("sendEmail has error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// EmailCtrl ctrl = new EmailCtrl();
		// ctrl.sendEmail("dangquangnhat18101994@gmail.com", "Test email");
	}
}
