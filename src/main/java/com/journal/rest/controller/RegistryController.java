package com.journal.rest.controller;


import com.journal.data.dto.AddRecordDto;
import com.journal.data.dto.RegistryResponseDto;
import com.journal.rest.BaseResponse;
import com.journal.service.RegistryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/registry")
@RequiredArgsConstructor
public class RegistryController {

    private final RegistryService registryService;

    @PostMapping
    @ApiOperation("add record to registry")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add record"),
            @ApiResponse(code = 401, message = "You are not authenticated to view this resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PreAuthorize("hasAuthority('MONITOR')")
    public void addRecord(@RequestBody @Valid AddRecordDto dto) {
        registryService.addRecord(dto);
    }

    @GetMapping
    @ApiOperation("get registry by date")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add record"),
            @ApiResponse(code = 401, message = "You are not authenticated to view this resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT', 'MONITOR')")
    public BaseResponse<RegistryResponseDto> getRegistryForDate(@RequestParam(required = false) String date) {
        return new BaseResponse<>(registryService.findAllByDate(date));
    }
}