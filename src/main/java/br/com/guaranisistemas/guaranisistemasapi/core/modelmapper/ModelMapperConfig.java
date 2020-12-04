package br.com.guaranisistemas.guaranisistemasapi.core.modelmapper;

import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaDTO;
import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaOutList;
import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.MoedaDTO;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Empresa;
import br.com.guaranisistemas.guaranisistemasapi.domain.model.Moeda;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Empresa.class, EmpresaOutList.class)
                .addMapping(Empresa::getMoedas, EmpresaOutList::setMoedasTrabalho);

        modelMapper.createTypeMap(Empresa.class, EmpresaDTO.class)
                .addMapping(Empresa::getMoedas, EmpresaDTO::setMoedasTrabalho);

        modelMapper.createTypeMap(Moeda.class, MoedaDTO.class)
                .addMapping(Moeda::getTipoMoeda, MoedaDTO::setMoedaTrabalho)
                .addMapping(Moeda::getValor, MoedaDTO::setCotacaoAtual);

        return modelMapper;
    }

}
