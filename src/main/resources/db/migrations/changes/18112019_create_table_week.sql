create table week
(
    id           serial primary key not null,
    week_day     varchar(100),
    lesson_index serial,
    subject_name varchar(100),
    week_type    varchar(100)
)