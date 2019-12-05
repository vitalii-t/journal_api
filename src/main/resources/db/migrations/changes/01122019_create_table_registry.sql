create table registry
(
    id         bigserial not null,
    present    boolean   not null,
    subject_id int8,
    user_id    int8,
    primary key (id)
);