package br.com.guaranisistemas.guaranisistemasapi.infrastructure.repository;

import org.springframework.util.StringUtils;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import br.com.guaranisistemas.guaranisistemasapi.domain.repository.EmpresaRepositoryQueries;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpresaRepositoryImpl implements EmpresaRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Empresa> find(String nome, String cnpj) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Empresa> criteria = builder.createQuery(Empresa.class);
        Root<Empresa> root = criteria.from(Empresa.class);

        ArrayList<Predicate> predicates = new ArrayList<>();


        if (StringUtils.hasText(nome)) {
            predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
        }

        if (StringUtils.hasText(cnpj)) {
            predicates.add(builder.equal(root.get("cnpj"), cnpj));
        }

        criteria.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Empresa> query = manager.createQuery(criteria);

        return query.getResultList();
    }

}
