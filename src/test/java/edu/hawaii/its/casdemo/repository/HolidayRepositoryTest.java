package edu.hawaii.its.casdemo.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.service.HolidayService;
import edu.hawaii.its.casdemo.type.Holiday;
import edu.hawaii.its.casdemo.type.Type;
import edu.hawaii.its.casdemo.util.Dates;
import edu.hawaii.its.casdemo.util.Strings;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class HolidayRepositoryTest {

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private HolidayService holidayService;

    @Test
    public void findById() {
        Holiday h = holidayRepository.findById(115);
        assertThat(h.getDescription(), equalTo("Christmas"));
        assertThat(h.getHolidayTypes().size(), equalTo(3));
        LocalDate localDate = Dates.newLocalDate(2018, Month.DECEMBER, 25);
        Date date = Dates.toDate(localDate);
        assertThat(h.getObservedDate(), equalTo(date));
        assertThat(h.getOfficialDate(), equalTo(date));
        assertThat(h.getHolidayTypes().size(), equalTo(3));
    }

    @Test
    public void findAllPaged() {
        int size = 14;
        Sort sort = new Sort(new Sort.Order(Direction.ASC, "observedDate"));
        Pageable pageable = new PageRequest(0, size, sort);
        Page<Holiday> page = holidayRepository.findAll(pageable);
        int pages = page.getTotalPages();
        System.out.println("  >>> total-page: " + pages);
        System.out.println("  >>>       sort: " + page.getSort());

        System.out.println(Strings.fill('v', 98));
        //Iterator<Holiday> itor = page.iterator();
        //        while (itor.hasNext()) {
        //            Holiday h = itor.next();
        //            System.out.println("  >>> " + h);
        //        }

        System.out.println("++++++++++++++++++++++++++++++++++++++");

        for (int i = 0; i < pages; i++) {
            if (page.hasContent()) {
                List<Holiday> list = page.getContent();
                for (Holiday h : list) {
                    System.out.println("  " + h);
                }
                System.out.println("  ---------------------------------------");
            }
            page = holidayRepository.findAll(page.nextPageable());
        }

        System.out.println(Strings.fill('^', 98));
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
        Holiday h0 = holidayRepository.findById(h.getId());
        assertEquals(h0, h);
        h = null;
        h0 = null;

        localDate = Dates.firstOfNextMonth(localDate);
        date = Dates.toDate(localDate);
        List<Type> holidayTypes = holidayService.findTypes();

        Holiday h1 = new Holiday();
        h1.setDescription("New Year's Day, Woot!");
        h1.setObservedDate(date);
        h1.setOfficialDate(date);
        h1.setHolidayTypes(holidayTypes);

        h1 = holidayRepository.save(h1);

        Holiday h2 = holidayRepository.findById(h1.getId());
        assertEquals(h1, h2);
        assertThat(h2.getDescription(), equalTo("New Year's Day, Woot!"));
    }
}
