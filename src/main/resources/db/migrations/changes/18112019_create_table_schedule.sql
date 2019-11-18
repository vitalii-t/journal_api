create table schedule
(
    id         bigint primary key not null,
    begin_time time               not null,
    end_time   time               not null
)