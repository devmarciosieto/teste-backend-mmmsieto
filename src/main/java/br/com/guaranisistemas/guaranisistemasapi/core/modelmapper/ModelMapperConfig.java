package br.com.guaranisistemas.guaranisistemasapi.core.modelmapper;

import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.EmpresaOutList;
import br.com.guaranisistemas.guaranisistemasapi.api.modelDTO.MoedaOutDTO;
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

        modelMapper.createTypeMap(Moeda.class, MoedaOutDTO.class)
                .addMapping(Moeda::getTipoMoeda, MoedaOutDTO::setMoedaTrabalho)
                .addMapping(Moeda::getValor, MoedaOutDTO::setCotacaoAtual);


        return modelMapper;
    }

}
