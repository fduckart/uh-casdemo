package edu.hawaii.its.casdemo.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import edu.hawaii.its.casdemo.util.Dates;

public class HolidayDateShortDeserializer extends StdDeserializer<LocalDate> {

    private static final long serialVersionUID = 159L;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern(Dates.DATE_FORMAT_SHORT);

    public HolidayDateShortDeserializer() {
        this(null);
    }

    public HolidayDateShortDeserializer(Class<LocalDate> t) {
        super(t);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException {
        String date = jsonparser.getText();
        return LocalDate.parse(date, format);
    }

}
