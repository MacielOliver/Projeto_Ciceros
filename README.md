# Projeto_Ciceros
 Repositório do Trabalho de Quarta

Script Banco de Dados

CREATE DATABASE db_cicero;

USE db_cicero;

CREATE TABLE tb_login(
	id_log_pk INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(30) UNIQUE,
    senha VARCHAR(20),
    pergunta VARCHAR(70),
    resposta VARCHAR(40)
);

INSERT INTO tb_login(usuario, senha, pergunta, resposta) VALUES ("root", "123","Qual o nome do seu carro favorito ?", "Opara SS");

CREATE TABLE tb_cliente(
	id_cli_pk INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
	endereco VARCHAR(90),
    telefone VARCHAR(25)
);
INSERT INTO tb_cliente (nome,endereco,telefone) VALUES ("Sem cadastro","Null","Null");

INSERT INTO tb_cliente (nome,endereco,telefone) VALUES ("Lucas","Rua nenhuma","456789");

CREATE TABLE tb_cardapio(
	id_car_pk INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    descricao VARCHAR(120),
	preco DOUBLE
);

INSERT INTO tb_cardapio (nome, descricao,preco ) values ("X-Salada", "Maionese, KatChup, Pão, Gergilin, Hamburguer,Alface", 22.50);

CREATE TABLE tb_pedido(
	id_ped_pk INT AUTO_INCREMENT PRIMARY KEY,
	observacao VARCHAR(200),
    dia_pedido DATE,
    cliente INT ,
    CONSTRAINT dep_fk FOREIGN KEY (cliente) REFERENCES tb_cliente(id_cli_pk)
);

INSERT INTO tb_pedido (observacao,dia_pedido,cliente) VALUES ("Pão de Ló", "2020-07-05",2);
INSERT INTO tb_pedido (observacao,dia_pedido,cliente) VALUES ("Pão de Frios", "2027-07-09",1);


CREATE TABLE tb_pagamento(
	id_pag_pk INT AUTO_INCREMENT PRIMARY KEY,
    forma_Pagamento VARCHAR(40),
    valor DOUBLE,
    dia_compra DATE,
    pedido INT NOT NULL,
    CONSTRAINT ped_fk FOREIGN KEY (pedido) REFERENCES tb_pedido(id_ped_pk)
);






