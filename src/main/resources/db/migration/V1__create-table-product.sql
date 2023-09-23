CREATE TABLE product (
    id SERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    price INT NOT NULL,
	active boolean NOT NULL
);