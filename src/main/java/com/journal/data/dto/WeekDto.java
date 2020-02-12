package com.journal.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel
@Builder
@AllArgsConstructor
public class WeekDto {

    @JsonIgnore
    private String dayOfWeek;
    private Long index;
    private String subject;

}