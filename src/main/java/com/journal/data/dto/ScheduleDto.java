package com.journal.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.journal.data.entities.Schedule;
import com.journal.util.serializers.LocalTimeSerializer;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalTime;

@Data
@ApiModel
public class ScheduleDto {

    private Long id;

    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime beginning;

    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime end;

    public ScheduleDto(Schedule entity) {
        this.id = entity.getId();
        this.beginning = entity.getBeginning();
        this.end = entity.getEnd();
    }
}