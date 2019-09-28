--  BEGIN/END OF A LESSON SCHEDULE

insert into Schedule values ( 1, '8:00', '9:20' );
insert into Schedule values ( 2, '9:40', '11:00' );
insert into Schedule values ( 3, '9:40', '11:00' );
insert into Schedule values ( 4, '11:25', '12:45' );
insert into Schedule values ( 5, '13:10', '14:30' );
insert into Schedule values ( 6, '14:50', '16:10' );
insert into Schedule values ( 7, '16:25', '17:45' );

-- odd week

insert into week values (1,'monday',0,'free day','odd');

insert into week values (2,'tuesday',1,'Modelling(lec)','odd');
insert into week values (3,'tuesday',2,'Embedded computer systems (lec)','odd');
insert into week values (4,'tuesday',3,'Digital signal processing (lec)','odd');

insert into week values (5,'wednesday',1,'WEB-technology (pr)','odd');
insert into week values (6,'wednesday',2,'Digital signal processing (pr)','odd');

insert into week values (7,'thursday',1,'Programming technology (pr)','odd');
insert into week values (8,'thursday',2,'Programming technology (lec)','odd');

insert into week values (9,'friday',2,'WEB-technology (lec)','odd');
insert into week values (10,'friday',3,'English','odd');

-- EVEN WEEK SCHEDULE

insert into week values (11,'monday',0,'free day','even');

insert into week values (12,'tuesday',2,'Modelling(lec)','even');
insert into week values (13,'tuesday',3,'Embedded computer systems (lec)','even');

insert into week values (14,'wednesday',1,'Programming technology (lec)','even');
insert into week values (15,'wednesday',2,'WEB-technology (lec)','even');

insert into week values (16,'thursday',1,'Modelling (pr)','even');
insert into week values (17,'thursday',2,'Digital signal processing (lec)','even');

insert into week values (18,'friday',2,'Embedded computer systems (pr)','even');
insert into week values (19,'friday',3,'Digital signal processing (pr)','even');

insert into groups values ( 1, 'CI-161' );

insert into users values (1,'null',true,'email@gmail.com','Vitalii','Tasun',
                          '$2a$08$G8w2cGL4zOdQxStNbPVhde.ZeC0TmfojLxdcTc5eukSkl8bQwmvvO','mind0wner',1);
--
insert into users values (2,'null',true,'ex@gmail.com','Andrey','Nechiporuk',
                          '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe','u1',1);

insert into users values (3,'null',true,'amp2@gmail.com','Andrey','Kolesnyk',
                          '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe','u2',1);

insert into users values (4,'null',true,'amp3@gmail.com','Andrey','Kolesnyk',
                          '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe','u3',1);

insert into users values (5,'null',true,'amp4@gmail.com','Andrey','Kolesnyk',
                          '$2a$08$mPFtOkyYRQc/LNwPb0E.LO2HnjSkl/FMYKVjsrjYIIy9uwEWlbUVe','u4',1);
--
-- insert into user values (4,true,'le@gmail.com','Dmitriy','Senchuk','qwe','sen4',1);
-- insert into user values (5,true,'exam@gmail.com','Vasilii','Petrov','qwe','VasPet',1);
-- insert into user values (6,true,'my@gmail.com','Pavel','Gerashchenko','qwe','pashgun',1);
--
-- insert into user values (7,true,'mail@gmail.com','James','Harden','qwe','beard',1);
-- insert into user values (8,true,'123@gmail.com','Damian','Lillard','qwe','time',1);
--
-- insert into user_role values ( 1,'ADMIN' );
 -- insert into user_role values ( 1,'MONITOR' );
-- insert into user_role values ( 2,'MONITOR' );
-- insert into user_role values ( 3,'STUDENT' );
-- insert into user_role values ( 4,'APPROVED' );
-- insert into user_role values ( 5,'ANON' );
-- insert into user_role values ( 4,'STUDENT' );
-- insert into user_role values ( 5,'STUDENT' );
-- insert into user_role values ( 6,'STUDENT' );
-- insert into user_role values ( 7,'STUDENT' );
-- insert into user_role values ( 8,'STUDENT' );

