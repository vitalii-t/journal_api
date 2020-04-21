package com.journal.data.dto;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import lombok.Data;

@Data
public class CurrentUserDto {

    private String firstName;
    private String lastName;
    private String username;
    private Role role;

    public CurrentUserDto(User entity, String lang) {
        this.firstName = lang.equalsIgnoreCase("en") ? entity.getFirstNameEn() : entity.getFirstNameUa();
        this.lastName = lang.equalsIgnoreCase("en") ? entity.getLastNameEn() : entity.getLastNameUa();
        this.username = entity.getUsername();
        this.role = entity.getRole();
    }

}