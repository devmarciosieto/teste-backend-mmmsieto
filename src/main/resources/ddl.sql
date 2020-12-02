create table empresa (id bigserial not null, cnpj varchar(20), data_atualizacao timestamp, data_dadastro timestamp,
email varchar(150), endereco_bairro varchar(100), endereco_cep varchar(12), endereco_cidade varchar(150),
endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(25),
inscricao_estadual varchar(20), nome varchar(255), telefone varchar(20), primary key (id));


create table empresa_moeda (empresa_id int8 not null, moeda_id int8 not null);

create table moeda (id bigserial not null, data_atualizacao timestamp, data_dadastro timestamp, sigla varchar(5),
 tipo_moeda varchar(50), valor numeric(19, 2), primary key (id));

alter table empresa_moeda add constraint FKbvaw8t1qpt1fnrb1ml7vpcvuf foreign key (moeda_id) references moeda;
alter table empresa_moeda add constraint FKnp0qs20cvh63h4ou9os588juq foreign key (empresa_id) references empresa;
