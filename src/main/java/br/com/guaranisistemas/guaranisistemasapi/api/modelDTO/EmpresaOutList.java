package br.com.guaranisistemas.guaranisistemasapi.api.modelDTO;

import java.util.List;

public class EmpresaOutList {

    private String cnpj;
    private String nome;
    private String email;
    private List<MoedaOutDTO> moedasTrabalho;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MoedaOutDTO> getMoedasTrabalho() {
        return moedasTrabalho;
    }

    public void setMoedasTrabalho(List<MoedaOutDTO> moedasTrabalho) {
        this.moedasTrabalho = moedasTrabalho;
    }
}
