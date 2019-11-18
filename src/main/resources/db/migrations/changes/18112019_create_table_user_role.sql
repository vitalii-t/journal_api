create type roles as ENUM ('MONITOR', 'STUDENT', 'ADMIN', 'ANON');
create table user_role
(
    user_id bigint not null,
    role    roles  not null,

    primary key (user_id, role),
    constraint user_role_fk foreign key (user_id) references users (id)

)