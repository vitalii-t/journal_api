package com.journal.service.impl;

import com.journal.data.dto.*;
import com.journal.data.entities.Registry;
import com.journal.data.entities.Subject;
import com.journal.data.entities.User;
import com.journal.repository.RegistryRepository;
import com.journal.service.RegistryService;
import com.journal.service.SubjectService;
import com.journal.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.journal.util.DatesUtil.FORMATTER;

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
    public RegistryResponseDto findAllByDate(String date, String lang) {

        if (date == null || date.isEmpty()) {

            return generateResponse(registryRepository.findAllByDateOfLesson(LocalDate.now()), LocalDate.now(), lang);

        } else {
            LocalDate requestedDate = LocalDate.parse(date, FORMATTER);
            if (requestedDate.equals(LocalDate.now()) || requestedDate.isBefore(LocalDate.now())) {
                return generateResponse(registryRepository.findAllByDateOfLesson(requestedDate), requestedDate, lang);
            } else {
                throw new IllegalArgumentException("Date can't be greater than today. Should be today or earlier");
            }
        }
    }

    @Override
    public List<RegistryByUserAndDatesDtoResponse> getRegistryByUserIdAndDates(RegistryByUserAndDatesDtoRequest request, String lang) {
        User user = userService.findById(request.getUserId());

        if (request.getTo().isBefore(request.getFrom())) {
            throw new IllegalArgumentException("Date from can't be greater than date to");
        }
        List<Registry> registry = registryRepository.findAllByDateOfLessonBetweenAndUser(request.getFrom(), request.getTo(), user);
        return registry.stream()
                .map(record -> new RegistryByUserAndDatesDtoResponse(record, lang))
                .collect(Collectors.toList());
    }

    private RegistryResponseDto generateResponse(List<Registry> registryByDate, LocalDate requestedDate, String lang) {
        Set<UserSubjectDto> collect = registryByDate.stream().map(registry -> {
            UserSubjectDto dto = new UserSubjectDto();
            dto.setSubject(toSubjectDto(registry.getSubject(), lang));
            dto.setUsers(registryByDate.stream()
                    .filter(registry1 -> registry1.getSubject().equals(registry.getSubject()))
                    .map(registry1 -> toRegistryUserDto(registry1.getUser(), lang, registry1.isPresent()))
                    .collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toSet());
        return new RegistryResponseDto(requestedDate, new ArrayList<>(collect));
    }

    private SubjectDto toSubjectDto(Subject subject, String lang) {
        return SubjectDto.builder()
                .id(subject.getId())
                .name(lang.equalsIgnoreCase("en") ? subject.getSubjectNameEn() : subject.getSubjectNameUa())
                .build();
    }

    private RegistryUserDto toRegistryUserDto(User user, String lang, boolean isPresent) {
        return RegistryUserDto.builder()
                .id(user.getId())
                .firstName(lang.equalsIgnoreCase("en") ? user.getFirstNameEn() : user.getFirstNameUa())
                .lastName(lang.equalsIgnoreCase("en") ? user.getLastNameEn() : user.getLastNameUa())
                .role(user.getRole().name())
                .present(isPresent)
                .build();
    }

}