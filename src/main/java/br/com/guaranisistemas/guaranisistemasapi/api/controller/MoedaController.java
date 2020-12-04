package br.com.guaranisistemas.guaranisistemasapi.api.controller;

import br.com.guaranisistemas.guaranisistemasapi.client.MoedaClient;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Moeda;
import br.com.guaranisistemas.guaranisistemasapi.domain.repository.MoedaRepository;
import br.com.guaranisistemas.guaranisistemasapi.domain.service.MoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/moedas", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoedaController {

    @Autowired
    private MoedaRepository moedaRepository;

    @Autowired
    private MoedaService moedaService;

    @GetMapping("/{moedaId}")
    public Moeda BuscarId(@PathVariable Long moedaId) {
        return moedaService.buscarOuFalhar(moedaId);
    }

    @GetMapping
    private List<Moeda> listar() {
        return moedaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Moeda salvar(@RequestBody Moeda moeda) {
        return moedaService.salvar(moeda);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        moedaService.excluir(id);
    }

}
