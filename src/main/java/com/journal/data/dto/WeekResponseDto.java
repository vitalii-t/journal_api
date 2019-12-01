package com.journal.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeekResponseDto {

    private String dayOfWeek;
    private List<WeekDto> subjects;

    public WeekResponseDto(WeekDto dto) {
        this.dayOfWeek = dto.getDayOfWeek();
        this.subjects = Stream.of(dto).collect(Collectors.toList());
    }

}