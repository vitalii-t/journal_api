package com.journal.data.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.journal.rest.serializers.LocalDateSerializer;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistryResponseDto {

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    private List<UserSubjectDto> subjects;
}
