package com.journal.data.dto;

import com.journal.data.entities.Subject;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class SubjectDto {

    private Long id;
    private String name;

    public SubjectDto(Subject entity){
        this.id = entity.getId();
        this.name = entity.getSubjectName();
    }
}