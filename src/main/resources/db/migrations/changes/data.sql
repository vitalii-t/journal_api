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

insert into subject(subject_id, subject_name_ua, subject_name_en)
values (1, 'Технології прикладного програмування(пр)', 'TPP (pr)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (2, 'Технології прикладного програмування(лек)', 'TPP (lec)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (3, 'Інженерія програмного забезпечення(пр)', 'IPZ (pr)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (4, 'Інженерія програмного забезпечення(лек)', 'IPZ (lec)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (5, 'Проектування інтерфейсів(пр)', 'Interfaces (pr');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (6, 'Проектування інтерфейсів(лек)', 'Interfaces (lec)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (7, 'Паралельні та розподілені обчислення(пр)', 'PRO (pr)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (8, 'Паралельні та розподілені обчислення(лек)', 'PRO (lec)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (9, 'Розпізнавання образів(пр)', 'RO (pr)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (10, 'Розпізнавання образів(лек)', 'RO (lec)' );
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (11, 'Телекомунікаційні системи і технології(пр)', 'TSiT (pr)');
insert into subject(subject_id, subject_name_ua, subject_name_en)
values (12, 'Телекомунікаційні системи і технології(лек)', 'TSiT (lec)');

-- ODD week

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (1, 'MONDAY', 1, 1, 'ODD');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (2, 'TUESDAY', 1, 2, 'ODD');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (3, 'TUESDAY', 2, 3, 'ODD');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (4, 'TUESDAY', 3, 5, 'ODD');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (5, 'WEDNESDAY', 1, 11, 'ODD');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (6, 'WEDNESDAY', 2, 10, 'ODD');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (7, 'THURSDAY', 1, 12, 'ODD');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (8, 'THURSDAY', 2, 8, 'ODD');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (9, 'FRIDAY', 2, 9, 'ODD');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (10, 'FRIDAY', 3, 6, 'ODD');


-- EVEN WEEK SCHEDULE

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (11, 'MONDAY', 0, 7, 'EVEN');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (12, 'TUESDAY', 2, 10, 'EVEN');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (13, 'TUESDAY', 3, 6, 'EVEN');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (14, 'WEDNESDAY', 1, 11, 'EVEN');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (15, 'WEDNESDAY', 2, 12, 'EVEN');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (16, 'THURSDAY', 1, 4, 'EVEN');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (17, 'THURSDAY', 2, 5, 'EVEN');

insert into week(id, week_day, lesson_index, subject_id, week_type)
values (18, 'FRIDAY', 2, 6, 'EVEN');
insert into week(id, week_day, lesson_index, subject_id, week_type)
values (19, 'FRIDAY', 3, 10, 'EVEN');

insert into groups(id, identifier)
values (1, 'КІ-161');

insert into users(id, activation_code, active, email, first_name_en, last_name_en, first_name_ua, last_name_ua,
                  password, username, group_id, role)
values (1, 'null', true, 'email@gmail.com', 'Vitalii', 'Tasun', 'Віталій', 'Тасун',
        '$2a$08$G8w2cGL4zOdQxStNbPVhde.ZeC0TmfojLxdcTc5eukSkl8bQwmvvO', 'mind0wner', 1, 'ADMIN');
insert into users(id, activation_code, active, email, first_name_en, last_name_en, first_name_ua, last_name_ua,
                  password, username, group_id, role)
values (2, 'null', true, 'ex@gmail.com', 'Andrey', 'Nechiporuk', 'Андрій', 'Нечипорук',
        '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe', 'u1', 1, 'MONITOR');

insert into users(id, activation_code, active, email, first_name_en, last_name_en, first_name_ua, last_name_ua,
                  password, username, group_id, role)
values (3, 'null', true, 'amp2@gmail.com', 'Andrey', 'Kolesnik', 'Андрій', 'Колесник',
        '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe', 'u2', 1, 'STUDENT');