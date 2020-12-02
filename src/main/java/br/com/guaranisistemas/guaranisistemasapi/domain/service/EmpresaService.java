package br.com.guaranisistemas.guaranisistemasapi.domain.service;

import br.com.guaranisistemas.guaranisistemasapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import br.com.guaranisistemas.guaranisistemasapi.domain.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaService {

    private static final String MSG_EMPRESA_EM_USO
            = "A empresa de código %d não pode ser removida, pois está em uso";

    private static final String MSG_EMPRESA_NAO_ENCONTRADO
            = "A empresa de código %d não foi encotrado";

    @Autowired
    private EmpresaRepository empresaRepository;


    @Transactional
    public Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }


   public Empresa buscarOuFalhar(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_EMPRESA_NAO_ENCONTRADO, id)));
   }


    public void excluir(Long id) {
        Empresa empresa = buscarOuFalhar(id);
        empresaRepository.delete(empresa);
    }

}
