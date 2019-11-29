package com.journal.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.journal.data.entities.Week;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel
public class WeekDto {

    @JsonIgnore
    private String dayOfWeek;
    private Long index;
    private String subject;

    public WeekDto(Week entity) {
        this.dayOfWeek = entity.getDayOfTheWeek();
        this.index = entity.getLessonIndex();
        this.subject = entity.getSubject().getSubjectName();
    }

}