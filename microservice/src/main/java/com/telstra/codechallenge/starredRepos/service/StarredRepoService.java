package com.telstra.codechallenge.starredRepos.service;

import com.telstra.codechallenge.starredRepos.entity.StarredRepo;
import com.telstra.codechallenge.starredRepos.service.model.StarredRepoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StarredRepoService {
    private final RestTemplate restTemplate;
    @Value("${starredRepo.base.url}")
    private String starredRepoBaseUrl;

    public StarredRepoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves top n of starred repositories created within the last 7 days.
     *
     * @param number The number of repository to retrieve.
     * @return A list of starred repos sorted in descending order.
     * @throws URISyntaxException if the query URI syntax is formed incorrectly.
     */
    public List<StarredRepo> getStarredRepos(Integer number) throws URISyntaxException {
        LocalDate dateSevenFromToday = LocalDate.now().minusDays(7);
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dateSevenFromToday);
        String timeframe = URLEncoder.encode("created:>" + formattedDate, StandardCharsets.UTF_8);
        String perPage = number.toString();
        String sortBy = "stars";
        URI repoUrl = new URI(
                starredRepoBaseUrl +
                "?q=" + timeframe +
                "&per_page=" + perPage +
                "&sort=" + sortBy
        );

        StarredRepoResponse starredRepoResponse = restTemplate.getForObject(repoUrl, StarredRepoResponse.class);
        List<StarredRepo> starredRepos = null;
        if (starredRepoResponse != null) {
            starredRepos = starredRepoResponse.getItems();
        }
        return starredRepos;
    }
}