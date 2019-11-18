create table users
(
    id              serial primary key not null,
    first_name      character varying(70),
    last_name       character varying(70),
    username        character varying(70),
    password        character varying(70),
    list_number     bigint,
    activation_code character varying(255),
    email           character varying(100),
    group_id        bigint             not null,
    roles           bigint             not null,

    constraint user_role_fk foreign key (roles) references user_role (user_id),
    constraint user_group_fk foreign key (group_id) references groups (id)

)
