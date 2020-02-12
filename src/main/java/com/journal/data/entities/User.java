package com.journal.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name_ua")
    private String firstNameUa;

    @Column(name = "last_name_ua")
    private String lastNameUa;

    @Column(name = "first_name_en")
    private String firstNameEn;

    @Column(name = "last_name_en")
    private String lastNameEn;

    @Column(name = "username", unique = true)
    private String username;

    private String password;

    @Column(name = "activation_code")
    private String activationCode;

    @NotBlank(message = "Email can`t be empty")
    @Email(message = "Email is not correct")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active;

    public User(String firstName, String lastName, String username, String password, String email) {
        this.firstNameUa = firstName;
        this.lastNameUa = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}