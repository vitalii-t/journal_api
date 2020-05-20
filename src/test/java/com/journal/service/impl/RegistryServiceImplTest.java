package com.journal.service.impl;

import com.journal.repository.RegistryRepository;
import com.journal.service.RegistryService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class RegistryServiceImplTest {

    @Mock
    private RegistryRepository registryRepository;

    private RegistryService registryService;

    @Before
    public void setUp() throws Exception {
//        registryService = new RegistryServiceImpl()
    }
}