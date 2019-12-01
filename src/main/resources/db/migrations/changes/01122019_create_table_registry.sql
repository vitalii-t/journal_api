create table registry
(
    id         int8    not null,
    is_present boolean not null,
    subject_id int8,
    user_id    int8,
    primary key (id)
);