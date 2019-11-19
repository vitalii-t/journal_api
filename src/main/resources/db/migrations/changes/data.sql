--  BEGIN/END OF A LESSON SCHEDULE

insert into schedule
values (1, '8:00', '9:20');
insert into schedule
values (2, '9:40', '11:00');
insert into schedule
values (3, '9:40', '11:00');
insert into schedule
values (4, '11:25', '12:45');
insert into schedule
values (5, '13:10', '14:30');
insert into schedule
values (6, '14:50', '16:10');
insert into schedule
values (7, '16:25', '17:45');

-- odd week

insert into week(id,week_day, lesson_index, subject_name, week_type)
values (1,'понеділок', 0, 'вільниий день', 'odd');

insert into week(id, week_day, lesson_index, subject_name, week_type)
values (2,'вівторок', 1, 'Моделювання(лек)', 'odd');
insert into week(id,week_day, lesson_index, subject_name, week_type)
values (3,'вівторок', 2, 'ВКС (лек)', 'odd');
insert into week(id, week_day, lesson_index, subject_name, week_type)
values (4,'вівторок', 3, 'ЦОС(лек)', 'odd');

insert into week(id, week_day, lesson_index, subject_name, week_type)
values (5,'середа', 1, 'WEB-технології (пр)', 'odd');
insert into week(id,week_day, lesson_index, subject_name, week_type)
values (6,'середа', 2, 'Цифрова обробка сигналів (пр)', 'odd');

insert into week(id,week_day, lesson_index, subject_name, week_type)
values (7,'четвер', 1, 'ТПП (пр)', 'odd');
insert into week(id, week_day, lesson_index, subject_name, week_type)
values (8,'четвер', 2, 'ТПП (лек)', 'odd');

insert into week(id, week_day, lesson_index, subject_name, week_type)
values (9,'п`ятниця', 2, 'WEB-технології (лек)', 'odd');
insert into week(id,week_day, lesson_index, subject_name, week_type)
values (10,'п`ятниця', 3, 'Іноземна мова', 'odd');

-- EVEN WEEK SCHEDULE

insert into week(id, week_day, lesson_index, subject_name, week_type)
values (11,'понеділок', 0, 'вільний день', 'even');

insert into week(id,week_day, lesson_index, subject_name, week_type)
values (12, 'вівторок', 2, 'Modelling(лек)', 'even');
insert into week(id, week_day, lesson_index, subject_name, week_type)
values (13,'вівторок', 3, 'ВКС (лек)', 'even');

insert into week(id,week_day, lesson_index, subject_name, week_type)
values ( 14,'середа', 1, 'Programming technology (лек)', 'even');
insert into week(id, week_day, lesson_index, subject_name, week_type)
values ( 15,'середа', 2, 'WEB-technology (лек)', 'even');

insert into week(id, week_day, lesson_index, subject_name, week_type)
values ( 16,'четвер', 1, 'Modelling (пр)', 'even');
insert into week(id,week_day, lesson_index, subject_name, week_type)
values (17, 'четвер', 2, 'Цифрова обробка сигналів (лек)', 'even');

insert into week(id,week_day, lesson_index, subject_name, week_type)
values (18, 'п`ятниця', 2, 'ВКС (пр)', 'even');
insert into week(id, week_day, lesson_index, subject_name, week_type)
values ( 19,'п`ятниця', 3, 'Цифрова обробка сигналів (пр)', 'even');

insert into groups(id, identifier)
values (1,'CI-161');

insert into users(activation_code, active, email, first_name, last_name, list_number, password, username, group_id)
values ('null', true, 'email@gmail.com', 'Vitalii', 'Tasun', 1,
        '$2a$08$G8w2cGL4zOdQxStNbPVhde.ZeC0TmfojLxdcTc5eukSkl8bQwmvvO', 'mind0wner', 1);
insert into users(activation_code, active, email, first_name, last_name, list_number, password, username, group_id)
values ('null', true, 'ex@gmail.com', 'Андрей', 'Нечипорук', 2,
        '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe', 'u1', 1);

insert into users(activation_code, active, email, first_name, last_name, list_number, password, username, group_id)
values ('null', true, 'amp2@gmail.com', 'Андрей', 'Колесник', 3,
        '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe', 'u2', 1);

insert into user_role(user_id, roles)
values (1, 'ADMIN');
insert into user_role(user_id, roles)
values (2, 'MONITOR');
insert into user_role(user_id, roles)
values (3, 'STUDENT');