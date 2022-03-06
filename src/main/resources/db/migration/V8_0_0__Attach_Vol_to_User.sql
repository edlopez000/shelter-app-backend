alter table users
    add volunteer_id uuid;

create unique index users_volunteer_id_uindex
    on users (volunteer_id);

alter table users
    add constraint users_volunteer_id_fk
        foreign key (volunteer_id) references volunteer;