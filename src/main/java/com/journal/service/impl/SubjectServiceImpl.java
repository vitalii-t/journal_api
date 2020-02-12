package com.journal.service.impl;

import com.journal.data.dto.SubjectDto;
import com.journal.data.entities.Subject;
import com.journal.repository.SubjectRepository;
import com.journal.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    @Transactional
    public List<SubjectDto> findAll(String lang) {
        return subjectRepository.findAll().stream()
                .map(subject -> toDto(subject, lang))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject with id " + id + " not found!"));
    }

    private SubjectDto toDto(Subject entity, String lang) {
        return SubjectDto.builder()
                .id(entity.getId())
                .name(lang.equalsIgnoreCase("en") ? entity.getSubjectNameEn() : entity.getSubjectNameUa())
                .build();
    }

}