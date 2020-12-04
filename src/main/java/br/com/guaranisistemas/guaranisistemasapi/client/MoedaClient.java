package br.com.guaranisistemas.guaranisistemasapi.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

@Service
public class MoedaClient {

    private String url = "https://economia.awesomeapi.com.br/json/all";
    private RestTemplate restTemplate = new RestTemplate();

    public HashMap buscarCotacao() {

            URI resourceUri = URI.create(url);
            HashMap tipoMoeda = restTemplate.getForObject(resourceUri, HashMap.class);

        return tipoMoeda;
    }
}

