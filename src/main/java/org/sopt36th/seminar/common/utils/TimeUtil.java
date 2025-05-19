package org.sopt36th.seminar.common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static String toFormattedTime(LocalDate date) {
        return date.format(FORMATTER);
    }
}
