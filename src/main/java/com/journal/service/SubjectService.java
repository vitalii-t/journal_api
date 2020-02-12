package com.journal.service;

import com.journal.data.dto.SubjectDto;
import com.journal.data.entities.Subject;

import java.util.List;

public interface SubjectService {

    /**
     * Find all subjects
     * @param lang language
     * @return list of subjects
     */
    List<SubjectDto> findAll(String lang);

    /**
     * Find subject by id
     *
     * @param id subject id
     * @return found subject
     */
    Subject findById(Long id);
}