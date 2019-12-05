package com.journal.service;

import com.journal.data.dto.AddRecordDto;
import com.journal.data.dto.RegistryResponseDto;

public interface RegistryService {

    void addRecord(AddRecordDto record);

    /**
     * Get registry to specified date. By default - previous day
     *
     * @param date date
     * @return registry records made on specified date
     */
    RegistryResponseDto findAllByDate(String date);
}