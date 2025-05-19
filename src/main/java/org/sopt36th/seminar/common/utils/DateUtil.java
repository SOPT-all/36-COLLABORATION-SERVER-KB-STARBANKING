package org.sopt36th.seminar.common.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static String toFormattedDDay(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return "D-" + days;
    }

}
