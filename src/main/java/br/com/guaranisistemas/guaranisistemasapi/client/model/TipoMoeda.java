package br.com.guaranisistemas.guaranisistemasapi.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TipoMoeda {

    @Embedded
    private List<MoedaCotacoes> MoedaCotacoes = new ArrayList<>();

}
