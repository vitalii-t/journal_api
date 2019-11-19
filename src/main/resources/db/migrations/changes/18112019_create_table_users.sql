create table users
(
    id              serial primary key not null,
    activation_code varchar(255),
    active          boolean,
    email           varchar(100),
    first_name      varchar(70),
    last_name       varchar(70),
    list_number     bigint,
    password        varchar(70),
    username        varchar(70),
    group_id        bigint             not null,

    constraint user_group_fk foreign key (group_id) references groups (id)

);