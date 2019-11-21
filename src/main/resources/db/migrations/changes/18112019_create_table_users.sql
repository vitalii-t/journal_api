create table users
(
    id              bigserial    not null,
    activation_code varchar(255),
    active          boolean      not null,
    email           varchar(255) not null,
    first_name      varchar(255),
    last_name       varchar(255),
    list_number     int8,
    password        varchar(255),
    username        varchar(255),
    group_id        int8,
    primary key (id)
)