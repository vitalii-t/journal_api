package com.journal.data.dto;

import com.journal.data.entities.Group;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class GroupDto {

    private String identifier;

    public GroupDto(Group entity) {
        this.identifier = entity.getIdentifier();
    }
}