package com.journal.service;

import com.journal.data.dto.SubjectDto;
import com.journal.data.entities.Subject;

import java.util.List;

public interface SubjectService {

    /**
     * Find all subjects
     *
     * @return list of sujects
     */
    List<SubjectDto> findAll();

    /**
     * Find subject by id
     *
     * @param id subject id
     * @return found subject
     */
    Subject findById(Long id);
}