package com.journal.business.rest.controller;

import com.journal.business.rest.BaseResponse;
import com.journal.business.service.UserService;
import com.journal.data.dto.UpdateUserDto;
import com.journal.data.dto.UserDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin
@PreAuthorize("hasAnyAuthority('ADMIN','MONITOR','STUDENT')")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "Returns all available users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get all users"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public BaseResponse<List<UserDto>> findAllUsers() {
        return new BaseResponse<>(userService.findAll(), HttpStatus.OK.value());
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MONITOR')")
    public BaseResponse<Void> updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserDto request) {
        userService.update(request, id);
        return new BaseResponse<>();
    }

}