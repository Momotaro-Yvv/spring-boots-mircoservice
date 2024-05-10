package com.telstra.codechallenge.starredRepos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarredRepo {

    private String html_url;
    private Integer watchers_count;
    private String language;
    private String description;
    private String name;
}