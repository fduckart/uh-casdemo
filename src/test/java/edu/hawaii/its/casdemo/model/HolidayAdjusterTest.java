package edu.hawaii.its.casdemo.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.hawaii.its.casdemo.util.Dates;

public class HolidayAdjusterTest {

    @Test
    public void adjustInto() {
        LocalDate date = Dates.firstDateOfYear(2019);
        while (date.getYear() < 2021) {
            LocalDate adjustedDate = date.with(new HolidayAdjuster());
            DayOfWeek dayOfWeek = adjustedDate.getDayOfWeek();

            switch (date.getDayOfWeek()) {
                case MONDAY:
                    assertThat(dayOfWeek, equalTo(DayOfWeek.MONDAY));
                    break;
                case TUESDAY:
                    assertThat(dayOfWeek, equalTo(DayOfWeek.TUESDAY));
                    break;
                case WEDNESDAY:
                    assertThat(dayOfWeek, equalTo(DayOfWeek.WEDNESDAY));
                    break;
                case THURSDAY:
                    assertThat(dayOfWeek, equalTo(DayOfWeek.THURSDAY));
                    break;
                case FRIDAY:
                    assertThat(dayOfWeek, equalTo(DayOfWeek.FRIDAY));
                    break;
                case SATURDAY:
                    assertThat(dayOfWeek, equalTo(DayOfWeek.FRIDAY));
                    break;
                case SUNDAY:
                    assertThat(dayOfWeek, equalTo(DayOfWeek.MONDAY));
                    break;
                default:
                    fail("Should not reach here.");
                    break;
            }

            date = date.plusDays(1);
        }
    }
}
