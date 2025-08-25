# 🏠 Sistema Imobiliário

## 👥 Equipe
| Integrante | E-mail |
|------------|--------|
| João Rosa  | joaovitorrosamacahdo@hotmail.com|
| Allan    |- |

---

## ⚙️ Configurações
| Item            | Valor              |
|-----------------|--------------------|
| Banco de Dados  | MySQL              |
| Schema          | ImobDataBase       |
| Linguagem       | Java (JDK 17+)     |
| Gerenciador     | Maven              |

---

## 📂 Estrutura do Projeto

            └── main/java/imobiliaria
            ├── dao
            │ ├── ClienteDAO.java
            │ ├── ImovelDAO.java
            │ └── ContratoDAO.java
            │
            ├── database
            │ ├── ConnectionFactory.java
            │ └── DatabaseCreator.java
            │
            ├── model
            │ ├── Cliente.java
            │ ├── Imovel.java
            │ └── Contrato.java
            │
            └── App.java

yaml
Copiar
Editar

---

## 📖 Funcionalidades
- **Cliente**
  - Cadastro de cliente
  - Listagem de clientes

- **Imóvel**
  - Cadastro de imóvel
  - Listagem de imóveis

- **Contrato**
  - Criação de contrato (ligando cliente + imóvel)
  - Listagem de contratos

- **Relatórios**
  - Exibe todos os clientes, imóveis e contratos cadastrados

---

## 📊 Diagrama de Classes (UML)

<img width="1090" height="730" alt="UML-Imob" src="https://github.com/user-attachments/assets/ef2d4c62-1499-4639-b25d-d971d13eeb7f" />


---

## 📈 Diagrama MER

<img width="387" height="369" alt="MER-Imob1" src="https://github.com/user-attachments/assets/737c6e85-7713-47f3-b954-6382c4ea3fda" />

---

## 🛠️ Instruções SQL

Criação do schema e tabelas no MySQL:

```sql
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
```
## ▶️ Como Executar
Configure o MySQL rodando o script SQL acima

Ajuste o ConnectionFactory.java com seu usuário/senha do banco

Compile e rode o projeto com Maven ou direto na IDE (IntelliJ/Eclipse)

Execute a classe App.java

Use o menu interativo para cadastrar e listar clientes, imóveis e contratos

## 📌 Observações
O projeto utiliza DAO (Data Access Object) para abstrair acesso ao banco.

O DatabaseCreator garante que as tabelas sejam criadas automaticamente.

O menu interativo no App.java facilita testes diretamente pelo terminal.
