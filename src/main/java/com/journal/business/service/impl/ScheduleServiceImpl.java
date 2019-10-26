package com.journal.business.service.impl;

import com.journal.business.service.ScheduleService;
import com.journal.data.entities.Schedule;
import com.journal.data.entities.Week;
import com.journal.data.repository.ScheduleRepository;
import com.journal.data.repository.WeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final WeekRepository weekRepository;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Week> findScheduleByWeek(String subjectName, String weekType) {
        if (subjectName != null && !subjectName.isEmpty()) {
            return weekRepository.findBySubjectNameContainsAndWeekType(subjectName, weekType);
        } else {
            return weekRepository.findByWeekType(weekType);
        }
    }
}