-- Criar schema
CREATE DATABASE IF NOT EXISTS ImobDataBase;
USE ImobDataBase;

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL
);

-- Tabela Imovel
CREATE TABLE IF NOT EXISTS Imovel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    endereco VARCHAR(200) NOT NULL,
    valor DECIMAL(10,2) NOT NULL
);

-- Tabela Contrato
CREATE TABLE IF NOT EXISTS Contrato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    imovel_id INT,
    data DATE,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (imovel_id) REFERENCES Imovel(id)
);