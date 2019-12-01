package com.journal.data.dto;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

    public UserDto(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        role = entity.getRole();
    }
}