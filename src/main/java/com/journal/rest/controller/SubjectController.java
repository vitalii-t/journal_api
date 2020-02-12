package com.journal.rest.controller;

import com.journal.data.dto.SubjectDto;
import com.journal.rest.BaseResponse;
import com.journal.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN','MONITOR')")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    @ApiOperation("get list of subjects")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get all subjects"),
            @ApiResponse(code = 401, message = "You are not authenticated to view this resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public BaseResponse<List<SubjectDto>> getAllSubjects(@RequestParam(required = false, defaultValue = "ua") String lang) {
        return new BaseResponse<>(subjectService.findAll(lang));
    }
}