package com.journal.data.dto;

import com.journal.data.entities.Role;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@ApiModel
public class UpdateUserDto {

    @NotNull(message = "Id should not be empty")
    private Long id;

    @NotNull(message = "Username should not be empty")
    @Pattern(regexp = "[a-zA-Z\\-_0-9]+",
            message = "Username can contain only english letters, numbers, _, -")
    private String username;

    @NotNull(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Roles should not be empty")
    private List<Role> roles;

}