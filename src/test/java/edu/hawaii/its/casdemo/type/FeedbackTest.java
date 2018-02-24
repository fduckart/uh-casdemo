package edu.hawaii.its.casdemo.type;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FeedbackTest {

    private Feedback feedback;

    @Before
    public void setUp() {
        feedback = new Feedback();
    }

    @Test
    public void construction() {
        assertNotNull(feedback);
    }

    @Test
    public void accessors() {
        assertNotNull(feedback);
        assertNull(feedback.getEmail());
        assertNull(feedback.getMessage());
        assertFalse(feedback.isCool());

        feedback.setEmail("u@v");
        feedback.setMessage("The Beast");
        feedback.setCool(true);
        assertThat(feedback.getEmail(), equalTo("u@v"));
        assertThat(feedback.getMessage(), equalTo("The Beast"));
        assertThat(feedback.isCool(), equalTo(true));

        assertThat(feedback.getException(), equalTo(null));
        feedback.setException(new Throwable("Mueller"));
        assertThat(feedback.getException(), not(equalTo(null)));
        assertThat(feedback.getExceptionStr(),
                containsString("java.lang.Throwable: Mueller"));

        feedback.setExceptionStr(null);
        assertThat(feedback.getExceptionStr(), equalTo(null));
        feedback.setExceptionStr("George Orwell");
        assertThat(feedback.getExceptionStr(), equalTo("George Orwell"));

        feedback.setException(null);
        assertThat(feedback.getException(), equalTo(null));
        assertThat(feedback.getExceptionStr(), equalTo(null));
    }

    @Test
    public void testToString() {
        assertThat(feedback.toString(), containsString("email=null, message=null"));

        feedback.setEmail("s@t");
        assertThat(feedback.toString(), containsString("Feedback [email=s@t,"));

        feedback.setMessage("live");
        assertThat(feedback.toString(), containsString("email=s@t, message=live"));
    }
}
