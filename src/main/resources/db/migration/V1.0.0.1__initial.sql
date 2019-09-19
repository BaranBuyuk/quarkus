DROP TABLE IF EXISTS customers;

CREATE TABLE IF NOT EXISTS customers
(
    customer_id long         not null auto_increment,
    name        varchar(50)  not null,
    surname     varchar(50)  not null,
    email       varchar(50)  not null,
    country     varchar(100) not null,
    street      varchar(100) not null,
    city        varchar(100) not null,
    zipcode     long         not null

);

INSERT INTO customers (customer_id, name, surname, email, country, street, city, zipcode)
values (1, 'Baran', 'Büyük', 'baranbuyuk@gmail.com', 'Turkey', 'Ferah', 'İstanbul', 34056);

INSERT INTO customers (customer_id, name, surname, email, country, street, city, zipcode)
values (2, 'Baran 2', 'Büyük', 'baranbuyuk2@gmail.com', 'Turkey', 'Ferah', 'İstanbul', 34056);

INSERT INTO customers (customer_id, name, surname, email, country, street, city, zipcode)
values (3, 'Baran 3', 'Büyük', 'baranbuyuk3@gmail.com', 'Turkey', 'Ferah', 'İstanbul', 34056);

INSERT INTO customers (customer_id, name, surname, email, country, street, city, zipcode)
values (4, 'Baran 4', 'Büyük', 'baranbuyuk4@gmail.com', 'Turkey', 'Ferah', 'İstanbul', 34056);