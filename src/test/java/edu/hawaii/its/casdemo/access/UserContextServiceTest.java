package edu.hawaii.its.casdemo.access;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.controller.WithMockUhUser;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class UserContextServiceTest {

    @Autowired
    private UserContextService userContextService;

    @Test
    @WithMockUhUser(username = "admin", roles = { "ROLE_ADMIN" })
    public void basics() {
        assertThat(userContextService.getCurrentUhuuid(), equalTo("12345678"));
        assertThat(userContextService.getCurrentUsername(), equalTo("admin"));
        assertThat(userContextService.toString(), startsWith("UserContextServiceImpl"));

        User user = userContextService.getCurrentUser();
        assertNotNull(user);
        assertThat(user.getUhuuid(), equalTo("12345678"));
        assertThat(user.getUsername(), equalTo("admin"));
        assertTrue(user.hasRole(Role.ADMIN));

        userContextService.setCurrentUhuuid("87654321");
        assertThat(userContextService.getCurrentUhuuid(), equalTo("87654321"));
    }

    @Test
    @WithMockUhUser
    public void nonAdminCannotChangeUhuuid() {
        assertThat(userContextService.getCurrentUhuuid(), equalTo("12345678"));
        assertThat(userContextService.getCurrentUsername(), equalTo("user"));

        User user = userContextService.getCurrentUser();
        assertNotNull(user);
        assertThat(user.getUhuuid(), equalTo("12345678"));
        assertThat(user.getUsername(), equalTo("user"));
        assertFalse(user.hasRole(Role.ADMIN));

        // UhUuid should not change.
        userContextService.setCurrentUhuuid("87654321");
        assertThat(userContextService.getCurrentUhuuid(), equalTo("12345678"));
    }

    @Test
    @WithAnonymousUser
    public void anonymousUser() {
        User user = userContextService.getCurrentUser();
        assertNotNull(user);
        assertThat(user.getUhuuid(), equalTo(""));
        assertThat(user.getUsername(), equalTo("anonymous"));
        assertTrue(user.hasRole(Role.ANONYMOUS));
        assertFalse(user.hasRole(Role.USER));
    }

    @Test
    public void nonUser() {
        User user = userContextService.getCurrentUser();
        assertNotNull(user);
        assertThat(user.getUhuuid(), equalTo(""));
        assertThat(user.getUsername(), equalTo("anonymous"));
        assertThat(user.getAuthorities().size(), equalTo(1));
        assertTrue(user.hasRole(Role.ANONYMOUS));
    }
}
