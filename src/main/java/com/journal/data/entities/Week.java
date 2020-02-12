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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "week_type")
    @Enumerated(EnumType.STRING)
    private WeekType weekType;

    @Column(name = "lesson_index")
    private Long lessonIndex;

    @Column(name = "week_day")
    @Enumerated(EnumType.STRING)
    private DayOfWeekEnum dayOfTheWeek;

}