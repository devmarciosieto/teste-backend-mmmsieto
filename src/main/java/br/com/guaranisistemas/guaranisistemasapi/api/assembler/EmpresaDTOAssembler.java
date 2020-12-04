package br.com.guaranisistemas.guaranisistemasapi.api.assembler;

import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaDTO;
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

    public EmpresaOutList toModel(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaOutList.class);
    }

    public EmpresaDTO toModelDetails(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

    public List<EmpresaOutList> toCollectionModel(List<Empresa> empresas) {
        return empresas.stream()
                .map(empresa -> toModel(empresa))
                .collect(Collectors.toList());
    }

}
