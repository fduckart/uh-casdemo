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
import edu.hawaii.its.casdemo.type.Feedback;

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

    public void send(SimpleMailMessage msg) {
        try {
            javaMailSender.send(msg);
        } catch (MailException ex) {
            logger.error("Error", ex);
        }
    }

    private void sendMessage(User user, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setSubject("Testing from CAS Demo");
        msg.setTo(user.getAttribute("eduPersonPrincipalName"));
        msg.setFrom(from);
        msg.setText(message);

        send(msg);
    }

    public void sendCasData(User user) {
        logger.info("Sending email from sendCasData(user)...");
        if (isEnabled && user != null) {
            String text = "Test from the CAS Demonstration Application."
                    + "\n\nYour basic User information:\n" + user;
            sendMessage(user, text);
        }
    }

    public void sendFeedbackData(User user, Feedback feedback) {
        logger.info("Sending email from sendFeedbackData(user)...");
        if (isEnabled && user != null && feedback != null) {
            String text = "Test from the CAS Demonstration Application."
                    + "\n\nFeedback data:\n" + feedback;
            if (feedback.getExceptionStr() != null) {
                text += "\n\nException: " + feedback.getExceptionStr();
            }
            sendMessage(user, text);
        }
    }
}
