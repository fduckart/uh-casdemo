package edu.hawaii.its.casdemo.access;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.AssertionImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class UserDetailsServiceTest {

    @Autowired
    private UserBuilder userBuilder;

    @Test
    public void testAdminUsers() {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", "duckart");
        map.put("uhuuid", "89999999");
        AttributePrincipal principal = new AttributePrincipalImpl("duckart", map);
        Assertion assertion = new AssertionImpl(principal);
        CasUserDetailsService userDetailsService = new CasUserDetailsService(userBuilder);
        User user = (User) userDetailsService.loadUserDetails(assertion);

        // Basics.
        assertEquals("duckart", user.getUsername());
        assertEquals("duckart", user.getUid());
        assertEquals("89999999", user.getUhuuid());

        // Granted Authorities.
        assertTrue(user.getAuthorities().size() > 0);
        assertFalse(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.USER));
        assertTrue(user.hasRole(Role.ADMIN));

        // Check a made-up junky role name.

        map = new HashMap<>();
        map.put("uid", "someuser");
        map.put("uhuuid", "10000001");
        principal = new AttributePrincipalImpl("someuser", map);
        assertion = new AssertionImpl(principal);
        user = (User) userDetailsService.loadUserDetails(assertion);

        assertEquals("someuser", user.getUsername());
        assertEquals("someuser", user.getUid());
        assertEquals("10000001", user.getUhuuid());

        assertTrue(user.getAuthorities().size() > 0);
        assertFalse(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.USER));
        assertTrue(user.hasRole(Role.ADMIN));
        assertFalse(user.hasRole(Role.STAFF));
        assertFalse(user.hasRole(Role.FACULTY));
    }

    @Test
    public void testCoordinators() {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", "jjcale");
        map.put("uhuuid", "10000004");

        AttributePrincipal principal = new AttributePrincipalImpl("jjcale", map);
        Assertion assertion = new AssertionImpl(principal);
        CasUserDetailsService userDetailsService = new CasUserDetailsService(userBuilder);
        User user = (User) userDetailsService.loadUserDetails(assertion);

        // Basics.
        assertEquals("jjcale", user.getUsername());
        assertEquals("jjcale", user.getUid());
        assertEquals("10000004", user.getUhuuid());

        // Granted Authorities.
        assertEquals(2, user.getAuthorities().size());
        assertFalse(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.USER));
        assertTrue(user.hasRole(Role.ADMIN));
        assertFalse(user.hasRole(Role.STAFF));
        assertFalse(user.hasRole(Role.FACULTY));
    }

    @Test
    public void loadUserDetailsExceptionOne() {
        Assertion assertion = new AssertionDummy();
        CasUserDetailsService userDetailsService = new CasUserDetailsService(userBuilder);
        try {
            userDetailsService.loadUserDetails(assertion);
            fail("Should not have reached here.");
        } catch (Exception e) {
            assertEquals(e.getClass(), UsernameNotFoundException.class);
            assertThat(e.getMessage(), containsString("principal is null"));
        }
    }

    @Test
    public void testToString() {
        CasUserDetailsService userDetailsService = new CasUserDetailsService(userBuilder);
        assertThat(userDetailsService.toString(), startsWith("CasUserDetailsService"));
    }
}
