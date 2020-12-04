package br.com.guaranisistemas.guaranisistemasapi.domain.service;

import br.com.guaranisistemas.guaranisistemasapi.client.EmpresaClient;
import br.com.guaranisistemas.guaranisistemasapi.client.MoedaClient;
import br.com.guaranisistemas.guaranisistemasapi.client.model.EmpresaWS;
import br.com.guaranisistemas.guaranisistemasapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Moeda;
import br.com.guaranisistemas.guaranisistemasapi.domain.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class EmpresaService {

    private static final String MSG_EMPRESA_EM_USO
            = "A empresa de código %d não pode ser removida, pois está em uso";

    private static final String MSG_EMPRESA_NAO_ENCONTRADO
            = "A empresa de código %d não foi encotrado";

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaClient empresaClient;

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private MoedaClient moedaClient;


    // Começando a implementação
    // de atualição da Moedas
    public String atualizarMoedasDaBase() {
        Moeda moeda = moedaService.buscarOuFalhar(1L);
        LocalDate data =  LocalDate.of( moeda.getDataAtualizacao().getYear() , moeda.getDataAtualizacao().getMonth(), moeda.getDataAtualizacao().getDayOfMonth() );
        if(!data.equals(LocalDate.now())){
            return "Aqui vou fazer a chamada na api de tereceiro e atualizar o valor das moedas";
        } else {
            HashMap moedas = moedaClient.buscarCotacao();
            System.out.println(moedas);
            return "Os valores da moedas já foram atualizados hoje";
        }

    }


    @Transactional
    public Empresa salvarEmpresaWS(Empresa empresa) {

        // aqui falta eu implementar o tratamento de uma exception
        // na hora de buscar na api de terceiros
        EmpresaWS empresaWS = empresaClient.buscarReceitaWS(empresa.getCnpj());

        // aqui falta eu reduzir este código com ModelMapper
        if (empresaWS != null) {
            empresa.setNome(empresaWS.getNome());
            empresa.getEndereco().setLogradouro(empresaWS.getLogradouro());
            empresa.getEndereco().setNumero(empresaWS.getNumero());
            empresa.getEndereco().setBairro(empresaWS.getBairro());
            empresa.getEndereco().setCidade(empresaWS.getMunicipio());
            empresa.getEndereco().setCep(empresaWS.getCep());
        }
        return salvar(empresa);
    }


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
