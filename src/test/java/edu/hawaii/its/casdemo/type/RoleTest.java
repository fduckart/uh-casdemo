package edu.hawaii.its.casdemo.type;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void accessors() {
        Role r1 = new Role();
        r1.setId(5);
        Role r2 = new Role();
        r2.setId(5);
        assertThat(r1, equalTo(r2));
        assertThat(r1.getId(), equalTo(5));
        assertThat(r1.getId(), equalTo(r2.getId()));
        assertThat(r1.hashCode(), equalTo(r2.hashCode()));

        r1.setRole("role");
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
        r2.setRole("role");
        assertThat(r1, equalTo(r2));
        assertThat(r1.hashCode(), equalTo(r2.hashCode()));

        r1.setDescription("description");
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
        r2.setDescription("description");
        assertThat(r1, equalTo(r2));
        assertThat(r1.hashCode(), equalTo(r2.hashCode()));

        r1.setShortDescription("shortDescription");
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
        r2.setShortDescription("shortDescription");
        assertThat(r1, equalTo(r2));
        assertThat(r2, equalTo(r1));
        assertThat(r1.hashCode(), equalTo(r2.hashCode()));

        r1.setShortDescription(null);
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
        r2.setShortDescription(null);
        assertThat(r1, equalTo(r2));
        assertThat(r2, equalTo(r1));

        r1.setDescription(null);
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
        r2.setDescription(null);
        assertThat(r1, equalTo(r2));
        assertThat(r2, equalTo(r1));

        r1.setRole(null);
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
        r2.setRole(null);
        assertThat(r1, equalTo(r2));
        assertThat(r2, equalTo(r1));

        r1.setId(null);
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
        r2.setId(null);
        assertThat(r1, equalTo(r2));
        assertThat(r2, equalTo(r1));
        r2.setId(2);
        assertThat(r1, not(equalTo(r2)));
        assertThat(r2, not(equalTo(r1)));
    }

    @Test
    public void testHashCode() {
        Role r1 = new Role();
        Role r2 = new Role();
        assertThat(r1.hashCode(), equalTo(r2.hashCode()));
    }

    @Test
    public void testEquals() {
        Role r1 = new Role();
        assertEquals(r1, r1); // To self.
        assertTrue(r1.equals(r1)); // To self.
        assertFalse(r1.equals(null));
        assertFalse(r1.equals(new String())); // Wrong type.

        Role r2 = new Role();
        assertThat(r1, equalTo(r2));
    }

    @Test
    public void testToString() {
        Role role = new Role();
        assertThat(role.toString(), containsString("role=null, description=null"));
        role.setId(123);
        assertThat(role.toString(), containsString("Role [id=123,"));
    }

}
