package com.journal.data.dto;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Set;

@Data
@ApiModel
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> roles;

    public UserDto(User entity) {
        id = entity.getNumberInGroupList();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        roles = entity.getRoles();
    }
}