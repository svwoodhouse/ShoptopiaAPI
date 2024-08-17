CREATE TABLE IF NOT EXISTS Product (
    id INT NOT NULL,
    title varchar(250) NOT NULL,
    product_description varchar(250) NOT NULL,
    category varchar(50) NOT NULL,
    brand varchar(50) NOT NULL,
    price double NOT NULL,
    image_url varchar(250),
    seller varchar(50),
    PRIMARY KEY (id)
);