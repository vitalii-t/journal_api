package com.journal.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registry")
@Data
public class Registry {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private boolean isPresent;

    private LocalDate dateOfLesson;

    @PrePersist
    private void init(){
        dateOfLesson = LocalDate.now();
    }
}