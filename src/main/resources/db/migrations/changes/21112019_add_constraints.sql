alter table if exists users
    add constraint unique_email unique (email);
alter table if exists user_role
    add constraint user_roles_FK foreign key (user_id) references users;
alter table if exists users
    add constraint user_groups_FK foreign key (group_id) references groups;