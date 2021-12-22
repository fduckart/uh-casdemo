package edu.hawaii.its.casdemo.access;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserTest {

    @Test
    public void construction() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();

        User user = new User("a", authorities);
        assertNotNull(user);

        assertEquals("a", user.getUsername());
        assertEquals("a", user.getUid());
        assertThat(user.getUhuuid(), equalTo(""));
        assertNull(user.getAttributes());

        authorities = new LinkedHashSet<>();
        authorities.add(new SimpleGrantedAuthority(Role.ANONYMOUS.longName()));
        user = new User("b", "12345", authorities);

        assertEquals("b", user.getUsername());
        assertEquals("b", user.getUid());
        assertEquals("12345", user.getUhuuid());
        assertThat(user.getUhuuid(), equalTo("12345"));
        assertNull(user.getAttributes());

        user.setAttributes(new UhCasAttributes());
        assertThat(user.getName(), equalTo(""));
    }

    @Test
    public void accessors() {
        Map<Object, Object> map = new HashMap<>();
        map.put("uid", "duckart");
        map.put("uhuuid", "666666");
        map.put("cn", "Frank");
        map.put("mail", "frank@example.com");
        map.put("eduPersonAffiliation", "aff");

        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        User user = new User("a", authorities);
        user.setAttributes(new UhCasAttributes(map));

        assertThat(user.getAttribute("uid"), equalTo("duckart"));
        assertThat(user.getName(), equalTo("Frank"));
        assertThat(user.toString(), containsString("uid=a,"));
        assertThat(user.toString(), containsString("uhuuid=,"));
    }

    @Test
    public void testEquals() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();

        User u0 = new User("user0", "u0", authorities);
        assertTrue(u0.equals(u0));
        assertFalse(u0.equals(null));
        assertFalse(u0.equals(new String()));

        org.springframework.security.core.userdetails.User up =
                new org.springframework.security.core.userdetails.User("user0", "u0", authorities);
        assertFalse(u0.equals(up));

        User u1 = new User("user1", "u1", authorities);
        assertFalse(u0.equals(u1));

        User ua = new User("user0", "u0", authorities);
        assertTrue(u0.equals(ua));
        assertTrue(ua.equals(u0));

        User ub = new User("user0", "ub", authorities);
        assertFalse(u0.equals(ub));
        assertTrue(ua.equals(u0));
        ub = null;

        User uc = new User("user0", "ub", authorities);
        assertFalse(u0.equals(uc));
        assertFalse(uc.equals(u0));
        uc = null;

        User ud = new User("user0", null, authorities);
        assertTrue(u0.equals(ua));
        assertFalse(ud.equals(u0));
        u0.setUhuuid(null);
        assertTrue(ud.equals(u0));
        ud = null;
    }

    @Test
    public void testHashCode() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();

        User u1 = new User("a", "b", authorities);
        User c2 = new User("a", "b", authorities);
        assertThat(u1.hashCode(), equalTo(c2.hashCode()));

        u1.setUhuuid("u");
        c2.setUhuuid("u");
        assertThat(u1.hashCode(), equalTo(c2.hashCode()));
    }

}
