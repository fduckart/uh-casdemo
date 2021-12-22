package edu.hawaii.its.casdemo.access;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnonymousUserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new AnonymousUser();
    }

    @Test
    public void testConstructions() {
        assertNotNull(user);
        assertEquals("anonymous", user.getUsername());
        assertEquals("anonymous", user.getUid());
        assertThat(user.getUhuuid(), equalTo(""));
        assertEquals("", user.getPassword());
        assertEquals(1, user.getAuthorities().size());
        assertTrue(user.hasRole(Role.ANONYMOUS));
    }
}
