DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
                       id SERIAL NOT NULL PRIMARY KEY,
                       username VARCHAR (255) NOT NULL ,
                       password VARCHAR (255) NOT NULL ,
                       email VARCHAR (255) NOT NULL,
                       created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
)
