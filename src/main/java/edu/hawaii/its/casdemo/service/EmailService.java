package edu.hawaii.its.casdemo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import edu.hawaii.its.casdemo.access.User;

@Service
public class EmailService {

    private static final Log logger = LogFactory.getLog(EmailService.class);

    private JavaMailSender javaMailSender;

    @Value("${app.mail.enabled}")
    private boolean isEnabled;

    @Value("${app.mail.from:no-reply}")
    private String from;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void send(User user) {
        logger.info("Sending email from send(user)...");
        if (isEnabled && user != null) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(user.getAttribute("eduPersonPrincipalName"));

            msg.setFrom(from);
            String text = "Test from the CAS Demonstration Application."
                    + "\n\nYour basic User information:\n" + user;
            msg.setText(text);
            msg.setSubject("Testing from Spring Boot");
            try {
                javaMailSender.send(msg);
            } catch (MailException ex) {
                logger.error("Error", ex);
            }
        }
    }

}
