create table groups
(
    id         serial primary key not null,
    identifier character varying(15),
    user_id    bigint             not null

    --constraint group_user_FK foreign key (user_id) references users (id)
)