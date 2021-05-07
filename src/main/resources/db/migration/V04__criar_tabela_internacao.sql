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


INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste9', '2020-12-05', null, 30.00, '', 'ELETIVA' , 20, 1);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste10', '2020-12-05', null, 30.00, '', 'ELETIVA', 21, 2);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste1', '2021-01-01', null, 10.00, '', 'ELETIVA',  22, 3);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste2', '2021-01-02', null, 30.00, '', 'ELETIVA',  23, 4);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste3', '2021-02-06', null, 10.00, '', 'ELETIVA',  21, 5);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste4', '2021-02-05', null, 30.00, '', 'ELETIVA',  25, 6);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste5', '2021-03-06', null, 10.00, '', 'ELETIVA',  23, 7);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste6', '2021-03-05', null, 30.00, '', 'ELETIVA',  21, 8);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste7', '2021-04-06', null, 10.00, '', 'ELETIVA',  23, 9);
INSERT INTO internacao (justificativa, data_internacao, data_alta, valor, observacao, tipo_internacao, id_especialidade, id_paciente) values ('teste8', '2021-04-05', null, 30.00, '', 'ELETIVA',  22, 10);
