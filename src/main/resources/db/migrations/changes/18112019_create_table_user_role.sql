create table user_role
(
    user_id bigint not null,
    roles    varchar(255)  not null,

    primary key (user_id, roles),
    constraint user_role_fk foreign key (user_id) references users (id)

)