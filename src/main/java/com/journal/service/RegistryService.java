package com.journal.service;

import com.journal.data.dto.AddRecordDto;
import com.journal.data.dto.RegistryByUserAndDatesDtoRequest;
import com.journal.data.dto.RegistryByUserAndDatesDtoResponse;
import com.journal.data.dto.RegistryResponseDto;

import java.util.List;

public interface RegistryService {

    void addRecord(AddRecordDto record);

    /**
     * Get registry to specified date. By default - previous day
     *
     * @param date date
     * @param lang language
     * @return registry records made on specified date
     */
    RegistryResponseDto findAllByDate(String date, String lang);

    /***
     * Get registry by user id and dates interval
     * @param request consists of user id and dates
     * @param lang language
     * @return subject name and date
     */
    List<RegistryByUserAndDatesDtoResponse> getRegistryByUserIdAndDates(RegistryByUserAndDatesDtoRequest request, String lang);
}