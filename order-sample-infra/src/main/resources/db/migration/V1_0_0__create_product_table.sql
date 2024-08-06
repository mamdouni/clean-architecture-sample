DROP TABLE IF EXISTS product CASCADE;

CREATE TABLE product
(
    id uuid primary key,
    name varchar(256) not null,
    description text,
    price numeric(10,2) not null,
    price_currency varchar(3) not null, -- e.g. EUR, USD
    constraint price_non_neg check (price >= 0)
);