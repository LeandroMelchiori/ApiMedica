create table medicos(
    id BIGINT NOT NULL auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null ,
    documento varchar(6) not null unique,
    especialidad varchar(100) not null ,
    calle varchar(100) not null ,
    distrito varchar (100),
    ciudad varchar(100) not null ,
    numero varchar(20),
    complemento varchar(100),



    primary key(id)
);
