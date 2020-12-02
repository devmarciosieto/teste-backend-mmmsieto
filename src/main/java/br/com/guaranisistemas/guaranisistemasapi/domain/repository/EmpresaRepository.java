package br.com.guaranisistemas.guaranisistemasapi.domain.repository;

import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
