create table week
(
    id           bigserial not null,
    week_day     varchar(255),
    lesson_index int8,
    subject_name varchar(255),
    week_type    varchar(255),
    primary key (id)
)