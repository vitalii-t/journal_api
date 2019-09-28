package com.journal.business.rest.controller;

import com.journal.business.rest.BaseResponse;
import com.journal.business.service.UserService;
import com.journal.data.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public BaseResponse<List<UserDto>> findAllUsers(){
        return  new BaseResponse<>(userService.findAllUsers());
    }

}