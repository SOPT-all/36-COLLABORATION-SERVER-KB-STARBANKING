package org.sopt36th.seminar.common.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static String toFormattedTime(LocalDate date) {
        return date.format(FORMATTER);
    }

    public static int calculateMonth(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate).getYears() * 12 + Period.between(startDate, endDate).getMonths();
    }
}
