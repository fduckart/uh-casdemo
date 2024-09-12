package edu.hawaii.its.casdemo.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParser;

public class HolidayDateShortDeserializerTest {

    @Test
    public void deserialize() throws IOException {
        JsonParser jp = mock(JsonParser.class);
        when(jp.getText()).thenReturn("2023-06-17");

        HolidayDateShortDeserializer deserializer =
                new HolidayDateShortDeserializer();

        // What we are testing:
        LocalDate dateTime = deserializer.deserialize(jp, null);

        final LocalDate expected = LocalDate.now()
                .withYear(2023).withMonth(6).withDayOfMonth(17);

        assertThat(dateTime, equalTo(expected));
    }
}
