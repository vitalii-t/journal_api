package com.journal.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class RegistryDto {

    private Long userId;

    @JsonProperty("present")
    private boolean present;

}