package edu.hawaii.its.casdemo.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class StringsTest {

    @Test
    public void fill() {
        String s = Strings.fill('$', 6);
        assertThat(s, equalTo("$$$$$$"));
    }

    @Test
    public void isBlank() {
        assertTrue(Strings.isBlank(null));
        assertTrue(Strings.isBlank(""));
        assertTrue(Strings.isBlank(" "));
        assertTrue(Strings.isBlank("\t"));
        assertTrue(Strings.isBlank("\r"));
        assertFalse(Strings.isBlank("t"));
        assertFalse(Strings.isBlank("test"));
        assertFalse(Strings.isBlank(" test "));

        assertTrue(Strings.isBlank(new StringBuilder()));
        assertTrue(Strings.isBlank(new StringBuilder("")));
        assertTrue(Strings.isBlank(new StringBuilder(" ")));
        assertTrue(Strings.isBlank(new StringBuilder("\t")));
        assertTrue(Strings.isBlank(new StringBuilder("\r")));
        assertFalse(Strings.isBlank(new StringBuilder("t")));
        assertFalse(Strings.isBlank(new StringBuilder("test")));
        assertFalse(Strings.isBlank(new StringBuilder(" test ")));
    }

    @Test
    public void isNotBlank() {
        assertTrue(Strings.isNotBlank("t"));
        assertTrue(Strings.isNotBlank("test"));
        assertTrue(Strings.isNotBlank(" test "));
        assertFalse(Strings.isNotBlank(""));
        assertFalse(Strings.isNotBlank(" "));
        assertFalse(Strings.isNotBlank(null));
    }

    @Test
    public void isEmpty() {
        assertTrue(Strings.isEmpty(null));
        assertTrue(Strings.isEmpty(""));
        assertFalse(Strings.isEmpty(" "));
        assertFalse(Strings.isEmpty("\t"));
        assertFalse(Strings.isEmpty("\r"));
        assertFalse(Strings.isEmpty("t"));
        assertFalse(Strings.isEmpty("test"));
        assertFalse(Strings.isEmpty(" test "));

        assertTrue(Strings.isEmpty(new StringBuilder()));
        assertTrue(Strings.isEmpty(new StringBuilder("")));
        assertFalse(Strings.isEmpty(new StringBuilder(" ")));
        assertFalse(Strings.isEmpty(new StringBuilder("\t")));
        assertFalse(Strings.isEmpty(new StringBuilder("\r")));
        assertFalse(Strings.isEmpty(new StringBuilder("t")));
        assertFalse(Strings.isEmpty(new StringBuilder("test")));
        assertFalse(Strings.isEmpty(new StringBuilder(" test ")));

        // Just for comparison with what Java does:
        assertTrue("".isEmpty()); // comparison
        assertFalse(" ".isEmpty()); // comparison
        assertFalse("\t".isEmpty()); // comparison
        assertFalse("\r".isEmpty()); // comparison
        assertFalse("t".isEmpty()); // comparison
        assertFalse("test".isEmpty()); // comparison
        assertFalse(" test ".isEmpty()); // comparison

        // Works the same as Apache commons:
        assertTrue(Strings.isEmpty(null));
        assertTrue(Strings.isEmpty(""));
        assertFalse(Strings.isEmpty(" "));
        assertFalse(Strings.isEmpty("bob"));
        assertFalse(Strings.isEmpty("  bob  "));
    }

    @Test
    public void isNotEmpty() {
        assertFalse(Strings.isNotEmpty(null));
        assertFalse(Strings.isNotEmpty(""));
        assertTrue(Strings.isNotEmpty(" "));
        assertTrue(Strings.isNotEmpty("\t"));
        assertTrue(Strings.isNotEmpty("\r"));
        assertTrue(Strings.isNotEmpty("t"));
        assertTrue(Strings.isNotEmpty("test"));
        assertTrue(Strings.isNotEmpty(" test "));

        assertFalse(Strings.isNotEmpty(new String()));
        assertFalse(Strings.isNotEmpty(new String("")));
        assertTrue(Strings.isNotEmpty(new String(" ")));
        assertTrue(Strings.isNotEmpty(new String("\t")));
        assertTrue(Strings.isNotEmpty(new String("\r")));
        assertTrue(Strings.isNotEmpty(new String("t")));
        assertTrue(Strings.isNotEmpty(new String("test")));
        assertTrue(Strings.isNotEmpty(new String(" test ")));
    }

    @Test
    public void trunctate() {
        String s = "abcdefghijk";
        assertThat(Strings.truncate(s, 3), equalTo("abc"));
        assertThat(Strings.truncate(s, 2), equalTo("ab"));
        assertThat(Strings.truncate(s, 1), equalTo("a"));
        assertThat(Strings.truncate(s, 0), equalTo(""));
        assertThat(Strings.truncate(s, 11), equalTo(s));
        assertThat(Strings.truncate(s, 12), equalTo(s));

        assertNull(Strings.truncate(null, 0));
        assertNull(Strings.truncate(null, 1));

        // Note this result:
        try {
            Strings.truncate(s, -1);
            fail("Should not reach here.");
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }

    @Test
    public void padLeft() {
        String s = Strings.padLeft(null, 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("     "));

        s = Strings.padLeft("1", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("    1"));

        s = Strings.padLeft("12", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("   12"));

        s = Strings.padLeft("123", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("  123"));

        s = Strings.padLeft("1234", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo(" 1234"));

        s = Strings.padLeft("12345", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("12345"));

        // Note.
        s = Strings.padLeft("123456", 5);
        assertThat(s.length(), equalTo(6));
        assertThat(s, equalTo("123456"));
    }

    @Test
    public void padRight() {
        String s = Strings.padRight(null, 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("     "));

        s = Strings.padRight("1", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("1    "));

        s = Strings.padRight("12", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("12   "));

        s = Strings.padRight("123", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("123  "));

        s = Strings.padRight("1234", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("1234 "));

        s = Strings.padRight("12345", 5);
        assertThat(s.length(), equalTo(5));
        assertThat(s, equalTo("12345"));

        // Note.
        s = Strings.padRight("123456", 5);
        assertThat(s.length(), equalTo(6));
        assertThat(s, equalTo("123456"));
    }

    @Test
    public void constructorIsPrivate() throws Exception {
        Constructor<Strings> constructor = Strings.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
