create table week
(
    id           serial primary key not null,
    week_day     character varying(100),
    lesson_index bigint,
    subject_name character varying(100),
    week_type    character varying(100)
)