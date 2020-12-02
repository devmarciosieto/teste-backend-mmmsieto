package br.com.guaranisistemas.guaranisistemasapi.domain.repository;

import br.com.guaranisistemas.guaranisistemasapi.domain.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Long> {
}
