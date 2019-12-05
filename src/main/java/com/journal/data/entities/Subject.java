package com.journal.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
public class Subject {

    @Id
    @Column(name = "subject_id")
    private Long id;

    @Column
    private String subjectName;
}