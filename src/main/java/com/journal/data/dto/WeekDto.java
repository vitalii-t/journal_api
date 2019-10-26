package com.journal.data.dto;

import com.journal.data.entities.Week;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeekDto {

    private Long index;
    private String subject;
    private String dayOfWeek;

    public WeekDto(Week entity) {
        this.index = entity.getLessonIndex();
        this.subject = entity.getSubjectName();
        this.dayOfWeek = entity.getDayOfTheWeek();
    }

}