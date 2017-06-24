package edu.hawaii.its.casdemo.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.type.Holiday;
import edu.hawaii.its.casdemo.type.Type;
import edu.hawaii.its.casdemo.util.Dates;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class HolidayServiceTest {

    @Autowired
    private HolidayService holidayService;

    @Test
    public void findHolidays() {
        List<Holiday> holidays = holidayService.findHolidays();
        int size = holidays.size();
        assertTrue(size > 0);
        int index = size - 1;

        Holiday h0 = holidays.get(index);
        assertNotNull(h0);
        Holiday h1 = holidayService.findHoliday(h0.getId());
        assertEquals(h0.getId(), h1.getId());
        assertEquals(h0, h1);

        // Check that the caching is working.
        Holiday h2 = holidayService.findHolidays().get(index);
        Holiday h3 = holidayService.findHolidays().get(index);
        assertEquals(h2, h3);
        assertSame(h2, h3);

        assertThat(h2.getId(), equalTo(15));
        assertThat(h2.getDescription(), equalTo("New Year's Day"));
    }

    @Test
    public void findTypeById() {
        Type t0 = holidayService.findType(1);
        Type t1 = holidayService.findType(1);
        assertThat(t0.getId(), equalTo(1));
        assertThat(t1.getId(), equalTo(1));
        assertEquals(t0, t1);
        assertSame(t0, t1); // Check if caching is working.
    }

    @Test
    public void findTypes() {
        List<Type> types = holidayService.findTypes();

        Type ht = types.get(0);
        assertThat(ht.getId(), equalTo(1));
        assertThat(ht.getDescription(), equalTo("Bank"));

        ht = types.get(1);
        assertThat(ht.getId(), equalTo(2));
        assertThat(ht.getDescription(), equalTo("Federal"));

        ht = types.get(2);
        assertThat(ht.getId(), equalTo(3));
        assertThat(ht.getDescription(), equalTo("State"));

        ht = types.get(3);
        assertThat(ht.getId(), equalTo(4));
        assertThat(ht.getDescription(), equalTo("UH"));
    }

    @Test
    public void dateFormatting() throws Exception {
        final String DATE_FORMAT = Dates.DATE_FORMAT;

        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone("HST"));

        String toParse = "December 20, 2014, Saturday";
        Date obsDate = df.parse(toParse);
        assertNotNull(obsDate);

        LocalDate localDate = Dates.newLocalDate(2014, Month.DECEMBER, 20);
        obsDate = Dates.toDate(localDate);
        Date offDate = Dates.toDate(localDate.plusDays(200));

        Holiday holiday = new Holiday();
        holiday.setObservedDate(obsDate);
        holiday.setOfficialDate(offDate);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(holiday);
        assertThat(result, containsString(toParse));
    }

    @Test
    public void findHolidayById() {
        Holiday h1 = holidayService.findHoliday(1);

        assertEquals("New Year's Day", h1.getDescription());

        Holiday h2 = holidayService.findHoliday(2);
        assertEquals("Martin Luther King Jr. Day", h2.getDescription());

        Holiday h4 = holidayService.findHoliday(4);
        assertEquals("Prince Kuhio Day", h4.getDescription());

        assertEquals(3, h1.getHolidayTypes().size());
        assertEquals(3, h2.getHolidayTypes().size());
        assertEquals(2, h4.getHolidayTypes().size());

        List<Type> types = h1.getHolidayTypes();
        assertThat(types.get(0).getId(), equalTo(1));
        assertThat(types.get(1).getId(), equalTo(2));
        assertThat(types.get(2).getId(), equalTo(3));

        types = h2.getHolidayTypes();
        assertThat(types.get(0).getId(), equalTo(1));
        assertThat(types.get(1).getId(), equalTo(2));
        assertThat(types.get(2).getId(), equalTo(3));

        types = h4.getHolidayTypes();
        assertThat(types.get(0).getId(), equalTo(3));
        assertThat(types.get(1).getId(), equalTo(4));
    }
}
