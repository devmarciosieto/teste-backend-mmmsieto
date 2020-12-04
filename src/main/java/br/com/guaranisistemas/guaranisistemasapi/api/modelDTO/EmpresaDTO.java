package br.com.guaranisistemas.guaranisistemasapi.api.modelDTO;

import br.com.guaranisistemas.guaranisistemasapi.domain.model.Endereco;

import java.util.List;

public class EmpresaDTO {

    private String cnpj;
    private String nome;
    private String email;
    private Endereco endereco;
    private List<MoedaDTO> moedasTrabalho;

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

    public List<MoedaDTO> getMoedasTrabalho() {
        return moedasTrabalho;
    }

    public void setMoedasTrabalho(List<MoedaDTO> moedasTrabalho) {
        this.moedasTrabalho = moedasTrabalho;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
