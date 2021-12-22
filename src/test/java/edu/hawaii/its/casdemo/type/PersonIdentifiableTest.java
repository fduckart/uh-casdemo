package edu.hawaii.its.casdemo.type;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class PersonIdentifiableTest {

    @Test
    public void defaults() {
        PersonIdentifiable pi = new PersonIdentifiable() {
            // Empty.
        };

        assertThat(pi.getUhUuid(), equalTo(""));
    }
}
