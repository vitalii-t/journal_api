create table schedule
(
    id         bigserial not null,
    begin_time time,
    end_time   time,
    primary key (id)
)