package edu.hawaii.its.casdemo.model;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class HolidayAdjuster implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int daysToAdd;

        switch (dayOfWeek) {
            case SATURDAY:
                daysToAdd = -1;
                break;
            case SUNDAY:
                daysToAdd = 1;
                break;
            default:
                daysToAdd = 0;
                break;
        }

        return temporal.plus(daysToAdd, ChronoUnit.DAYS);
    }

}
