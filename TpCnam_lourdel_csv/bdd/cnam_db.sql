DROP DATABASE IF EXISTS cnam_db;
CREATE DATABASE cnam_db;
use cnam_db;

CREATE TABLE utilisateur(
	Id int(11) not null AUTO_INCREMENT,
	Nom varchar(256) not null,
	Prenom varchar(256) not null,
	Email varchar(256) not null unique,
	Sexe varchar(1) not null,
	constraint pk_id primary key (Id)
);