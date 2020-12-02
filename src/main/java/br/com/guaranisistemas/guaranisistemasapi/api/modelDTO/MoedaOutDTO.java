package br.com.guaranisistemas.guaranisistemasapi.api.modelDTO;

import java.math.BigDecimal;

public class MoedaOutDTO {

    private String moedaTrabalho;

    private BigDecimal cotacaoAtual;

    public String getMoedaTrabalho() {
        return moedaTrabalho;
    }

    public void setMoedaTrabalho(String moedaTrabalho) {
        this.moedaTrabalho = moedaTrabalho;
    }

    public BigDecimal getCotacaoAtual() {
        return cotacaoAtual;
    }

    public void setCotacaoAtual(BigDecimal cotacaoAtual) {
        this.cotacaoAtual = cotacaoAtual;
    }
}
