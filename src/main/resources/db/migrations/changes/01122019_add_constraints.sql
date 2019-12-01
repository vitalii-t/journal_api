alter table if exists users
    add constraint unique_email unique (email);
alter table if exists users
    add constraint unique_username unique (username);
alter table if exists registry
    add constraint FK_registry_to_subject foreign key (subject_id) references subject;
alter table if exists registry
    add constraint FK_registry_to_user foreign key (user_id) references users;
alter table if exists users
    add constraint FK_user_to_group foreign key (group_id) references groups;
alter table if exists week
    add constraint FKe_week_to_subject foreign key (subject_id) references subject;