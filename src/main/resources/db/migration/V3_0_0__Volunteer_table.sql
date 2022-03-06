create table volunteer
(
    id       uuid not null
        constraint volunteer_pk
            primary key,
    "firstName"            varchar not null,
    "lastName"             varchar not null,
    email                  varchar not null,
    "mobilePhone"          varchar not null,
    "volunteerOrientation" bool    not null,
    "canineOrientation"    bool    not null,
    "felineOrientation"    bool    not null,
    "canineColorLevel"     varchar not null,
    "felineColorLevel"     varchar not null
);

create unique index volunteer_id_uindex
    on volunteer (id);