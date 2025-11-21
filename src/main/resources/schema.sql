CREATE SCHEMA menu_db AUTHORIZATION postgres;

CREATE TYPE menu_db.users AS (
	id serial4,
	nom varchar(50),
	prenom varchar(50));

CREATE TABLE menu_db.users ( id serial4 NOT NULL, nom varchar(50) NOT NULL,
    prenom varchar(50) NOT NULL, CONSTRAINT users_pkey PRIMARY KEY (id));
