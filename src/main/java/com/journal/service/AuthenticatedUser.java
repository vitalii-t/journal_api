package com.journal.service;

import com.journal.data.entities.User;
import com.journal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthenticatedUser {

    private final UserRepository userRepository;

    public String getCurrentUserUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth.getName() : null;
    }

    public User getAuthenticatedUser() {
        String loggedInUserLogin = getCurrentUserUsername();
        if (loggedInUserLogin != null) {
            return Optional.ofNullable(userRepository.findByUsername(loggedInUserLogin))
                    .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        }
        return null;
    }

}