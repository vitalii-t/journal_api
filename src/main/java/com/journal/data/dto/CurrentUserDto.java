package com.journal.data.dto;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import lombok.Data;

@Data
public class CurrentUserDto {

    private String firstName;
    private String lastName;
    private Role role;

    public CurrentUserDto(User entity) {
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.role = entity.getRole();
    }

}