create table week
(
    id           bigserial not null,
    week_day     varchar(255),
    lesson_index int8,
    week_type    varchar(255),
    subject_id   int8,
    primary key (id)
);