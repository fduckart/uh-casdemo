package edu.hawaii.its.casdemo.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.hawaii.its.casdemo.util.Dates;

public class HolidayTest {

    private Holiday holiday;

    @BeforeEach
    public void setUp() {
        holiday = new Holiday();
    }

    @Test
    public void construction() {
        assertNotNull(holiday);
    }

    @Test
    public void setters() {
        assertNotNull(holiday);
        assertNull(holiday.getId());
        assertNull(holiday.getDescription());
        assertNull(holiday.getVersion());
        assertNotNull(holiday.getTypes());

        holiday.setId(666);
        holiday.setDescription("The Beast");
        holiday.setVersion(9);
        assertThat(holiday.getId(), equalTo(666));
        assertThat(holiday.getDescription(), equalTo("The Beast"));
        assertThat(holiday.getVersion(), equalTo(9));

        assertThat(holiday.getTypes().size(), equalTo(0));
        holiday.setTypes(null);
        assertNotNull(holiday.getTypes());
        assertThat(holiday.getTypes().size(), equalTo(0));
        holiday.setTypes(new ArrayList<Type>());
        assertThat(holiday.getTypes().size(), equalTo(0));

        assertNull(holiday.getObservedDate());
        assertNull(holiday.getYear());
        assertNull(holiday.getOfficialYear());

        LocalDate xmas = Dates.newLocalDate(2016, Month.DECEMBER, 25);
        holiday.setObservedDate(xmas);
        assertThat(holiday.getYear(), is(notNullValue()));
        assertThat(holiday.getYear().intValue(), equalTo(2016));
        assertNull(holiday.getOfficialDate());

        LocalDate xmasPlusOne = xmas.plusDays(1);
        assertThat(xmasPlusOne, not(equalTo(xmas)));
        holiday = new Holiday(xmas, xmasPlusOne, xmasPlusOne.getYear());
        // holiday.setOfficialDate(xmas);
        // holiday.setObservedDate(xmasPlusOne);
        assertThat(holiday.getOfficialDateStr(), equalTo("2016-12-25"));
        assertThat(holiday.getObservedDateStr(), equalTo("2016-12-26"));
        assertThat(holiday.getObservedDate().toEpochDay(), equalTo(17161L));
        assertThat(holiday.getOfficialYear().intValue(), equalTo(2016));
        holiday.setOfficialYear(2024);
        assertThat(holiday.getOfficialYear().intValue(), equalTo(2024));
    }

    @Test
    public void testHashCode() {
        Holiday h1 = new Holiday();
        Holiday h2 = new Holiday();
        assertThat(h1.hashCode(), equalTo(h2.hashCode()));

        LocalDate ld1 = Dates.newLocalDate(2016, Month.DECEMBER, 25);
        h1 = new Holiday();
        h1.setOfficialDate(ld1);
        h1.setObservedDate(ld1);

        h1.setId(1);
        h1.setVersion(1);
        h1.setDescription("Xmas 2016");

        LocalDate ld2 = Dates.newLocalDate(2016, Month.DECEMBER, 26);
        h2 = new Holiday();
        h2.setOfficialDate(ld1);
        h2.setObservedDate(ld2);
        h2.setId(1);
        h2.setVersion(1);
        h2.setDescription("Xmas 2016");

        assertThat(h1.hashCode(), not(equalTo(h2.hashCode())));
    }

    @Test
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        Holiday h1 = new Holiday();
        assertEquals(h1, h1); // To self.
        assertTrue(h1.equals(h1)); // To self.
        assertFalse(h1.equals(null));
        assertFalse(h1.equals(new Date())); // Wrong type.

        Holiday h2 = new Holiday();
        assertThat(h1, equalTo(h2));

        LocalDate ld1 = Dates.newLocalDate(2016, Month.DECEMBER, 25);
        h1 = new Holiday();
        h1.setOfficialDate(ld1);
        h1.setObservedDate(ld1);
        assertThat(h1, not(equalTo(h2)));

        LocalDate ld2 = Dates.newLocalDate(2016, Month.DECEMBER, 25);
        h2 = new Holiday();
        h2.setOfficialDate(ld1);
        h2.setObservedDate(ld1);
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

        // Version not in equals contract.
        h1.setVersion(1);
        assertThat(h1, equalTo(h2));
        h2.setVersion(1);
        assertThat(h1, equalTo(h2));

        h1.setDescription("Xmas 2016");
        assertThat(h1, not(equalTo(h2)));
        h2.setDescription("Xmas 2016");
        assertThat(h1, equalTo(h2));
        h1.setDescription(null);
        assertThat(h1, not(equalTo(h2)));
        h2.setDescription(null);
        assertThat(h1, equalTo(h2));
        h1.setDescription("Xmas 2016");
        h2.setDescription("Xmas 2016");
        assertThat(h1, equalTo(h2));

        h1.setObservedDate(null);
        assertThat(h1, not(equalTo(h2)));
        h2.setObservedDate(null);
        assertThat(h1, equalTo(h2));
        h1.setObservedDate(ld1);
        h2.setObservedDate(ld2);
        assertThat(h1, equalTo(h2));

        h1.setOfficialDate(null);
        assertThat(h1, not(equalTo(h2)));
        h2.setOfficialDate(null);
        assertThat(h1, equalTo(h2));
        h1.setOfficialDate(ld1);
        h2.setOfficialDate(ld2);
        assertThat(h1, equalTo(h2));

        LocalDate ld3 = Dates.newLocalDate(2016, Month.DECEMBER, 26);
        h2.setOfficialDate(ld3);
        assertThat(h1, not(equalTo(h2)));
    }

    @Test
    public void addType() {
        Type type = new Type();
        type.setId(1);
        type.setDescription("test-type");
        type.setVersion(22);
        Holiday holiday = new Holiday();
        assertThat(holiday.getTypes().size(), equalTo(0));
        holiday.addType(type);
        assertThat(holiday.getTypes().size(), equalTo(1));
        Type t = holiday.getTypes().get(0);
        assertThat(t.getId(), equalTo(1));
        assertThat(t.getDescription(), equalTo("test-type"));
        assertThat(t.getVersion(), equalTo(22));
        assertThat(t.getSortId(), equalTo(null));
    }

    @Test
    public void testToString() {
        assertThat(holiday.toString(), containsString("id=null, description=null"));

        holiday.setId(12345);
        assertThat(holiday.toString(), containsString("Holiday [id=12345,"));
    }
}
