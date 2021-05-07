CREATE TABLE paciente
  (
        id BIGINT(20) PRIMARY KEY auto_increment
     ,nome VARCHAR(50) NOT NULL
     ,ativo BOOLEAN
) ;

INSERT INTO paciente
            (nome, ativo)
     VALUES ('amelia', true),
            ('bruna', true),
            ('carla', true),
            ('daniel', true),
            ('elaine', true),
            ('fabio', true),
            ('gustavo', true),
            ('helton', true),
            ('ilda', true),
            ('juliano', true),
            ('ludmila', true),
            ('marcia', true);
