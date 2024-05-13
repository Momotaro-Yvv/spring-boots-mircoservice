package com.telstra.codechallenge.catfacts.controller;

import com.telstra.codechallenge.catfacts.entity.CatFact;
import com.telstra.codechallenge.catfacts.service.CatFactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CatFactsController {
    private final CatFactsService catFactsService;
    private final Logger logger = LoggerFactory.getLogger(CatFactsController.class);

    public CatFactsController(
        CatFactsService catFactsService) {
        this.catFactsService = catFactsService;
    }

    @GetMapping(path = "/catFacts")
    public List<CatFact> catFacts() throws URISyntaxException {
        logger.info("CatFactsController: Retrieving facts on cats");
        return catFactsService.getCatFacts();
    }
}
