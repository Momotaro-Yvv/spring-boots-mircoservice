package com.telstra.codechallenge.catfacts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CatFact {
    private String fact;
    private Integer length;
}
