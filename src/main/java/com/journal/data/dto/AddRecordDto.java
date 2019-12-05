package com.journal.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel
public class AddRecordDto {

    @NotNull(message = "subject id should not be empty")
    private Long subjectId;

    @NotEmpty(message = "registry should contain at least 1 user")
    private List<RegistryDto> registry;

}