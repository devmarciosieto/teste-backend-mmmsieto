package br.com.guaranisistemas.guaranisistemasapi.api.assembler;

import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaOutList;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmpresaDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EmpresaOutList toModel(Empresa restaurante) {
        return modelMapper.map(restaurante, EmpresaOutList.class);
    }

    public List<EmpresaOutList> toCollectionModel(List<Empresa> restaurantes) {
        return restaurantes.stream()
                .map(restaurante -> toModel(restaurante))
                .collect(Collectors.toList());
    }

}
