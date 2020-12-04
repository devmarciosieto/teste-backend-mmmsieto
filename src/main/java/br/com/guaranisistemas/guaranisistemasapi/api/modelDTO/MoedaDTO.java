package br.com.guaranisistemas.guaranisistemasapi.api.modelDTO;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class MoedaDTO {

    private String moedaTrabalho;

    private String cotacaoAtual;

    public String getMoedaTrabalho() {
        return moedaTrabalho;
    }

    public void setMoedaTrabalho(String moedaTrabalho) {
        this.moedaTrabalho = moedaTrabalho;
    }

    public String getCotacaoAtual() {
        BigDecimal bigDecimalCurrency = new BigDecimal(cotacaoAtual);
        return NumberFormat.getCurrencyInstance().format(bigDecimalCurrency);
    }

    public void setCotacaoAtual(String cotacaoAtual) {
        this.cotacaoAtual = cotacaoAtual;
    }
}
