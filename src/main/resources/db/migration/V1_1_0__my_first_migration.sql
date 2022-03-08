create table users
(
    id       serial
        constraint users_pk
            primary key,
    name     varchar not null,
    username varchar not null,
    email    varchar not null,
    password varchar not null,
    enabled  bool default true
);

create unique index users_id_uindex
    on users (id);