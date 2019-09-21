
CREATE TABLE IF NOT EXISTS customers
(
    customer_id  bigserial primary key ,
    name         varchar(50)  not null,
    surname      varchar(50)  not null,
    email        varchar(50)  not null,
    country      varchar(100) not null,
    street       varchar(100) not null,
    city         varchar(100) not null,
    zipcode      int          not null,
    created_at   timestamp default current_timestamp,
    updated_date timestamp    null

);