create sequence user_seq start with 4 increment by 1;
alter sequence user_seq owned by users.id;