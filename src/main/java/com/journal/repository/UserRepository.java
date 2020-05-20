package com.journal.repository;

import com.journal.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.active=true ORDER BY u.lastNameUa")
    List<User> findAllOrderedByLastNameUa();

    @Query(value = "SELECT u FROM User u WHERE u.active=true ORDER BY u.lastNameEn")
    List<User> findAllOrderedByLastNameEn();

    User findByUsernameAndActiveIsTrue(String username);

    User findByActivationCode(String code);

}