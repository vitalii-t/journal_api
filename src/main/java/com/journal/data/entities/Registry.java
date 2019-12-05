package com.journal.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registry")
@Data
@NoArgsConstructor
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private boolean present;

    private LocalDate dateOfLesson;

    public Registry(User user, Subject subject, boolean present) {
        this.user = user;
        this.subject = subject;
        this.present = present;
    }

    @PrePersist
    private void init() {
        dateOfLesson = LocalDate.now();
    }
}