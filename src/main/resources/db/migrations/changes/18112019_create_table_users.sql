create table users
(
    id              serial primary key not null,
    activation_code character varying(255),
    active          boolean,
    email           character varying(100),
    first_name      character varying(70),
    last_name       character varying(70),
    list_number     bigint,
    password        character varying(70),
    username        character varying(70),
    group_id        bigint             not null,

    constraint user_group_fk foreign key (group_id) references groups (id)

)
