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

insert into subject(subject_id, subject_name)
values (1, 'Технології прикладного програмування(пр)');
insert into subject(subject_id, subject_name)
values (2, 'Технології прикладного програмування(лек)');
insert into subject(subject_id, subject_name)
values (3, 'Інженерія програмного забезпечення(пр)');
insert into subject(subject_id, subject_name)
values (4, 'Інженерія програмного забезпечення(лек)');
insert into subject(subject_id, subject_name)
values (5, 'Проектування інтерфейсів(пр)');
insert into subject(subject_id, subject_name)
values (6, 'Проектування інтерфейсів(лек)');
insert into subject(subject_id, subject_name)
values (7, 'Паралельні та розподілені обчислення(пр)');
insert into subject(subject_id, subject_name)
values (8, 'Паралельні та розподілені обчислення(лек)');
insert into subject(subject_id, subject_name)
values (9, 'Розпізнавання образів(пр)');
insert into subject(subject_id, subject_name)
values (10, 'Розпізнавання образів(лек)');
insert into subject(subject_id, subject_name)
values (11, 'Телекомунікаційні системи і технології(пр)');
insert into subject(subject_id, subject_name)
values (12, 'Телекомунікаційні системи і технології(лек)');

-- odd week

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (1, 'понеділок', 1, 1, 'odd');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (2, 'вівторок', 1, 2, 'odd');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (3, 'вівторок', 2, 3, 'odd');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (4, 'вівторок', 3, 5, 'odd');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (5, 'середа', 1, 11, 'odd');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (6, 'середа', 2, 10, 'odd');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (7, 'четвер', 1, 12, 'odd');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (8, 'четвер', 2, 8, 'odd');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (9, 'п`ятниця', 2, 9, 'odd');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (10, 'п`ятниця', 3, 6, 'odd');

-- EVEN WEEK SCHEDULE

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (11, 'понеділок', 0, 7, 'even');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (12, 'вівторок', 2, 10, 'even');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (13, 'вівторок', 3, 6, 'even');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (14, 'середа', 1, 11, 'even');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (15, 'середа', 2, 12, 'even');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (16, 'четвер', 1, 4, 'even');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (17, 'четвер', 2, 5, 'even');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (18, 'п`ятниця', 2, 6, 'even');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (19, 'п`ятниця', 3, 10, 'even');

insert into groups(id, identifier)
values (1, 'CI-161');

insert into users(id, activation_code, active, email, first_name, last_name, password, username, group_id, role)
values (1, 'null', true, 'email@gmail.com', 'Vitalii', 'Tasun',
        '$2a$08$G8w2cGL4zOdQxStNbPVhde.ZeC0TmfojLxdcTc5eukSkl8bQwmvvO', 'mind0wner', 1, 'ADMIN');
insert into users(id, activation_code, active, email, first_name, last_name, password, username, group_id, role)
values (2, 'null', true, 'ex@gmail.com', 'Андрей', 'Нечипорук',
        '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe', 'u1', 1, 'MONITOR');

insert into users(id, activation_code, active, email, first_name, last_name, password, username, group_id, role)
values (3, 'null', true, 'amp2@gmail.com', 'Андрей', 'Колесник',
        '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe', 'u2', 1, 'STUDENT');