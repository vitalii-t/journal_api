package com.journal.rest.controller;


import com.journal.data.dto.AddRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registry")
@RequiredArgsConstructor
public class RegistryController {

    @PostMapping
    public void addRecord(@RequestBody @Valid AddRecordDto dto){

    }
}