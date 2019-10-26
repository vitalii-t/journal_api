package com.journal.business.rest.controller;

import com.journal.business.rest.BaseResponse;
import com.journal.business.service.ScheduleService;
import com.journal.data.dto.WeekDto;
import com.journal.data.dto.WeekTypeEnum;
import com.journal.data.entities.Schedule;
import com.journal.data.entities.Week;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/time")
    public BaseResponse<List<Schedule>> allSchedule() {
        return new BaseResponse<>(scheduleService.findAll());
    }

    @GetMapping
    public BaseResponse<List<WeekDto>> subjectsSchedule(String subjectName, WeekTypeEnum weekType) {
        List<Week> schedule = scheduleService.findScheduleByWeek(subjectName, weekType.name().toLowerCase());
        return new BaseResponse<>(schedule.stream()
                .map(WeekDto::new)
                .collect(Collectors.toList()));
    }
}