package com.telstra.codechallenge.starredRepos.controller;

import com.telstra.codechallenge.starredRepos.entity.StarredRepo;
import com.telstra.codechallenge.starredRepos.service.StarredRepoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class StarredRepoController {
    private final StarredRepoService starredRepoService;
    private final Logger logger = LoggerFactory.getLogger(StarredRepoController.class);
    public StarredRepoController(StarredRepoService starredRepoService) {
        this.starredRepoService = starredRepoService;
    }

    @GetMapping(path = "/starredRepo")
    public List<StarredRepo> starredRepos(@RequestParam("n") Integer n) throws URISyntaxException {
        logger.info("Retrieving {} repositories with the highest stars", n);
        if (n <= 0){
            throw new IllegalArgumentException("Parameter n must be greater then 0");
        }
        return starredRepoService.getStarredRepos(n);
    }
}