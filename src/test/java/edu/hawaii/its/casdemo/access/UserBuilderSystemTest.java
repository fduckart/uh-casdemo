package edu.hawaii.its.casdemo.access;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.hawaii.its.casdemo.configuration.CachingConfig;
import edu.hawaii.its.casdemo.configuration.DatabaseConfig;
import edu.hawaii.its.casdemo.configuration.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class, WebConfig.class, CachingConfig.class })
public class UserBuilderSystemTest {

    @Autowired
    private UserBuilder userBuilder;

    @Test
    public void testAdminUsers() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", "duckart");
        map.put("uhuuid", "89999999");
        User user = userBuilder.make(map);

        // Basics.
        assertEquals("duckart", user.getUsername());
        assertEquals("duckart", user.getUid());
        assertEquals(Long.valueOf(89999999), user.getUhuuid());

        // Granted Authorities.
        assertTrue(user.getAuthorities().size() > 0);
        assertTrue(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.UH));
        assertTrue(user.hasRole(Role.EMPLOYEE));
        assertTrue(user.hasRole(Role.ADMIN));

        map = new HashMap<String, String>();
        map.put("uid", "someuser");
        map.put("uhuuid", "10000001");
        user = userBuilder.make(map);

        assertEquals("someuser", user.getUsername());
        assertEquals("someuser", user.getUid());
        assertEquals(Long.valueOf(10000001), user.getUhuuid());

        assertTrue(user.getAuthorities().size() > 0);
        assertTrue(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.UH));
        assertTrue(user.hasRole(Role.EMPLOYEE));
        assertTrue(user.hasRole(Role.ADMIN));
    }

    @Test
    public void testEmployees() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", "jjcale");
        map.put("uhuuid", "10000004");
        User user = userBuilder.make(map);

        // Basics.
        assertEquals("jjcale", user.getUsername());
        assertEquals("jjcale", user.getUid());
        assertEquals(Long.valueOf(10000004), user.getUhuuid());

        // Granted Authorities.
        assertEquals(3, user.getAuthorities().size());
        assertTrue(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.UH));
        assertTrue(user.hasRole(Role.EMPLOYEE));

        assertFalse(user.hasRole(Role.ADMIN));
    }

    @Test
    public void testEmployeesWithMultivalueUid() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<Object> uids = new ArrayList<Object>();
        uids.add("aaaaaaa");
        uids.add("bbbbbbb");
        map.put("uid", uids);
        map.put("uhuuid", "10000003");
        User user = userBuilder.make(map);

        // Basics.
        assertEquals("aaaaaaa", user.getUsername());
        assertEquals("aaaaaaa", user.getUid());
        assertEquals(Long.valueOf(10000003), user.getUhuuid());

        // Granted Authorities.
        assertEquals(4, user.getAuthorities().size());
        assertTrue(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.UH));
        assertTrue(user.hasRole(Role.EMPLOYEE));
        assertTrue(user.hasRole(Role.ADMIN));
    }

    @Test
    public void testNotAnEmployee() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("uid", "nobody");
        map.put("uhuuid", "10000009");
        User user = userBuilder.make(map);

        // Basics.
        assertEquals("nobody", user.getUsername());
        assertEquals("nobody", user.getUid());
        assertEquals(Long.valueOf(10000009), user.getUhuuid());

        // Granted Authorities.
        assertEquals(2, user.getAuthorities().size());
        assertTrue(user.hasRole(Role.ANONYMOUS));
        assertTrue(user.hasRole(Role.UH));
        assertFalse(user.hasRole(Role.EMPLOYEE));
        assertFalse(user.hasRole(Role.ADMIN));
    }
}
