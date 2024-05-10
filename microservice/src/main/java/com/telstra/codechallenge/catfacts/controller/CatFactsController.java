package com.telstra.codechallenge.catfacts.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import com.telstra.codechallenge.catfacts.entity.CatFact;
import com.telstra.codechallenge.catfacts.service.CatFactsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CatFactsController {
  private final CatFactsService catFactsService;

  public CatFactsController(
      CatFactsService catFactsService) {
    this.catFactsService = catFactsService;
  }

  @GetMapping(path = "/catFacts")
  public List<CatFact> catFacts() throws URISyntaxException {
    return catFactsService.getCatFacts();
  }
}
