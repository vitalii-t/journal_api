package com.journal.security;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;

/**
 * Implementation of Factory Method for class {@link JwtUser}.
 *
 * @author Vitalii Tasun
 * @version 1.0
 */

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstNameUa(),
                user.getLastNameUa(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRole()),
                user.isActive(),
                new Date()
        );
    }

    private static GrantedAuthority mapToGrantedAuthorities(Role userRole) {
        return new SimpleGrantedAuthority(userRole.name());
    }
}