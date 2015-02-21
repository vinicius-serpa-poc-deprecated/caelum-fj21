create table contatos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  email VARCHAR(255),
  endereco VARCHAR(255),
  dataNascimento DATE,
  primary key (id)
);

create table tarefas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(255),
  finalizado BOOLEAN,
  dataFinalizacao DATE,
  primary key (id)
);

create table usuarios (
  login VARCHAR(255),
  senha VARCHAR(255)
);

insert into usuarios values ('admin', 'yetsnap');