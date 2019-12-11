package com.journal.service.impl;

import com.journal.data.dto.*;
import com.journal.data.entities.Registry;
import com.journal.data.entities.Subject;
import com.journal.repository.RegistryRepository;
import com.journal.service.RegistryService;
import com.journal.service.SubjectService;
import com.journal.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistryServiceImpl implements RegistryService {

    private final RegistryRepository registryRepository;
    private final UserService userService;
    private final SubjectService subjectService;

    @Override
    @Transactional
    public void addRecord(AddRecordDto record) {
        Subject subject = subjectService.findById(record.getSubjectId());
        List<RegistryDto> registry = record.getRegistry();
        List<Registry> registries = new ArrayList<>();

        for (RegistryDto registryDto : registry) {
            registries.add(new Registry(userService.findById(registryDto.getUserId()),
                    subject,
                    registryDto.isPresent()));
        }

        LocalDate now = LocalDate.now();
        if (registryRepository.existsByDateOfLessonAndSubject(now, subject)) {
            registryRepository.deleteAllBySubjectAndDateOfLesson(subject, now);
        }
        registryRepository.saveAll(registries);
    }

    @Override
    @Transactional
    public RegistryResponseDto findAllByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (date == null || date.isEmpty()) {

            return generateResponse(registryRepository.findAllByDateOfLesson(LocalDate.now()), LocalDate.now());

        } else {
            LocalDate requestedDate = LocalDate.parse(date, formatter);
            if (requestedDate.equals(LocalDate.now()) || requestedDate.isBefore(LocalDate.now())) {
                return generateResponse(registryRepository.findAllByDateOfLesson(requestedDate), requestedDate);
            } else {
                throw new IllegalArgumentException("Date can't be greater than today. Should be today or earlier");
            }
        }
    }

    private RegistryResponseDto generateResponse(List<Registry> registryByDate, LocalDate requestedDate) {
        Set<UserSubjectDto> collect = registryByDate.stream().map(registry -> {
            UserSubjectDto dto = new UserSubjectDto();
            dto.setSubject(new SubjectDto(registry.getSubject()));
            dto.setUsers(registryByDate.stream()
                    .filter(registry1 -> registry1.getSubject().equals(registry.getSubject()))
                    .map(registry1 -> new RegistryUserDto(registry1.getUser(), registry1.isPresent()))
                    .collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toSet());
        return new RegistryResponseDto(requestedDate, new ArrayList<>(collect));
    }

}