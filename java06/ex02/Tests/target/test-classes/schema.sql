CREATE TABLE product (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    name VARCHAR(255),
    price INT
);