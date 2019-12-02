package com.journal.service;

import com.journal.data.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    /**
     * Find all subjects
     * @return list of sujects
     */
    List<SubjectDto> findAll();
}