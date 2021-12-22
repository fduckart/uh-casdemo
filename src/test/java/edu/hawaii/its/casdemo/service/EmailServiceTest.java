package edu.hawaii.its.casdemo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;

import edu.hawaii.its.casdemo.access.UhCasAttributes;
import edu.hawaii.its.casdemo.access.User;
import edu.hawaii.its.casdemo.type.Feedback;

public class EmailServiceTest {

    private EmailService emailService;
    private static boolean sendRan = false;

    @BeforeEach
    public void setUp() {
        emailService = new EmailService(new JavaMailSenderDummy());
        sendRan = false;
    }

    @Test
    public void construction() {
        assertNotNull(emailService);
        assertFalse(emailService.isEnabled());
    }

    @Test
    public void sendCasData() {
        assertFalse(emailService.isEnabled());

        // Test send.
        emailService.sendCasData(null);

        // Test send.
        emailService.setEnabled(true);
        emailService.sendCasData(null);

        Map<Object, Object> map = new HashMap<>();
        map.put("uid", "duckart");
        map.put("uhuuid", "666666");
        map.put("cn", "Frank");
        map.put("mail", "frank@example.com");
        map.put("eduPersonAffiliation", "aff");
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        User user = new User("eno", authorities);
        user.setAttributes(new UhCasAttributes(map));

        // Test send.
        emailService.sendCasData(user);

        // Test send, but with an internal exception.
        assertFalse(sendRan);
        JavaMailSender sender = new JavaMailSenderDummy() {
            @Override
            public void send(SimpleMailMessage arg0) throws MailException {
                sendRan = true;
                throw new MailSendException("Some Exception");
            }
        };
        emailService = new EmailService(sender);
        emailService.setEnabled(true);
        emailService.sendCasData(user);
        assertTrue(sendRan);
    }

    @Test
    public void sendFeedbackData() {
        JavaMailSender sender = new JavaMailSenderDummy() {
            @Override
            public void send(SimpleMailMessage arg0) throws MailException {
                sendRan = true;
            }
        };

        emailService = new EmailService(sender);
        assertFalse(emailService.isEnabled());

        // Test send.
        emailService.sendFeedbackData(null, null);
        assertFalse(sendRan);

        // Test send.
        emailService.setEnabled(true);
        emailService.sendFeedbackData(null, null);
        assertFalse(sendRan);

        Map<Object, Object> map = new HashMap<>();
        map.put("uid", "duckart");
        map.put("uhuuid", "666666");
        map.put("cn", "Frank");
        map.put("mail", "frank@example.com");
        map.put("eduPersonAffiliation", "aff");
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        User user = new User("eno", authorities);
        user.setAttributes(new UhCasAttributes(map));

        // Test send.
        emailService.sendFeedbackData(user, null);
        assertFalse(sendRan);

        // Test send.
        emailService.sendFeedbackData(user, new Feedback());
        assertTrue(sendRan);

        // Test send, but with an internal exception.
        sendRan = false;
        assertFalse(sendRan);
        sender = new JavaMailSenderDummy() {
            @Override
            public void send(SimpleMailMessage arg0) throws MailException {
                sendRan = true;
                throw new MailSendException("Some Exception");
            }
        };
        emailService = new EmailService(sender);
        emailService.setEnabled(true);
        emailService.sendFeedbackData(user, new Feedback());
        assertTrue(sendRan);

        sendRan = false;
        assertFalse(sendRan);
        sender = new JavaMailSenderDummy() {
            @Override
            public void send(SimpleMailMessage arg0) throws MailException {
                sendRan = true;
                throw new MailSendException("Some Exception");
            }
        };
        emailService = new EmailService(sender);
        emailService.setEnabled(true);
        emailService.sendFeedbackData(user, new Feedback(new Exception("cute")));
        assertTrue(sendRan);
    }
}
