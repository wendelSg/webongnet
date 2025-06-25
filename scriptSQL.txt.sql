--TCC SCRIPT ONGNET 6.0  Banco ok
use master
DROP DATABASE IF EXISTS Ongnet;

CREATE DATABASE Ongnet;

GO

USE Ongnet;

GO


-- Tabela ONG ok

CREATE TABLE Ong (

   id INT IDENTITY (1,1) PRIMARY KEY,

   nome VARCHAR(60) NOT NULL,

   cnpj VARCHAR(18) UNIQUE NOT NULL,

   responsavel VARCHAR(60) NOT NULL,

   cep VARCHAR(9) NOT NULL,

   numero VARCHAR(5) NOT NULL,

   telefone VARCHAR(14) NOT NULL,

   email VARCHAR(100) UNIQUE NOT NULL,

   site VARCHAR(100) UNIQUE,

   atividade VARCHAR(150),

   missao VARCHAR(150),

   imagem VARBINARY(MAX),

   cod_status BIT

);

-- Tabela Usuario ok

CREATE TABLE Usuario (

   id INT IDENTITY (1,1) PRIMARY KEY,

   nome VARCHAR(60)NOT NULL,
   
   email VARCHAR(50) NOT NULL,

   password VARCHAR(255) NOT NULL,
   
   cep VARCHAR(9) ,
   
   telefone VARCHAR(14),
   
   cpf VARCHAR(14) UNIQUE,

   imagem VARBINARY(MAX),

   cod_status BIT,

   role VARCHAR(20) NOT NULL,

   ong_id INT,

   FOREIGN KEY (ong_id) REFERENCES ong(id)

);
GO


-- Tabela Doacao ok

CREATE TABLE Doacao (

   id INT IDENTITY (1,1) PRIMARY KEY,

   data DATE DEFAULT CURRENT_TIMESTAMP, --registrar automaticamente a data e hora de quando o registro   criado.

   cod_status BIT,
   
   usuario_id INT NOT NULL,

   ong_id INT NOT NULL,
   
   FOREIGN KEY (usuario_id) REFERENCES usuario(id),

   FOREIGN KEY (ong_id) REFERENCES ong(id)

);

GO

-- Tabela Item ok

CREATE TABLE Item (

   id INT IDENTITY (1,1)PRIMARY KEY,

   descricao VARCHAR(15) NOT NULL UNIQUE,

   categoria VARCHAR(15) NOT NULL,

   cod_status BIT

);

GO

-- Tabela Item_Doacao (Relacionamento entre Item e Doacao) ok

CREATE TABLE Item_doacao (

   id INT IDENTITY (1,1)PRIMARY KEY,

   quantidade INT NOT NULL,

   doacao_id INT NOT NULL,

   item_id INT NOT NULL,

   FOREIGN KEY (doacao_id) REFERENCES doacao(id),

   FOREIGN KEY (item_id) REFERENCES item(id)

);

CREATE TABLE Ong_item (

   id INT IDENTITY (1,1)PRIMARY KEY,

   data_expiracao DATE NOT NULL,

   qtd_estoque INT,

   meta INT NOT NULL,

   cod_status BIT,

   item_id INT NOT NULL,

   ong_id INT NOT NULL,

   FOREIGN KEY (ong_id) REFERENCES ong(id),

   FOREIGN KEY (item_id) REFERENCES item(id)

 );

 CREATE TABLE Tokens (

   id INT IDENTITY (1,1)PRIMARY KEY,

   revoked  BIT NOT NULL,

   expired  BIT NOT NULL,

   token VARCHAR(255) NOT NULL,

   token_type VARCHAR(255),

   usuario_id INT NOT NULL,

   FOREIGN KEY (usuario_id) REFERENCES usuario(id)

);


GO

	select * from Ong
/*
INSERT INTO Ong (nome,cnpj,responsavel,cep,numero,telefone,email,site,atividade,missao,cod_status) VALUES
	('Instituto Proa',
	'08.172.505/0001-45',
	'Wiliam Ramos',
	'04538-133',
	'4055',
	'+5594820473562',
	'contato@proa.org.br',
	'www.site.teste.com.br',
	'Oferecer aos acolhidos, assistidos e a comunidade uma vida mais feliz, digna e de melhor qualidade.',
	NULL,
	1)

INSERT INTO Ong (nome,cnpj,responsavel,cep,numero,telefone,email,site,atividade,missao,cod_status) VALUES
	('Instituto Viva Bem',
	'10.122.902/0004-98',
	'Paula Rodrigues Da Silva Ramos',
	'06627-133',
	'45',
	'+5511940028922',
	'contato@viva.bem.com.br',
	'www.viva.bem.com.br',
	NULL,
	'Fazem parte da nossa ess�ncia a inclus�o social, o acolhimento institucional e a valorização à diversidade.',
	0	)
	
INSERT INTO Ong (nome,cnpj,responsavel,cep,numero,telefone,email,site,atividade,missao,cod_status) VALUES
	('Instituto Calibri',
	'80.162.642/0001-95',
	'Sergio Fernandes',
	'06657-065',
	'45',
	'+5511940839292',
	'contato@calibri.com.br',
	'www.calibri.bem.com.br',
	'Oferecer aos acolhidos, assistidos e a comunidade uma vida mais feliz, digna e de melhor qualidade.',
	'Fazem parte da nossa ess�ncia a inclus�o social, o acolhimento institucional e a valoriza��o � diversidade.',
	1)*/


	select * from Usuario
/*
INSERT INTO Usuario (nome,email,password,cep,telefone,cpf,cod_status,role,ong_id) VALUES
	('Wiliam Ramos',
	'fulano5detal@gmail.com',
	'ra5fa5R$afst',
	'04538-133',
	'+5511944042292',
	'412.960.617.39',
	1,
	'REPRESENTANTEONG',
	1)

INSERT INTO Usuario (nome,email,password,cep,telefone,cpf,cod_status,role) VALUES
	('Ciclano Silva',
	'ciclano.sil.49@gmail.com',
	'p2jdu@gamaHa',
	'06664-042',
	'+5512829314285',
	'648.524.785.42',
	1,
	'DOADOR'
	)

	INSERT INTO Usuario (nome,email,password,cep,telefone,cpf,cod_status,role) VALUES
	('Nathalia',
	'Nath.49@gmail.com',
	'p2jdu@gamaHa',
	'06664-042',
	'+5512829454285',
	'148.558.125.47',
	1,
	'ADMIN'
	)
*/


	select * from Item
/*
INSERT INTO Item (descricao,categoria,cod_status) VALUES
	('Arroz',
	'Alimento',
	1)

	INSERT INTO Item (descricao,categoria,cod_status) VALUES
	('Macarrão',
	'Alimento',
	1)

	INSERT INTO Item (descricao,categoria,cod_status) VALUES
	('Feijão',
	'Alimento',
	1)

	INSERT INTO Item (descricao,categoria,cod_status) VALUES
	('Leite em pó',
	'Alimento',
	1)

	INSERT INTO Item (descricao,categoria,cod_status) VALUES
	('Oleo',
	'Alimento',
	1)
*/


	select * from Doacao
/*
	INSERT INTO Doacao (usuario_id,ong_id) VALUES
	(2,
	1)

	INSERT INTO Doacao (usuario_id,ong_id) VALUES
	(1,
	1)

	INSERT INTO Doacao (usuario_id,ong_id) VALUES
	(3,
	3)
*/

	
	select * from Item_doacao
/*
	INSERT INTO Item_doacao (doacao_id,item_id,quantidade) VALUES
	(1, 
	3, 
	10)

	 INSERT INTO Item_doacao (doacao_id,item_id,quantidade) VALUES
	(2, 
	1, 
	12)

	 INSERT INTO Item_doacao (doacao_id,item_id,quantidade) VALUES
	(4, 
	2, 
	7)
*/
	select * from Ong_item
/*	
	INSERT INTO Ong_item (data_expiracao, qtd_estoque, meta, cod_status, item_id, ong_id) VALUES
	('2025-07-20', 0, 100, 1, 2, 1)

	INSERT INTO Ong_item (data_expiracao, qtd_estoque, meta, cod_status, item_id, ong_id) VALUES
	('2025-07-20', 0, 100, 1, 2, 1)

		select * from Item_doacao
		select * from Ong_item
		select * from Doacao
		select * from Item
		select * from Usuario
		select * from Ongb   