-- init.sql

-- Adicionando um novo usuário
CREATE USER  WITH PASSWORD 'userSD';

-- Criando um banco de dados e atribuindo permissões ao novo usuário
CREATE DATABASE lockdb;
GRANT ALL PRIVILEGES ON DATABASE novo_banco TO novo_usuario;
