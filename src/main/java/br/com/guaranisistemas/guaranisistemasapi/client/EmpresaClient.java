package br.com.guaranisistemas.guaranisistemasapi.client;

import br.com.guaranisistemas.guaranisistemasapi.client.model.EmpresaWS;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class EmpresaClient {

    private String url = "https://www.receitaws.com.br/v1/cnpj/";
    private RestTemplate restTemplate = new RestTemplate();

    public EmpresaWS buscarReceitaWS(String cnpj) {

        String cnpjLimpo = cnpj.replaceAll("[^0-9 ]", "");

        if (cnpjLimpo.length() == 14) {
            URI resourceUri = URI.create(url + cnpjLimpo);
            EmpresaWS empresaWS = restTemplate.getForObject(resourceUri, EmpresaWS.class);
            return empresaWS;
        }
        return null;
    }
}
