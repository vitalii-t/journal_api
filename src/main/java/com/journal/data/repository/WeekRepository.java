package com.journal.data.repository;

import com.journal.data.entities.Week;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeekRepository extends JpaRepository<Week, Long> {
    /**
     * Find schedule by week type and filter by subject name
     *
     * @param subjectName subject name
     * @param weekType    type of week
     * @return filtered schedule
     */
    List<Week> findBySubjectNameContainsAndWeekType(String subjectName, String weekType);

    /**
     * Find schedule by specified week
     *
     * @param weekType type of week
     * @return schedule
     */
    List<Week> findByWeekType(String weekType);
}