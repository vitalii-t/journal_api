package com.journal.business.rest.controller;

import com.journal.business.rest.BaseResponse;
import com.journal.business.service.UserService;
import com.journal.data.dto.CreateUserDto;
import com.journal.data.entities.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://journal-project.herokuapp.com/")
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    @ApiOperation("Register new user")
    public BaseResponse registration(@Valid @RequestBody CreateUserDto request) {
        return new BaseResponse<>(userService.register(fromDto(request)), HttpStatus.CREATED.value());
    }

    @GetMapping("/activate/{code}")
    public BaseResponse activate(@PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        return isActivated ? new BaseResponse<>("Account successfully activated!", HttpStatus.OK.value())
                : new BaseResponse<>("Activation code not found!", HttpStatus.BAD_REQUEST.value());
    }

    private User fromDto(CreateUserDto createUserDto) {
        return new User(
                createUserDto.getFirstName(),
                createUserDto.getLastName(),
                createUserDto.getUsername(),
                createUserDto.getPassword(),
                createUserDto.getEmail());
    }

}