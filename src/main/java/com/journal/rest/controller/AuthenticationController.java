package com.journal.rest.controller;

import com.journal.data.dto.CreateUserDto;
import com.journal.data.dto.LoginDto;
import com.journal.data.entities.User;
import com.journal.rest.BaseResponse;
import com.journal.security.JwtTokenProvider;
import com.journal.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    @ApiOperation("Endpoint to login")
    public BaseResponse login(@RequestBody @Valid LoginDto request) {

        try {
            String username = request.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));
            User user = userService.findUserByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username " + username + " not found!");
            }

            String token = jwtTokenProvider.createToken(username, user.getRole());

            Map<String, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", "Bearer_" + token);
            response.put("role", user.getRole());

            return new BaseResponse<>(response, HttpStatus.OK.value());
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password!");
        }

    }

    @PostMapping("/registration")
    @ApiOperation("Register new user")
    public BaseResponse<Boolean> registration(@Valid @RequestBody CreateUserDto request) {
        return new BaseResponse<>(userService.register(fromDto(request)));
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