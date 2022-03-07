create table animal
(
    id       uuid not null
        constraint animal_pk
            primary key,
    species      varchar   not null,
    name         varchar   not null,
    color_level  varchar   not null,
    intake_date  timestamp not null,
    exit_date    timestamp not null,
    adoptable    bool      not null,
    rescue_only  bool      not null
);

create unique index animal_id_uindex
    on animal (id);