package com.telstra.codechallenge.starredRepos.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.telstra.codechallenge.starredRepos.entity.StarredRepo;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class StarredRepoResponse {
    private List<StarredRepo> items;
}