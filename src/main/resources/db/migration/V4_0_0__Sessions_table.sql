create table sessions
(
    id                serial
        constraint sessions_pk
            primary key,
    volunteer_id      int       not null
        constraint sessions_volunteer_id_fk
            references volunteer
            on update cascade,
    animal_id         int
        constraint sessions_animal_id_fk
            references animal
            on update cascade,
    "submitTimestamp" timestamp not null
);

create unique index sessions_id_uindex
    on sessions (id);