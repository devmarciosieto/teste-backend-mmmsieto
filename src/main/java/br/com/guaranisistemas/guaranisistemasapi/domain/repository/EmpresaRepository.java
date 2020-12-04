package br.com.guaranisistemas.guaranisistemasapi.domain.repository;

import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>, EmpresaRepositoryQueries {

        Page<Empresa> findByNomeContaining(String cnpj, Pageable pageable);

        Empresa findByCnpjEquals(String cnpj);

}
