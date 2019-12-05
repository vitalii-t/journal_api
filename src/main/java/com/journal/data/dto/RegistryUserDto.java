package com.journal.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.journal.data.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class RegistryUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    @JsonProperty("isPresent")
    private boolean present;

    public RegistryUserDto(User user, boolean present) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.role = user.getRole().name();
        this.present = present;
    }
}