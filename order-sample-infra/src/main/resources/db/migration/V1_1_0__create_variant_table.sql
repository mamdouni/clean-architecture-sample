DROP TABLE IF EXISTS variant CASCADE;

CREATE TABLE variant
(
    id varchar(256) primary key,
    product_id uuid not null,
    label text not null,
    size varchar(128) not null,
    color varchar(128) not null,
    CONSTRAINT fk_product
        FOREIGN KEY(product_id)
            REFERENCES product(id)
);