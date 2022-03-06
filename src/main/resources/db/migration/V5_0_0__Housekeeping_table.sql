create table "houseKept"
(
    id       uuid not null
        constraint housekept_pk
            primary key,
    user_id             int
        constraint housekept_users_id_fk
            references users
            on update cascade,
    "submitTimestamp"   timestamp,
    "h_cleanGroomRoom"  bool,
    "h_emptyWashKongs"  bool,
    "h_organizeVolArea" bool,
    h_laundry           bool,
    "h_groundsKeeping"  bool
);

create unique index housekept_id_uindex
    on "houseKept" (id);