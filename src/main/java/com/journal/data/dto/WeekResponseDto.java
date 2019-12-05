package com.journal.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeekResponseDto {

    private String dayOfWeek;
    private List<WeekDto> subjects;

}