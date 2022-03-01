package edu.hawaii.its.casdemo.access;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserTest {

    @Test
    public void construction() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();

        User user = new User.Builder()
                .username("a")
                .authorities(authorities)
                .create();
        assertNotNull(user);

        assertEquals("a", user.getUsername());
        assertEquals("a", user.getUid());
        assertThat(user.getUhuuid(), equalTo(""));
        assertNotNull(user.getAttributes());

        authorities = new LinkedHashSet<>();
        authorities.add(new SimpleGrantedAuthority(Role.ANONYMOUS.longName()));
        user = new User.Builder()
                .username("b")
                .uhuuid("12345")
                .authorities(authorities)
                .create();

        assertEquals("b", user.getUsername());
        assertEquals("b", user.getUid());
        assertEquals("12345", user.getUhuuid());
        assertThat(user.getUhuuid(), equalTo("12345"));
        assertNotNull(user.getAttributes());

        user = new User.Builder()
                .username("a")
                .authorities(authorities)
                .attributes(new UhCasAttributes())
                .create();
        assertThat(user.getName(), equalTo(""));
    }

    @Test
    public void accessors() {
        Map<Object, Object> map = new HashMap<>();
        map.put("uid", "duckart");
        map.put("uhuuid", "666666");
        map.put("displayName", "Frank");
        map.put("cn", "Rick");
        map.put("mail", Arrays.asList("frank@ex.com", "duckart@ex.com"));

        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        User user = new User.Builder()
                .username("a")
                .authorities(authorities)
                .attributes(new UhCasAttributes(map))
                .create();
        assertThat(user.getAttribute("uid"), equalTo("duckart"));
        assertThat(user.getName(), equalTo("Frank"));
        assertThat(user.getAttribute("cn"), equalTo("Rick"));
        assertThat(user.toString(), containsString("uid=a,"));
        assertThat(user.toString(), containsString("uhuuid=,"));

        // Multivalued attribute.
        List<String> mails = user.getAttributes("mail");
        assertThat(mails.size(), equalTo(2));
        assertThat(mails, hasItem("duckart@ex.com"));
        assertThat(mails, hasItem("frank@ex.com"));

        // Make sure the multivalued list is immmutable.
        try {
            mails.add("what?");
            fail("Should not reach here.");
        } catch (Exception e) {
            assertThat(e, instanceOf(UnsupportedOperationException.class));
        }
    }

    @Test
    public void testEquals() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();

        User u0 = new User.Builder()
                .username("user0")
                .uhuuid("u0")
                .authorities(authorities)
                .create();
        assertTrue(u0.equals(u0));
        assertFalse(u0.equals(null));
        assertFalse(u0.equals(new String()));

        org.springframework.security.core.userdetails.User up =
                new org.springframework.security.core.userdetails.User("user0", "u0", authorities);
        assertFalse(u0.equals(up));

        User u1 = new User.Builder()
                .username("user1")
                .uhuuid("u0")
                .authorities(authorities)
                .create();
        assertFalse(u0.equals(u1));

        User ua = new User.Builder()
                .username("user0")
                .uhuuid("u0")
                .authorities(authorities)
                .create();
        assertTrue(u0.equals(ua));
        assertTrue(ua.equals(u0));

        User ub = new User.Builder()
                .username("user0")
                .uhuuid("ub")
                .authorities(authorities)
                .create();
        assertFalse(u0.equals(ub));
        assertTrue(ua.equals(u0));
        ub = null;

        User uc = new User.Builder()
                .username("user0")
                .uhuuid("ub")
                .authorities(authorities)
                .create();
        assertFalse(u0.equals(uc));
        assertFalse(uc.equals(u0));
        uc = null;

        User ud = new User.Builder()
                .username("user0")
                .uhuuid(null)
                .authorities(authorities)
                .create();
        assertTrue(u0.equals(ua));
        assertFalse(ud.equals(u0));
        u0 = new User.Builder()
                .username("user0")
                .uhuuid(null)
                .authorities(authorities)
                .create();
        assertTrue(ud.equals(u0));
        ud = null;
    }

    @Test
    public void testHashCode() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();

        User u1 = new User.Builder()
                .username("a")
                .uhuuid("b")
                .authorities(authorities)
                .create();
        User c2 = new User.Builder()
                .username("a")
                .uhuuid("b")
                .authorities(authorities)
                .create();
        assertThat(u1.hashCode(), equalTo(c2.hashCode()));

        c2 = new User.Builder()
                .username("a")
                .uhuuid("u")
                .authorities(authorities)
                .create();
        assertThat(u1.hashCode(), not(equalTo(c2.hashCode())));

        u1 = new User.Builder()
                .username("a")
                .uhuuid("u")
                .authorities(authorities)
                .create();
        assertThat(u1.hashCode(), equalTo(c2.hashCode()));
    }

}
