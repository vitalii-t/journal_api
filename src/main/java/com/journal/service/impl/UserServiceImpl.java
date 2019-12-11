package com.journal.service.impl;

import com.journal.data.dto.CurrentUserDto;
import com.journal.data.dto.UpdateUserDto;
import com.journal.data.dto.UserDto;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import com.journal.exceptions.UserNotFoundException;
import com.journal.repository.GroupRepository;
import com.journal.repository.UserRepository;
import com.journal.service.AuthenticatedUser;
import com.journal.service.MailSender;
import com.journal.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final MailSender mailSender;
    private final AuthenticatedUser authenticatedUser;

    public List<UserDto> findAll() {
        log.info("Retrieving all users");
        return userRepository.findAllOrderedByLastName().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean register(User user) {

        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ANON);
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);
        log.info("Saved new user {}", user.toString());

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to CI-161's group site. \n" +
                            "If you don`t want just ignore message. \n" +
                            "Please, visit next link: https://api-journal.herokuapp.com/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Activation code", message);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setGroup(groupRepository.getOne(1L));
        user.setActivationCode(null);
        user.setRole(Role.STUDENT);
        userRepository.saveAndFlush(user);

        return true;
    }

    @Override
    @Transactional
    public void update(UpdateUserDto dto, Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User with such number in group list not found!"));
        user.setRole(dto.getRole());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User findById(Long id) {
        log.info("Retrieving user by id {}", id);

        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found!"));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting user with id {}", id);
        userRepository.deleteById(id);
    }

    public User findUserByUsername(String username) {
        log.info("Retrieving user by username {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public CurrentUserDto getCurrentUser() {
        return new CurrentUserDto(authenticatedUser.getAuthenticatedUser());
    }

}