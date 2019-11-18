create table week
(
    id           serial primary key not null,
    subject_name character varying(100),
    week_type    character varying(100),
    week_day     character varying(100),
    lesson_index bigint
)