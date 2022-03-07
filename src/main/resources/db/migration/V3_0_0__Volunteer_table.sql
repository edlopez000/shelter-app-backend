create table volunteer
(
    id       uuid not null
        constraint volunteer_pk
            primary key,
    first_name            varchar not null,
    last_name             varchar not null,
    email                 varchar not null,
    mobile_phone          varchar not null,
    volunteer_orientation bool    not null,
    canine_orientation    bool    not null,
    feline_orientation    bool    not null,
    canine_color_level    varchar not null,
    feline_color_level    varchar not null
);

create unique index volunteer_id_uindex
    on volunteer (id);