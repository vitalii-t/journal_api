package com.journal.business.service;

import com.journal.data.entities.Schedule;
import com.journal.data.entities.Week;

import java.util.List;

/**
 * Service that perform operations with schedule
 */
public interface ScheduleService {
    /***
     * Get full time schedule
     * @return list of schedule
     */
    List<Schedule> findAll();

    /**
     * Find schedule by week type and filter by subject name
     *
     * @param subjectName subject name
     * @param weekType    week type
     * @return filtered schedule
     */
    List<Week> findScheduleByWeek(String subjectName, String weekType);
}