package com.journal.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "week_type")
    private String weekType;

    @Column(name = "lesson_index")
    private Long lessonIndex;

    @Column(name = "week_day")
    private String dayOfTheWeek;

}