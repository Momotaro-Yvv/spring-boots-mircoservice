package com.telstra.codechallenge.catfacts.service;

import com.telstra.codechallenge.catfacts.entity.CatFact;
import com.telstra.codechallenge.catfacts.service.model.CatFactResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class CatFactsService {
    private final RestTemplate restTemplate;
    @Value("${catFacts.base.url}")
    private String catFactsBaseUrl;
    @Value("${catFacts.fact.endpoint}")
    private String catFactsEndpoint;

    public CatFactsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Returns an array of cat facts.
     * Taken from <a href="https://catfact.ninja/facts">https://catfact.ninja/facts</a>.
     * For API documentation see: <a href="https://catfact.ninja/">https://catfact.ninja/</a>.
     *
     * @return - a cat fact list.
     */
    public List<CatFact> getCatFacts() throws URISyntaxException {
        URI catUrl = new URI(catFactsBaseUrl + catFactsEndpoint);
        CatFactResponse catFactResponse =
            restTemplate.getForObject(catUrl, CatFactResponse.class);
        List<CatFact> catFacts = null;
        if (catFactResponse != null) {
            catFacts = catFactResponse.getData();
        }

        return catFacts;
    }
}
