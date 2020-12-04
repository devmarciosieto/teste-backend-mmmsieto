package br.com.guaranisistemas.guaranisistemasapi.api.controller;

import br.com.guaranisistemas.guaranisistemasapi.api.assembler.EmpresaDTOAssembler;
import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaDTO;
import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaOutList;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import br.com.guaranisistemas.guaranisistemasapi.domain.repository.EmpresaRepository;
import br.com.guaranisistemas.guaranisistemasapi.domain.service.EmpresaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/empresas", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaDTOAssembler empresaDTOAssembler;
    
    // no meu git tem algumas api em java que estão rodando na aws que desenvolvi 
    // também tem alguns frontend em angular consumindo a api 
    // estes repositório estão privado porque estão com a senhas de banco de dados 
    // do S3, de email mais caso tenha caso tenha interesse conhecer estes projetos
    // posso retirar estas propriedade 
    // e enviar o link estes repositórios

    // aplicação deverá “economizar” chamadas a API de terceiros a fim de evitar custos desnecessários
    // com banda de rede e custos de requisições com API’s.
    // Para está logica acima eu vou levar em consideração que a mudança do valor da moeda se mudar uma vez no dia
    // vou criar uma metodo na class MoedaService onde cada pesquisa ou listagem ou busca por id das empresas, esta função vai verificar
    // os valores das moedas foram atualizado no dia, se os valores não foi atualizado aí o sistema faz a requisção
    // e atualiza os valores das moedas aí naquele dia as próximas pesquisas listagem ou busca por id, que forem feitas
    // não vai fazer requisição para api de terceiros, só no próximo dia, a primeira pesquisa que vai fazer a requisição
    // e atualizar a nossa base.

    // E eu também estou consirando que uma empresa possa trabalhar com mais de uma moedas

    @GetMapping("/{id}")
    public EmpresaDTO BuscarId(@PathVariable Long id) {
        return empresaDTOAssembler.toModelDetails(empresaService.buscarOuFalhar(id)) ;
    }

    // pode passar os dois campos ou só o nome ou só o cnpj
    // ou nenhum
    @GetMapping("/filtro-nome-e-cnpj-dinamico")
    public List<EmpresaOutList> buscarNomeCNPJ(String nome, String cnpj) {
        System.out.println(empresaService.atualizarMoedasDaBase());
        return empresaDTOAssembler.toCollectionModel(empresaRepository.find(nome, cnpj));
    }

    @GetMapping("/pesquisar-cnpj")
    public EmpresaOutList pesquisarCNPJ(String cnpj) {
        System.out.println(empresaService.atualizarMoedasDaBase());
        return empresaDTOAssembler.toModel(empresaRepository.findByCnpjEquals(cnpj)) ;
    }

    @GetMapping("/pesquisar-nome")
    public Page<EmpresaOutList> pesquisarNome(String nome, @PageableDefault(size = 2) Pageable pageable) {
        System.out.println(empresaService.atualizarMoedasDaBase());
        Page<Empresa> empresaList = empresaRepository.findByNomeContaining(nome, pageable);
        List<EmpresaOutList> empresaModel = empresaDTOAssembler.toCollectionModel(empresaList.getContent());
        Page<EmpresaOutList> empresaOutListPage = new PageImpl<>(empresaModel, pageable,
                empresaList.getTotalElements());
        return empresaOutListPage;
    }

    @GetMapping
    public Page<EmpresaOutList> listar(@PageableDefault(size = 2) Pageable pageable) {
        System.out.println(empresaService.atualizarMoedasDaBase());
        Page<Empresa> empresaList = empresaRepository.findAll(pageable);
        List<EmpresaOutList> empresaModel = empresaDTOAssembler.toCollectionModel(empresaList.getContent());
        Page<EmpresaOutList> empresaOutListPage = new PageImpl<>(empresaModel, pageable,
                empresaList.getTotalElements());
        return empresaOutListPage;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa salvar(@RequestBody Empresa empresa) {
        // Aqui se o cnpj estiver correto o sistema vai
        // atualizar o nome, endereço da empresas
        return empresaService.salvarEmpresaWS(empresa);
    }

    @PutMapping("/{id}")
    public EmpresaDTO atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa empresaAtual = empresaService.buscarOuFalhar(id);
        BeanUtils.copyProperties(empresa, empresaAtual, "id");
        return empresaDTOAssembler.toModelDetails(empresaService.salvar(empresaAtual));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        empresaService.excluir(id);
    }


}
