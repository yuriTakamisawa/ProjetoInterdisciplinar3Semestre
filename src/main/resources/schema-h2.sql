CREATE TABLE IF NOT EXISTS Produtos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    estado VARCHAR(50),
    custo DOUBLE PRECISION NOT NULL CHECK (custo > 0),
    quantidadeEstoque INT NOT NULL CHECK (quantidadeEstoque > 0),
    dataValidade DATE NOT NULL
);
