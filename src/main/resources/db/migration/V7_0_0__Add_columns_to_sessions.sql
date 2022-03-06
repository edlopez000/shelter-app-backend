alter table sessions
    add kennel_out varchar;

alter table sessions
    add kennel_through varchar;

alter table sessions
    add kennel_in varchar;

alter table sessions
    add shyness varchar;

alter table sessions
    add leash varchar;

alter table sessions
    add mouthing varchar;

alter table sessions
    add jumping varchar;

alter table sessions
    add c_walk_peed bool default false;

alter table sessions
    add c_walk_pooped bool default false;

alter table sessions
    add c_seems_house_trained bool default false;