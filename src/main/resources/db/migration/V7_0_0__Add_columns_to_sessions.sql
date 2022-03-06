alter table sessions
    add kennel_out pg_enum;

alter table sessions
    add kennel_through pg_enum;

alter table sessions
    add kennel_in pg_enum;

alter table sessions
    add shyness pg_enum;

alter table sessions
    add leash pg_enum;

alter table sessions
    add mouthing pg_enum;

alter table sessions
    add jumping pg_enum;

alter table sessions
    add c_walk_peed bool default false;

alter table sessions
    add c_walk_pooped bool default false;

alter table sessions
    add c_seems_house_trained bool default false;