package edu.hawaii.its.casdemo.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DesignationTest {

    private Designation designation;

    @BeforeEach
    public void setUp() {
        designation = new Designation();
    }

    @Test
    public void construction() {
        assertNotNull(designation);
    }

    @Test
    public void setters() {
        assertNotNull(designation);
        assertNull(designation.getId());
        assertNull(designation.getName());

        designation.setId(666);
        designation.setName("The Beast");
        assertThat(designation.getId(), equalTo(666));
        assertThat(designation.getName(), equalTo("The Beast"));
    }

    @Test
    public void testHashCode() {
        Designation h1 = new Designation();
        Designation h2 = new Designation();
        assertThat(h1.hashCode(), equalTo(h2.hashCode()));

        h1 = new Designation();
        h1.setId(1);
        h1.setName("Xmas 2016");

        h2 = new Designation();
        h2.setId(1);
        h2.setName(h1.getName() + " ");

        assertThat(h1.hashCode(), not(equalTo(h2.hashCode())));
    }

    @Test
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        Designation h1 = new Designation();
        assertEquals(h1, h1); // To self.
        assertEquals(h1, h1); // To self.
        assertTrue(h1.equals(h1));
        assertNotEquals(null, h1);
        assertFalse(h1.equals(null));
        assertNotEquals(h1, new Date()); // Wrong type.
        assertFalse(h1.equals(new Date())); // Wrong type.

        Designation h2 = new Designation();
        assertThat(h1, equalTo(h2));

        h1.setId(1);
        assertThat(h1, not(equalTo(h2)));
        h2.setId(1);
        assertThat(h1, equalTo(h2));
        h1.setId(null);
        assertThat(h1, not(equalTo(h2)));
        h2.setId(null);
        assertThat(h1, equalTo(h2));
        h1.setId(1);
        h2.setId(1);
        assertThat(h1, equalTo(h2));

        h1.setName("Xmas 2016");
        assertThat(h1, not(equalTo(h2)));
        h2.setName("Xmas 2016");
        assertThat(h1, equalTo(h2));
        h1.setName(null);
        assertThat(h1, not(equalTo(h2)));
        h2.setName(null);
        assertThat(h1, equalTo(h2));
        h1.setName("Xmas 2016");
        h2.setName("Xmas 2016");
        assertThat(h1, equalTo(h2));
    }

    @Test
    public void testToString() {
        assertThat(designation.toString(), containsString("id=null, name=null"));

        designation.setId(12345);
        assertThat(designation.toString(), containsString("Designation [id=12345,"));
    }
}
