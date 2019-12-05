package com.journal.data.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
@AllArgsConstructor
public class UserSubjectDto {

    private SubjectDto subject;
    private List<RegistryUserDto> users;

}