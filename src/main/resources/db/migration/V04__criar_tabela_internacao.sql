CREATE TABLE internacao (
                            id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
                            justificativa VARCHAR(50) NOT NULL,
                            data_internacao DATE NOT NULL,
                            data_alta DATE,
                            valor DECIMAL(10,2) NOT NULL,
                            observacao VARCHAR(100),
                            tipo_internacao VARCHAR(20) NOT NULL,
                            id_especialidade BIGINT(20) NOT NULL,
                            id_paciente BIGINT(20) NOT NULL,
                            FOREIGN KEY (id_especialidade) REFERENCES especialidade(id),
                            FOREIGN KEY (id_paciente) REFERENCES paciente(id)
) ;


INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste1', '2021-05-06', null, 10.00, '', 'ELETIVA', 20, 1);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste2', '2021-05-05', null, 30.00, '', 'ELETIVA', 20, 2);
