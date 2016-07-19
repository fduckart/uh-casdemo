package edu.hawaii.its.casdemo.access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserTest {

    @Test
    public void construction() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();

        User user = new User("a", authorities);
        assertNotNull(user);

        assertEquals("a", user.getUsername());
        assertEquals("a", user.getUid());
        assertNull(user.getUhuuid());
        assertNull(user.getAttributes());

        authorities = new LinkedHashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(Role.ANONYMOUS.longName()));
        user = new User("b", 12345L, authorities);

        assertEquals("b", user.getUsername());
        assertEquals("b", user.getUid());
        assertEquals(Long.valueOf(12345), user.getUhuuid());
        assertNull(user.getAttributes());
    }
}
