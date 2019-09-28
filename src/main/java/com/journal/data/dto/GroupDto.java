package com.journal.data.dto;

import com.journal.data.entities.Group;
import lombok.Data;

@Data
public class GroupDto {
    private String identifier;

    public GroupDto(Group entity){
        this.identifier = entity.getIdentifier();
    }
}