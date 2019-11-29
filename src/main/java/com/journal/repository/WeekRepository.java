package com.journal.repository;

import com.journal.data.entities.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekRepository extends JpaRepository<Week, Long> {

    /**
     * Find schedule by specified week
     *
     * @param weekType type of week
     * @return schedule
     */
    List<Week> findByWeekType(String weekType);
}