create table driver_licenses
(
    id             bigint not null
        constraint driver_licenses_pkey
            primary key,
    licence_id     varchar(255),
    license_status varchar(255)
);

alter table driver_licenses
    owner to kktxdkgyuaoidg;

create table passports
(
    id              bigint  not null
        constraint passports_pkey
            primary key,
    age             integer not null,
    birthplace      varchar(255),
    name            varchar(255),
    passport_number varchar(255),
    patronymic      varchar(255),
    sex             varchar(255),
    surname         varchar(255)
);

alter table passports
    owner to kktxdkgyuaoidg;

create table drivers
(
    id                 bigint not null
        constraint drivers_pkey
            primary key,
    driver_licenses_id bigint
        constraint fkl1hitjn7s55w9wrekuvfxkn83
            references driver_licenses,
    passport_id        bigint
        constraint fk10ls1s47nje2ul0i0miethn51
            references passports
);

alter table drivers
    owner to kktxdkgyuaoidg;

create table passengers
(
    id          bigint not null
        constraint passengers_pkey
            primary key,
    passport_id bigint
        constraint fk6l6w6g5w3aev4guv8b9d94ckh
            references passports
);

alter table passengers
    owner to kktxdkgyuaoidg;

create table luggage
(
    id           bigint  not null
        constraint luggage_pkey
            primary key,
    luggage_type varchar(255),
    name         varchar(255),
    weight       integer not null,
    passenger_id bigint
        constraint fkevi0rh6432rbs52qac92tqmjm
            references passengers
);

alter table luggage
    owner to kktxdkgyuaoidg;

create table stations
(
    id         bigint not null
        constraint stations_pkey
            primary key,
    head_chair varchar(255),
    name       varchar(255)
);

alter table stations
    owner to kktxdkgyuaoidg;

create table engineers
(
    id         bigint not null
        constraint engineers_pkey
            primary key,
    name       varchar(255),
    station_id bigint
        constraint fkt8lk9x6wm6o44v7sarid4h5s1
            references stations
);

alter table engineers
    owner to kktxdkgyuaoidg;

create table buses
(
    id          bigint  not null
        constraint buses_pkey
            primary key,
    capacity    integer not null,
    name        varchar(255),
    status      varchar(255),
    driver_id   bigint
        constraint fkehawq87sfla3c9m3anighxeaf
            references drivers,
    engineer_id bigint
        constraint fkdldq14pdjryhwxoas9q18t5j4
            references engineers
);

alter table buses
    owner to kktxdkgyuaoidg;

create table routes
(
    id               bigint not null
        constraint routes_pkey
            primary key,
    departure        varchar(255),
    departure_date   varchar(255),
    destination      varchar(255),
    destination_date varchar(255),
    bus_id           bigint
        constraint fkfifby6x0g0k9rmd26mdmef3vt
            references buses
);

alter table routes
    owner to kktxdkgyuaoidg;

create table tickets
(
    id           bigint  not null
        constraint tickets_pkey
            primary key,
    price        integer not null,
    passenger_id bigint
        constraint fk1ds262xq345nkvs5o9ptnftwr
            references passengers,
    route_id     bigint
        constraint fkjndmi4mev27gnbw3m61y1hb8q
            references routes
);

alter table tickets
    owner to kktxdkgyuaoidg;

