package com.journal.data.dto;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrentUserDto {

    private String firstName;
    private String lastName;
    private List<Role> roles;

    public CurrentUserDto(User entity){
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.roles = new ArrayList<>(entity.getRoles());
    }

}