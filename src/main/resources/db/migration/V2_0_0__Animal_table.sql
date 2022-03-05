create table animal
(
    id           serial
        constraint animal_pk
            primary key,
    species      varchar   not null,
    name         varchar   not null,
    "colorLevel" varchar   not null,
    "intakeDate" timestamp not null,
    "exitDate"   timestamp not null,
    adoptable    bool      not null,
    "rescueOnly" bool      not null
);

create unique index animal_id_uindex
    on animal (id);