package br.com.guaranisistemas.guaranisistemasapi.api.controller;

import br.com.guaranisistemas.guaranisistemasapi.api.assembler.EmpresaDTOAssembler;
import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaOutList;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import br.com.guaranisistemas.guaranisistemasapi.domain.repository.EmpresaRepository;
import br.com.guaranisistemas.guaranisistemasapi.domain.service.EmpresaService;
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

    @GetMapping("/{id}")
    public Empresa BuscarId(@PathVariable Long id) {
        return empresaService.buscarOuFalhar(id);
    }

    @GetMapping
    public Page<EmpresaOutList> listar(@PageableDefault(size = 2) Pageable pageable) {
        Page<Empresa> empresaList = empresaRepository.findAll(pageable);
        List<EmpresaOutList> empresaModel = empresaDTOAssembler.toCollectionModel(empresaList.getContent());
        Page<EmpresaOutList> empresaOutListPage = new PageImpl<>(empresaModel, pageable,
                empresaList.getTotalElements());
        return empresaOutListPage;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa salvar(@RequestBody Empresa empresa) {
        return empresaService.salvar(empresa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        empresaService.excluir(id);
    }

}
