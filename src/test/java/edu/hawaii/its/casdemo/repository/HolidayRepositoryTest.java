package edu.hawaii.its.casdemo.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.service.HolidayService;
import edu.hawaii.its.casdemo.type.Holiday;
import edu.hawaii.its.casdemo.type.Type;
import edu.hawaii.its.casdemo.util.Dates;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class HolidayRepositoryTest {

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private HolidayService holidayService;

    @Test
    public void findById() {
        Holiday h = holidayRepository.findById(115).get();
        assertThat(h.getDescription(), equalTo("Christmas"));
        assertThat(h.getHolidayTypes().size(), equalTo(2));
        LocalDate localDate = Dates.newLocalDate(2018, Month.DECEMBER, 25);
        Date date = Dates.toDate(localDate);
        assertThat(h.getObservedDate(), equalTo(date));
        assertThat(h.getOfficialDate(), equalTo(date));
    }

    @Test
    public void save() {
        Holiday h = new Holiday();

        LocalDate localDate = Dates.newLocalDate(2030, Month.DECEMBER, 25);
        Date date = Dates.toDate(localDate);

        h.setOfficialDate(date);
        h.setObservedDate(date);
        h.setDescription("Christmas");
        assertNull(h.getId());

        h = holidayRepository.save(h);

        assertNotNull(h.getId());
        Holiday h0 = holidayRepository.findById(h.getId()).get();
        assertEquals(h0, h);

        localDate = Dates.firstOfNextMonth(localDate);
        date = Dates.toDate(localDate);
        List<Type> holidayTypes = holidayService.findTypes();

        Holiday h1 = new Holiday();
        h1.setDescription("New Year's Day, Woot!");
        h1.setObservedDate(date);
        h1.setOfficialDate(date);
        h1.setHolidayTypes(holidayTypes);

        h1 = holidayRepository.save(h1);

        Holiday h2 = holidayRepository.findById(h1.getId()).get();
        assertEquals(h1, h2);
        assertThat(h2.getDescription(), equalTo("New Year's Day, Woot!"));

        // Clean up the stuff added above.
        holidayRepository.delete(h);
        holidayRepository.delete(h1);
    }
}
