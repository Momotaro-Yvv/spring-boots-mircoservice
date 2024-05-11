package com.telstra.codechallenge.starredRepos.service;

import com.telstra.codechallenge.starredRepos.entity.StarredRepo;
import com.telstra.codechallenge.starredRepos.service.model.StarredRepoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StarredRepoServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private StarredRepoService starredRepoService;

    @Test
    void testGetStarredRepos() throws URISyntaxException {
        // Mock data
        List<StarredRepo> mockedStarredRepos = new ArrayList<>();
        mockedStarredRepos.add(new StarredRepo(
                "https://github.com/lllyasviel/IC-Light",
                100,
                "Python",
                "More relighting!",
                "IC-Light")
        );

        // Mock restTemplate behavior
        when(restTemplate.getForObject(any(URI.class), eq(StarredRepoResponse.class)))
                .thenReturn(new StarredRepoResponse(mockedStarredRepos));

        // Call the method under test
        List<StarredRepo> result = starredRepoService.getStarredRepos(5);

        // Assertions
        assertEquals(1, result.size());
        assertEquals("IC-Light", result.get(0).getName());
    }
}