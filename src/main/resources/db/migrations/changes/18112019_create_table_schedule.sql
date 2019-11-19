create table schedule
(
    id         serial primary key not null,
    begin_time time               not null,
    end_time   time               not null
)