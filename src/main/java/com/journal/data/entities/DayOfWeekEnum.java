package com.journal.data.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DayOfWeekEnum {

    MONDAY("Monday", "Понеділок"),
    TUESDAY("Tuesday", "Вівторок"),
    WEDNESDAY("Wednesday", "Середа"),
    THURSDAY("Thursday", "Четвер"),
    FRIDAY("Friday", "П`ятниця");

    private final String en;
    private final String ua;
}
