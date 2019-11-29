package com.journal.service.impl;

import com.journal.data.dto.WeekDto;
import com.journal.data.dto.WeekResponseDto;
import com.journal.data.entities.Schedule;
import com.journal.data.entities.Week;
import com.journal.repository.ScheduleRepository;
import com.journal.repository.WeekRepository;
import com.journal.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final WeekRepository weekRepository;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<WeekResponseDto> findScheduleByWeek(String weekType) {

        List<Week> filteredByWeekType = weekRepository.findByWeekType(weekType.toLowerCase());
        List<WeekDto> dto = filteredByWeekType.stream().map(WeekDto::new).collect(Collectors.toList());

        return dto.stream()
                .map(dto1 -> {
                    WeekResponseDto responseDto = new WeekResponseDto();
                    responseDto.setDayOfWeek(dto1.getDayOfWeek());
                    responseDto.setSubjects(dto.stream()
                            .filter(dto2 -> dto2.getDayOfWeek().equals(dto1.getDayOfWeek()))
                            .collect(Collectors.toList()));
                    return responseDto;
                })
                .collect(Collectors.toList());
    }
}