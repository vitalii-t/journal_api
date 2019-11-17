package com.journal.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class LoginDto {

    @NotNull
    private String username;
    @NotNull
    private String password;

}