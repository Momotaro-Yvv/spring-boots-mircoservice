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

    public StarredRepo(String html_url, Integer watchers_count, String language, String description, String name) {
        this.html_url = html_url;
        this.watchers_count = watchers_count;
        this.language = language;
        this.description = description;
        this.name = name;
    }
}