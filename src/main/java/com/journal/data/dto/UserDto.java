package com.journal.data.dto;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel
@Builder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Role role;


}