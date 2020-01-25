package com.journal.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatesUtil {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static List<LocalDate> getDatesBetween(LocalDate from, LocalDate to) {

        List<LocalDate> totalDates = new ArrayList<>();
        while (!from.isAfter(to)) {
            totalDates.add(from);
            from = from.plusDays(1);
        }
        return totalDates;
    }

    private DatesUtil() {
    }

}