CREATE TABLE customers
(
    id             VARCHAR(36) NOT NULL,
    created_at     TIMESTAMP   NOT NULL,
    updated_at     TIMESTAMP   NOT NULL,
    name           VARCHAR(255),
    document_id    VARCHAR(255),
    sell_on_credit BOOLEAN,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE customers_orders
(
    customer_id VARCHAR(36) NOT NULL,
    orders_id   VARCHAR(36) NOT NULL
);

CREATE TABLE employees
(
    id          VARCHAR(36) NOT NULL,
    created_at  TIMESTAMP   NOT NULL,
    updated_at  TIMESTAMP   NOT NULL,
    name        VARCHAR(255),
    document_id VARCHAR(255),
    salary      DECIMAL,
    email       VARCHAR(255),
    password    VARCHAR(255),
    role        VARCHAR(255),
    is_active   BOOLEAN,
    other_field VARCHAR(255),
    CONSTRAINT pk_employees PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id          VARCHAR(36) NOT NULL,
    created_at  TIMESTAMP   NOT NULL,
    updated_at  TIMESTAMP   NOT NULL,
    discount    DECIMAL,
    total_price DECIMAL,
    customer_id VARCHAR(255),
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE orders_order_items
(
    order_id       VARCHAR(36) NOT NULL,
    order_items_id VARCHAR(36) NOT NULL,
    CONSTRAINT pk_orders_orderitems PRIMARY KEY (order_id, order_items_id)
);

CREATE TABLE products
(
    id                 VARCHAR(36) NOT NULL,
    created_at         TIMESTAMP   NOT NULL,
    updated_at         TIMESTAMP   NOT NULL,
    name               VARCHAR(255),
    description        VARCHAR(255),
    price              DECIMAL,
    discount           DECIMAL,
    category           VARCHAR(255),
    available_in_stock INT,
    is_active          BOOLEAN,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE products_order_items
(
    product_id     VARCHAR(36) NOT NULL,
    order_items_id VARCHAR(36) NOT NULL,
    CONSTRAINT pk_products_orderitems PRIMARY KEY (product_id, order_items_id)
);

ALTER TABLE customers_orders
    ADD CONSTRAINT uc_customers_orders_cuidorid UNIQUE (customer_id, orders_id);

ALTER TABLE orders_order_items
    ADD CONSTRAINT uc_orders_order_items_oridorid UNIQUE (order_id, order_items_id);

ALTER TABLE products_order_items
    ADD CONSTRAINT uc_products_order_items_pridorid UNIQUE (product_id, order_items_id);

ALTER TABLE customers_orders
    ADD CONSTRAINT fk_cusord_on_customer FOREIGN KEY (customer_id) REFERENCES customers (id);

ALTER TABLE customers_orders
    ADD CONSTRAINT fk_cusord_on_order FOREIGN KEY (orders_id) REFERENCES orders (id);

ALTER TABLE orders_order_items
    ADD CONSTRAINT fk_ordordite_on_order FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE orders_order_items
    ADD CONSTRAINT fk_ordordite_on_order_item FOREIGN KEY (order_items_id) REFERENCES orders (id);

ALTER TABLE products_order_items
    ADD CONSTRAINT fk_proordite_on_order_item FOREIGN KEY (order_items_id) REFERENCES orders (id);

ALTER TABLE products_order_items
    ADD CONSTRAINT fk_proordite_on_product FOREIGN KEY (product_id) REFERENCES products (id);