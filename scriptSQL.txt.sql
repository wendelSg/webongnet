--TCC SCRIPT ONGNET 4.0 (length de acordo com api)
use master
DROP DATABASE IF EXISTS Ongnet;

CREATE DATABASE Ongnet;

GO

USE Ongnet;

GO

-- Tabela Usuario ok

CREATE TABLE Usuario (

   id INT IDENTITY (1,1) PRIMARY KEY,

   nome VARCHAR(60) NOT NULL,
   
   email VARCHAR(50) UNIQUE,

   password VARCHAR(255) NOT NULL,
   
   cep VARCHAR(9) NOT NULL,
   
   telefone VARCHAR(14),
   
   cpf VARCHAR(14) NOT NULL UNIQUE,

   cod_status BIT NOT NULL

);
GO

-- Tabela ONG ok

CREATE TABLE Ong (

   id INT IDENTITY (1,1) PRIMARY KEY,

   nome VARCHAR(60) NOT NULL,

   cnpj VARCHAR(18) UNIQUE NOT NULL,

   responsavel VARCHAR(60) NOT NULL,

   cep VARCHAR(9) NOT NULL,

   numero VARCHAR(5) NOT NULL,

   telefone VARCHAR(14),

   email VARCHAR(100) UNIQUE NOT NULL,

   site VARCHAR(100) UNIQUE,

   cod_status BIT NOT NULL

);

GO

-- Tabela Doacao ok

CREATE TABLE Doacao (

   id INT IDENTITY (1,1) PRIMARY KEY,

   data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, --registrar automaticamente a data e hora de quando o registro   criado.

   cod_status BIT,
   
   usuario_id INT,

   ong_id INT,
   
   FOREIGN KEY (usuario_id) REFERENCES usuario(id),

   FOREIGN KEY (ong_id) REFERENCES ong(id)

);

GO

-- Tabela Item ok

CREATE TABLE Item (

   id INT IDENTITY (1,1)PRIMARY KEY,

   descricao VARCHAR(15),
   
   qtdeEstoque INT,

   meta INT,

   cod_status BIT NOT NULL

);

GO

-- Tabela Item_Doacao (Relacionamento entre Item e Doacao) ok

CREATE TABLE Item_doacao (

   id INT IDENTITY (1,1)PRIMARY KEY,

   doacao_id INT NOT NULL,

   item_id INT NOT NULL,

   quantidade INT NOT NULL,

   FOREIGN KEY (doacao_id) REFERENCES doacao(id),

   FOREIGN KEY (item_id) REFERENCES item(id)

);

GO

	select * from Ong
/*
INSERT INTO Ong (nome,cnpj,responsavel,cep,numero,telefone,email,site,cod_status) VALUES
	('Instituto Proa',
	'08.172.505/0001-45',
	'Wiliam Ramos',
	'04538-133',
	'4055',
	null,
	'contato@proa.org.br',
	'www.site.teste.com.br',
	1)
INSERT INTO Ong (nome,cnpj,responsavel,cep,numero,telefone,email,site,cod_status) VALUES
	('Instituto Viva Bem',
	'10.122.902/0004-98',
	'Paula Rodrigues Da Silva Ramos',
	'06627-133',
	'45',
	'+5511940028922',
	'contato@viva.bem.com.br',
	'www.viva.bem.com.br',
	0)*/


	select * from Usuario
/*
INSERT INTO Usuario (nome,email,password,cep,telefone,cpf,cod_status) VALUES
	('Fulano de Tal',
	'fulano5detal@gmail.com',
	'ra5fa5R$afst',
	'04538-133',
	'+5511944042292',
	'412.960.617.39',
	1)
INSERT INTO Usuario (nome,email,password,cep,telefone,cpf,cod_status) VALUES
	('Ciclano Silva',
	'ciclano.sil.49@gmail.com',
	'p2jdu@gamaHa',
	'06664-042',
	'+5512829314285',
	'648.524.785.42',
	0)
*/


	select * from Item
/*
INSERT INTO Item (descricao,qtdeEstoque,meta,cod_status) VALUES
	('Arroz',
	1,
	100,
	1)

	INSERT INTO Item (descricao,qtdeEstoque,meta,cod_status) VALUES
	('Macarr o',
	0,
	20,
	1)

	INSERT INTO Item (descricao,qtdeEstoque,meta,cod_status) VALUES
	('Agasalho Masc.',
	3,
	30,
	1)
*/


	select * from Doacao
/*
	INSERT INTO Doacao (cod_status,usuario_id,ong_id) VALUES
	(1,
	2,
	1)

	INSERT INTO Doacao (cod_status,usuario_id,ong_id) VALUES
	(1,
	2,
	2)

	INSERT INTO Doacao (cod_status,usuario_id,ong_id) VALUES
	(1,
	1,
	2)
*/

	
	select * from Item_doacao
/*
	INSERT INTO Item_doacao (doacao_id,item_id,quantidade) VALUES
	(1, 
	1, 
	1)

	 INSERT INTO Item_doacao (doacao_id,item_id,quantidade) VALUES
	(3, 
	4, 
	3)

	 INSERT INTO Item_doacao (doacao_id,item_id,quantidade) VALUES
	(3, 
	1, 
	1)
*/
