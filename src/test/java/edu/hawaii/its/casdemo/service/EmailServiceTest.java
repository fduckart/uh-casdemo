package edu.hawaii.its.casdemo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;

import edu.hawaii.its.casdemo.access.UhCasAttributes;
import edu.hawaii.its.casdemo.access.User;

public class EmailServiceTest {

    private EmailService emailService;
    private static boolean sendRan = false;

    @Test
    public void construction() {
        emailService = new EmailService(new JavaMailSenderDummy());
        assertNotNull(emailService);
        assertFalse(emailService.isEnabled());
    }

    @Test
    public void send() {
        JavaMailSender sender = new JavaMailSenderDummy();
        emailService = new EmailService(sender);

        assertFalse(emailService.isEnabled());

        // Test send.
        emailService.send(null);

        // Test send.
        emailService.setEnabled(true);
        emailService.send(null);

        Map<Object, Object> map = new HashMap<>();
        map.put("uid", "duckart");
        map.put("uhuuid", "666666");
        map.put("cn", "Frank");
        map.put("mail", "frank@example.com");
        map.put("eduPersonAffiliation", "aff");
        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        User user = new User("eno", authorities);
        user.setAttributes(new UhCasAttributes(map));

        // Test send.
        emailService.send(user);

        // Test send, but with an internal exception.
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
        emailService.send(user);
        assertTrue(sendRan);
    }
}
