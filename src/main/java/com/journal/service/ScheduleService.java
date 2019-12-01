package com.journal.service;

import com.journal.data.dto.WeekResponseDto;
import com.journal.data.entities.Schedule;

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
     * Find schedule by week type
     *
     * @param weekType week type
     * @return filtered schedule
     */
    List<WeekResponseDto> findScheduleByWeek(String weekType);
}