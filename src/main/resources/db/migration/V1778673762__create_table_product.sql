-- create_table_product

CREATE TABLE product (
    id bigserial NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price NUMERIC(10, 2) NOT NULL,
    quantity INTEGER NOT NULL,
    CONSTRAINT product_new_pk PRIMARY KEY (id)
);
