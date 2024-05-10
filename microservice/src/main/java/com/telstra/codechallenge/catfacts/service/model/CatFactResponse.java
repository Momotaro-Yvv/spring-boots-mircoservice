package com.telstra.codechallenge.catfacts.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

import com.telstra.codechallenge.catfacts.entity.CatFact;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CatFactResponse {
  private List<CatFact> data;
}
