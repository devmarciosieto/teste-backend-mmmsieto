package br.com.guaranisistemas.guaranisistemasapi.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Qsa {

    private String qual;
    private String nome;
}
