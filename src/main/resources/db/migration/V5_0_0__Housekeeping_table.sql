create table housekept
(
    id       uuid not null
        constraint housekept_pk
            primary key,
    volunteer_id             uuid not null
        constraint housekept_volunteer_id_fk
            references volunteer
            on update cascade,
    submit_timestamp  timestamp not null,
    clean_groom_room  bool,
    empty_wash_kongs  bool,
    organize_vol_area bool,
    laundry           bool,
    grounds_keeping   bool
);

create unique index housekept_id_uindex
    on housekept (id);