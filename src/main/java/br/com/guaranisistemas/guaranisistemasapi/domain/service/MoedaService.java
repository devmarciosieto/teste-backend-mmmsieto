package br.com.guaranisistemas.guaranisistemasapi.domain.service;

import br.com.guaranisistemas.guaranisistemasapi.domain.exception.EntidadeEmUsoException;
import br.com.guaranisistemas.guaranisistemasapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Moeda;
import br.com.guaranisistemas.guaranisistemasapi.domain.repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoedaService {

    private static final String MSG_MOEDA_EM_USO
            = "A moeda de código %d não pode ser removida, pois está em uso";

    private static final String MSG_MOEDA_NAO_ENCONTRADO
            = "A moeda de código %d não foi encotrado";

    @Autowired
    private MoedaRepository moedaRepository;

    @Transactional
    public Moeda salvar(Moeda moeda) {
        return moedaRepository.save(moeda);
    }

    public Moeda buscarOuFalhar(Long id) {
        return moedaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_MOEDA_NAO_ENCONTRADO, id)));
    }


    public void excluir(Long id) {
        Moeda moeda = buscarOuFalhar(id);
        try {
            moedaRepository.delete(moeda);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_MOEDA_EM_USO, id));
        }

    }


}
