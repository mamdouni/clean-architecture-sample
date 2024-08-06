DROP TABLE IF EXISTS "order" CASCADE;

CREATE TABLE "order"
(
    id uuid not null,
    customer_email varchar(256) not null,
    status varchar(10) not null,
    CONSTRAINT order_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS order_products CASCADE;

CREATE TABLE order_products
(
    id bigint NOT NULL,
    order_id uuid NOT NULL,
    variant_id uuid NOT NULL,
    quantity integer NOT NULL,
    sub_total numeric(10,2) NOT NULL,
    CONSTRAINT order_products_pkey PRIMARY KEY (id),
    CONSTRAINT fk_variant
        FOREIGN KEY(variant_id)
            REFERENCES variant(id),
    CONSTRAINT fk_order
        FOREIGN KEY(order_id)
            REFERENCES "order"(id)
);
