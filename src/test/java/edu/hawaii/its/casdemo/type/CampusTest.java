package edu.hawaii.its.casdemo.type;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CampusTest {

    private Campus campus;

    @Before
    public void setUp() {
        campus = new Campus();
    }

    @Test
    public void construction() {
        assertNotNull(campus);
    }

    @Test
    public void accessors() {
        assertNull(campus.getId());
        assertNull(campus.getCode());
        assertNull(campus.getDescription());

        campus.setId(666);
        campus.setCode("TB");
        assertThat(campus.getId(), equalTo(666));
        assertThat(campus.getCode(), equalTo("TB"));

        campus.setDescription(null);
        assertThat(campus.getDescription(), equalTo(""));
        campus.setDescription("");
        assertThat(campus.getDescription(), equalTo(""));
        campus.setDescription("  ");
        assertThat(campus.getDescription(), equalTo("  "));
        campus.setDescription("The Beast");
        assertThat(campus.getDescription(), equalTo("The Beast"));
    }

    @Test
    public void testHashCode() {
        Campus c1 = new Campus();
        Campus c2 = new Campus();
        assertThat(c1.hashCode(), equalTo(c2.hashCode()));

        c1.setId(1);
        c2.setId(1);
        assertThat(c1.hashCode(), equalTo(c2.hashCode()));

        c1.setActual("actual");
        c2.setActual("actual");
        assertThat(c1.hashCode(), equalTo(c2.hashCode()));

        c1.setCode("code");
        c2.setCode("code");
        assertThat(c1.hashCode(), equalTo(c2.hashCode()));

        c1.setDescription("description");
        c2.setDescription("description");
        assertThat(c1.hashCode(), equalTo(c2.hashCode()));
    }

    @Test
    public void testEquals() {
        Campus c1 = new Campus();
        assertEquals(c1, c1); // To self.
        assertTrue(c1.equals(c1)); // To self.
        assertFalse(c1.equals(null));
        assertFalse(c1.equals(new String())); // Wrong type.

        Campus c2 = new Campus();
        assertThat(c1, equalTo(c2));
        assertThat(c2, equalTo(c1));
        c1.setId(3);
        assertThat(c1, not(equalTo(c2)));
        assertThat(c2, not(equalTo(c1)));
        c2.setId(3);
        assertThat(c1, equalTo(c2));
        assertThat(c2, equalTo(c1));
        c1.setActual("actual");
        assertThat(c1, not(equalTo(c2)));
        assertThat(c2, not(equalTo(c1)));
        c2.setActual("actual");
        assertThat(c1, equalTo(c2));
        assertThat(c2, equalTo(c1));
        c1.setCode("code");
        assertThat(c1, not(equalTo(c2)));
        assertThat(c2, not(equalTo(c1)));
        c2.setCode("code");
        assertThat(c1, equalTo(c2));
        assertThat(c2, equalTo(c1));
        c1.setDescription("description");
        assertThat(c1, not(equalTo(c2)));
        assertThat(c2, not(equalTo(c1)));
        c2.setDescription("description");
        assertThat(c1, equalTo(c2));
        assertThat(c2, equalTo(c1));
    }

    @Test
    public void testToString() {
        assertThat(campus.toString(), containsString("code=null, description=null"));

        campus.setCode("EX");
        assertThat(campus.toString(), containsString("Campus [id=null, code=EX,"));
    }
}
