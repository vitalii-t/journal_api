package com.journal.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.journal.data.entities.User;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel
@AllArgsConstructor
@Builder
public class RegistryUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    @JsonProperty("isPresent")
    private boolean present;

    public RegistryUserDto(User user, boolean present) {
        this.id = user.getId();
        this.firstName = user.getFirstNameUa();
        this.lastName = user.getLastNameUa();
        this.role = user.getRole().name();
        this.present = present;
    }
}