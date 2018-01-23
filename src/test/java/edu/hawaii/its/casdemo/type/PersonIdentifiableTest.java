package edu.hawaii.its.casdemo.type;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonIdentifiableTest {

    @Test
    public void defaults() {
        PersonIdentifiable pi = new PersonIdentifiable() {
            // Empty.
        };

        assertThat(pi.getUhUuid(), equalTo(""));
    }
}
