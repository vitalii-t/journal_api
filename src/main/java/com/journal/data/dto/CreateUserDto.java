package com.journal.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@ApiModel
public class CreateUserDto {

    @NotNull(message = "First name should not be empty;")
    @Pattern(regexp = "[\\p{IsCyrillic}'`-]+",
            message = "First name can contain only cyrillic and english letters, (space), -;")
    private String firstName;

    @NotNull(message = "Last name should not be empty;")
    @Pattern(regexp = "[\\p{IsCyrillic}'`-]+",
            message = "Last name can contain only cyrillic and english letters, (space), -;")
    private String lastName;

    @NotNull(message = "Username should not be empty;")
    @Size(min = 4, message = "Username can't be smaller than 4 symbols;")
    @Pattern(regexp = "[a-zA-Z\\-_0-9]+",
            message = "Username can contain only english letters, numbers, _, -;")
    private String username;

    @Email
    @NotNull(message = "Email should not be empty")
    private String email;

    @NotNull(message = "Password should not be empty;")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$+",
            message = "Password should contain at least 1 upper-case letter, 1 lower-case letter, 1 number " +
                    "and be at least 8 symbols;")
    private String password;

}