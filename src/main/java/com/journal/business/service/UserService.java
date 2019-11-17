package com.journal.business.service;

import com.journal.data.dto.UpdateUserDto;
import com.journal.data.dto.UserDto;
import com.journal.data.entities.User;

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

    /**
     * Register user in system
     *
     * @param user user to store
     * @return true if registration was successful
     */
    boolean register(User user);

    /**
     * Find user by id
     *
     * @param id id
     * @return found user
     */
    User findById(Long id);

    /**
     * Delete user by id
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * Activates user accound and gives new permissions
     *
     * @param code activation code
     * @return true if activation was successful
     */
    boolean activateUser(String code);

    /**
     * Update user
     *
     * @param dto fields to update
     * @param id  user id
     */
    void update(UpdateUserDto dto, Long id);

    /**
     * Get {@link User} by username
     *
     * @param username username
     * @return found user
     */
    User findUserByUsername(String username);


}