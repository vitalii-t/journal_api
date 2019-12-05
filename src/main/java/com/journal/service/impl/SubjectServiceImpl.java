package com.journal.service.impl;

import com.journal.data.dto.SubjectDto;
import com.journal.data.entities.Subject;
import com.journal.repository.SubjectRepository;
import com.journal.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public List<SubjectDto> findAll() {
        return subjectRepository.findAll().stream()
                .map(SubjectDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject with id " + id + " not found!"));
    }
}
