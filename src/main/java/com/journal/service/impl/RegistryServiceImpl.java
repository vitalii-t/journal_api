package com.journal.service.impl;

import com.journal.data.dto.*;
import com.journal.data.entities.Registry;
import com.journal.repository.RegistryRepository;
import com.journal.service.RegistryService;
import com.journal.service.SubjectService;
import com.journal.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public void addRecord(AddRecordDto record) {
        List<RegistryDto> registry = record.getRegistry();
        List<Registry> registries = new ArrayList<>();
        for (RegistryDto registryDto : registry) {
            registries.add(new Registry(userService.findById(registryDto.getUserId()),
                    subjectService.findById(record.getSubjectId()),
                    registryDto.isPresent()));
        }
        registryRepository.saveAll(registries);
    }

    @Override
    public RegistryResponseDto findAllByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (date == null || date.isEmpty()) {

            return generateResponse(registryRepository.findAllByDateOfLesson(LocalDate.now()), LocalDate.now());

        } else {
            LocalDate requestedDate = LocalDate.parse(date, formatter);
            if (requestedDate.isBefore(LocalDate.now())) {

                return generateResponse(registryRepository.findAllByDateOfLesson(requestedDate), requestedDate);
            } else {
                throw new IllegalArgumentException("Date can't be greater than today. Should be today or earlier");
            }
        }
    }

    private RegistryResponseDto generateResponse(List<Registry> registryByDate, LocalDate requestedDate) {
        List<RegistryUserDto> users = registryByDate.stream()
                .map(registry1 -> new RegistryUserDto(registry1.getUser(), registry1.isPresent()))
                .collect(Collectors.toList());
        Set<UserSubjectDto> usersAndSubjects = registryByDate.stream()
                .map(reg -> {
                    SubjectDto subject = new SubjectDto(reg.getSubject());
                    return new UserSubjectDto(subject, users);
                }).collect(Collectors.toSet());
        return new RegistryResponseDto(requestedDate, new ArrayList<>(usersAndSubjects));
    }

}