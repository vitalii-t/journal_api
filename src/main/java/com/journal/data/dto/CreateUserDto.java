package com.journal.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel
public class CreateUserDto {

    @NotNull(message = "First name should not be empty")
    private String firstName;
    @NotNull(message = "Last name should not be empty")
    private String lastName;
    @NotNull(message = "Username should not be empty")
    @Size(min = 4, message = "Username can't be smaller than 4 symbols")
    private String username;
    @Email
    @NotNull(message = "Email should not be empty")
    private String email;
    @NotNull(message = "Password should not be empty")
    @Size(min = 6, message = "Password can't be smaller than 6 symbols")
    private String password;

}