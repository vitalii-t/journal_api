package com.journal.rest.controller;

import com.journal.data.dto.CreateUserDto;
import com.journal.data.entities.User;
import com.journal.rest.BaseResponse;
import com.journal.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    @ApiOperation("Register new user")
    public ResponseEntity<Boolean> registration(@Valid @RequestBody CreateUserDto request) {
        return new ResponseEntity<>(userService.register(fromDto(request)), HttpStatus.CREATED);
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