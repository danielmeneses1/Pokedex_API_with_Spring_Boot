CREATE DATABASE pokedex_database;

use pokedex_database;

CREATE TABLE pokemon (
    id INT PRIMARY KEY auto_increment,
    nome VARCHAR(100),
    tipo VARCHAR(50),
    altura Double,
    peso Double
);


