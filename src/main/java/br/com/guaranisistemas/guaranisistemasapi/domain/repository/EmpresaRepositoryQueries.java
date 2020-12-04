package br.com.guaranisistemas.guaranisistemasapi.domain.repository;

import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import java.util.List;

public interface EmpresaRepositoryQueries {
    List<Empresa> find(String nome, String cnpj);
}
