create table medicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre varchar(100) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    documento varchar(10) NOT NULL UNIQUE,
    especialidad varchar(100) NOT NULL,
    calle varchar(100) NOT NULL,
    distrito varchar(100) NOT NULL,
    complemento varchar(100),
    numero varchar(20),
    ciudad varchar(100) NOT NULL,
    PRIMARY KEY (id)
)