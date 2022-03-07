create table sessions
(
    id       uuid not null
        constraint sessions_pk
            primary key,
    volunteer_id      uuid       not null
        constraint sessions_volunteer_id_fk
            references volunteer
            on update cascade,
    animal_id         uuid
        constraint sessions_animal_id_fk
            references animal
            on update cascade,
    submit_timestamp timestamp not null,
    kennel_out       varchar not null,
    kennel_through   varchar not null,
    kennel_in        varchar not null,
    shyness          varchar not null,
    leash            varchar not null,
    mouthing         varchar not null,
    jumping          varchar not null,
    c_walk_peed      bool default false,
    c_walk_pooped    bool default false,
    c_house_trained  bool default false

);

create unique index sessions_id_uindex
    on sessions (id);