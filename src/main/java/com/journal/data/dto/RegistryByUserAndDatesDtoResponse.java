package com.journal.data.dto;

import com.journal.data.entities.Registry;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RegistryByUserAndDatesDtoResponse {

    private String subjectName;
    private String identifier;
    private LocalDate lessonDate;
    private boolean present;

    public RegistryByUserAndDatesDtoResponse(Registry registry, String lang){
        subjectName = lang.equalsIgnoreCase("en") ? registry.getSubject().getSubjectNameEn() : registry.getSubject().getSubjectNameUa();
        lessonDate = registry.getDateOfLesson();
        identifier = UUID.randomUUID().toString();
        present = registry.isPresent();
    }
}
