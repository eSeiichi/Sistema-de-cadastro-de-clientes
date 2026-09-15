create schema lpcy;
use lpcy;
create table clientes(
	id int not null auto_increment,
    nome varchar(100) not null,
    cidade varchar(100),
    primary key(id)
    );
    
create table usuario(
	id int not null auto_increment,
    username varchar(50) not null,
    senha varchar(50) not null,
    cargo enum('user','admin'),
    primary key(id)
);

insert into usuario (username,senha,cargo) values ('adm','123','admin');
select cargo from usuario where (username = 'adm' and senha = '123');
select * from usuario;
select * from clientes;