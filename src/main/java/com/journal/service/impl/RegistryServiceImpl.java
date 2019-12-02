package com.journal.service.impl;

import com.journal.data.entities.Registry;
import com.journal.repository.RegistryRepository;
import com.journal.service.RegistryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistryServiceImpl implements RegistryService {

    private final RegistryRepository registryRepository;

    @Override
    public void addRecord() {
        Registry save = registryRepository.save(new Registry());
    }
}