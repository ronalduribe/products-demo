CREATE TYPE currency AS ENUM ('USD', 'EUR', 'JPY', 'GBP', 'CAD', 'AUD');

CREATE TABLE IF NOT EXISTS prices (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    brand_id INT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list VARCHAR(50) NOT NULL,
    product_id INTEGER NOT NULL,
    priority INTEGER NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    curr currency NOT NULL
);

ALTER TABLE prices ADD CONSTRAINT fk_brand_id FOREIGN KEY(brand_id) REFERENCES brands(id);

