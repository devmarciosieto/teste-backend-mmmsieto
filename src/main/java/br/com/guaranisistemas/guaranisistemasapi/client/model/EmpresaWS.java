package br.com.guaranisistemas.guaranisistemasapi.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmpresaWS {

    private String data_situacao;
    private String tipo;
    private String uf;
    private String nome;
    private String situacao;
    private String bairro;
    private String logradouro;
    private String numero;
    private String cep;
    private String municipio;
    private String porte;
    private String abertura;
    private String natureza_juridica;
    private String cnpj;
    private String ultima_atualizacao;
    private String status;
    private String fantasia;
    private String complemento;
    private String email;
    private String telefone;
    private String efr;
    private String motivo_situacao;
    private String situacao_especial;
    private String data_situacao_especial;
    private String capital_social;
    private Object extra;

    @Embedded
    private List<AtividadePrincipal> atividade_principal = new ArrayList<>();

    @Embedded
    private List<Qsa> qsa = new ArrayList<>();

    @Embedded
    private List<AtividadesSecundarias> atividades_secundarias = new ArrayList<>();

    @Embedded
    private Billing billing;

}
