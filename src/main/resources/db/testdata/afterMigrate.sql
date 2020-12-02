delete from empresa_moeda;
delete from empresa;
delete from moeda;

insert into moeda (data_dadastro, data_atualizacao, sigla , tipo_moeda, valor)
values
       (NOW(), NOW(), 'USD', 'Dolár', 5.21),
       (NOW(), NOW(), 'EUR', 'Euro', 6.29),
       (NOW(), NOW(), 'ARS', 'Peso Argentino', 0.064),
       (NOW(), NOW(), 'GBP', 'Libra Esterlina', 0.0091),
       (NOW(), NOW(), 'BTC', 'Bitcoin', 99541.86);

insert into empresa (data_dadastro, data_atualizacao, nome, cnpj, inscricao_estadual, email, telefone, endereco_cep, endereco_cidade,
                   endereco_bairro, endereco_logradouro, endereco_numero, endereco_complemento)
values
        (NOW(), NOW(), 'Empresas de Bebidas', '11.111.111/0001-11', 'isento', 'teste@email.com', '+55(16)99999-9999','11.111-111', 'São Carlos',
        'bairro de teste', 'logradouro teste', 'numero 111', 'Complemento teste'),
        (NOW(), NOW(), 'Empresas de Roupas', '22.222.222/0001-22', '222.222.222.222', 'teste2@email.com', '+55(16)99999-9999', '22.222-222', 'Ribeirão Preto',
         'bairro de teste', 'logradouro teste', 'numero 222', 'Complemento teste'),
        (NOW(), NOW(), 'Empresas de Contrução', '33.333.333/0001-33', 'isento', 'teste@email.com', '+55(16)99999-9999', '33.333-333', 'Sertãozinho',
         'bairro de teste', 'logradouro teste', 'numero 333', 'Complemento teste'),
        (NOW(), NOW(), 'Empresas de Serviços', '44.444.444/0001-44', 'isento', 'teste@email.com', '+55(16)99999-9999', '44.444-444', 'Araraquara',
         'bairro de teste', 'logradouro teste', 'numero 444', 'Complemento teste');

insert into empresa_moeda (empresa_id, moeda_id)
values
       (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 1),
       (3, 4),
       (4, 1);






