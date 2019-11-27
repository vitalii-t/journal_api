package com.journal.business.rest.controller;

import com.journal.business.rest.BaseResponse;
import com.journal.business.service.ScheduleService;
import com.journal.data.dto.WeekDto;
import com.journal.data.dto.WeekTypeEnum;
import com.journal.data.entities.Schedule;
import com.journal.data.entities.Week;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/schedule")
@RequiredArgsConstructor
@CrossOrigin
@PreAuthorize("hasAnyAuthority('ADMIN','MONITOR','STUDENT')")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/time")
    @ApiOperation("get time schedule")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get all time schedule"),
            @ApiResponse(code = 401, message = "You are not authenticated to view this resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public BaseResponse<List<Schedule>> allSchedule() {
        return new BaseResponse<>(scheduleService.findAll(), HttpStatus.OK.value());
    }

    @GetMapping
    @ApiOperation("get schedule for specified week")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get all subjects"),
            @ApiResponse(code = 401, message = "You are not authenticated to view this resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public BaseResponse<List<WeekDto>> subjectsSchedule(@RequestParam(value = "week_type",
            defaultValue = "ODD") WeekTypeEnum weekType) {
        List<Week> schedule = scheduleService.findScheduleByWeek(weekType.name().toLowerCase());
        return new BaseResponse<>(schedule.stream()
                .map(WeekDto::new)
                .collect(Collectors.toList()), HttpStatus.OK.value());
    }
}