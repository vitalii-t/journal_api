create table users
(
    id              bigserial    not null,
    activation_code varchar(255),
    active          boolean      not null,
    email           varchar(255) not null,
    first_name_en   varchar(255),
    first_name_ua   varchar(255),
    last_name_en    varchar(255),
    last_name_ua    varchar(255),
    password        varchar(255),
    role            varchar(255),
    username        varchar(255),
    group_id        int8,
    primary key (id)
);