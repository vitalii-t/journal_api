create table registry
(
    id             bigserial not null,
    date_of_lesson date,
    present        boolean   not null,
    subject_id     int8,
    user_id        int8,
    primary key (id)
);