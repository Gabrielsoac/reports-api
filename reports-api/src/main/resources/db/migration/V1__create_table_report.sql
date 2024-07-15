CREATE TABLE report (
    id varchar(255) UNIQUE NOT NULL PRIMARY KEY,
    date DATE NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    edited BOOLEAN DEFAULT FALSE
);