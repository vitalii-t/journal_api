package com.journal.repository;

import com.journal.data.entities.Week;
import com.journal.data.entities.WeekType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
//    @Query(value = "select * from week where week_type = :weekType", nativeQuery = true)
//    List<Week> byWeekType(@Param("weekType") String weekType);

    List<Week> findAllByWeekType(WeekType weekType);
}