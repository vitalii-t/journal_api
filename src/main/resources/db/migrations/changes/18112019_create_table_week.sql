create table week
(
    id           bigint primary key not null,
    week_day     varchar(100),
    lesson_index bigint,
    subject_name varchar(100),
    week_type    varchar(100)
)