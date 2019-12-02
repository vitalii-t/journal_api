package com.journal.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class AddRecordDto {

    private Long subjectId;

    private List<RegistryDto> registry;

}