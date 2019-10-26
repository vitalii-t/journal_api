package com.journal.business.service;

import com.journal.data.dto.UserDto;

import java.util.List;

/**
 * Service that performs all operations with User
 */
public interface UserService {

    /**
     * Find all users
     *
     * @return list of users
     */
    List<UserDto> findAll();
}