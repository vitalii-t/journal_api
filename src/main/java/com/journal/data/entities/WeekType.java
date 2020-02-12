package com.journal.data.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeekType {

    ODD("ODD", "НЕПАРНИЙ"),
    EVEN("EVEN","ПАРНИЙ");

    private final String en;
    private final String ua;

}