create table cep_calls (
    id_call         binary(16) not null primary key default (uuid_to_bin(uuid())),
    created_at      datetime not null default current_timestamp,
    url             text not null,
    response        text not null,
    response_status text not null,
    response_time   bigint not null
);