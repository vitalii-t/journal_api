package com.journal.security;

import com.journal.data.entities.User;
import com.journal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserDetailsService} interface for {@link JwtUser}.
 *
 * @author Vitalii Tasun
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User dbUser = userRepository.findByUsername(username);

        if (dbUser == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found!");
        }
        log.info("Loading user by username {}", username);
        return JwtUserFactory.create(dbUser);
    }
}