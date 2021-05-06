ALTER TABLE paciente
    ADD logradouro VARCHAR(30),
    ADD numero VARCHAR(30),
    ADD complemento VARCHAR(30),
    ADD bairro VARCHAR(30),
    ADD cep VARCHAR(30),
    ADD cidade VARCHAR(30),
    ADD estado VARCHAR(30)
;

INSERT INTO paciente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Fabio', 'Rua Cervantes', '101', null, 'Brasil', '11.223-11', 'São Paulo', 'SP', true);
INSERT INTO paciente (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Ludmila', 'Rua do Mobile', '780', null, 'Brasil', '22.321-45', 'São Paulo', 'SP', true);
