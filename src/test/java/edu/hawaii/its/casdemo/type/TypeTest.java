package edu.hawaii.its.casdemo.type;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TypeTest {

    private Type type;

    @BeforeEach
    public void setUp() {
        type = new Type();
    }

    @Test
    public void construction() {
        assertNotNull(type);
    }

    @Test
    public void accessors() {
        assertNotNull(type);
        assertNull(type.getId());
        assertNull(type.getDescription());

        type.setId(666);
        type.setDescription("The Beast");
        assertThat(type.getId(), equalTo(666));
        assertThat(type.getDescription(), equalTo("The Beast"));
    }

    @Test
    public void testToString() {
        assertThat(type.toString(), containsString("id=null, description=null"));

        type.setId(12345);
        assertThat(type.toString(), containsString("Type [id=12345,"));
    }
}
