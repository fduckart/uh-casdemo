package edu.hawaii.its.casdemo.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class SecurityConfigTest {

    @Autowired
    private SecurityConfig securityConfig;

    @Test
    public void construction() {
        assertNotNull(securityConfig);

        SecurityContextLogoutHandler logoutHandler = securityConfig.securityContextLogoutHandler();
        assertNotNull(logoutHandler);
        assertTrue(logoutHandler.isInvalidateHttpSession());

        LogoutFilter logoutFilter = securityConfig.logoutFilter();
        assertNotNull(logoutFilter);
    }

}
