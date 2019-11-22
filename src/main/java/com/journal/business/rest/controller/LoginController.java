package com.journal.business.rest.controller;

import com.journal.business.rest.BaseResponse;
import com.journal.business.service.UserService;
import com.journal.data.dto.LoginDto;
import com.journal.data.entities.User;
import com.journal.security.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping
    @ApiOperation("Endpoint to login")
    public BaseResponse login(@RequestBody LoginDto request) {

        try {
            String username = request.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));
            User user = userService.findUserByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username " + username + " not found!");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<String, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            response.put("roles", user.getRoles());

            return new BaseResponse<>(response, HttpStatus.OK.value());
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password!");
        }

    }
}