package com.telstra.codechallenge.starredRepos.controller;

import com.telstra.codechallenge.starredRepos.entity.StarredRepo;
import com.telstra.codechallenge.starredRepos.service.StarredRepoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StarredRepoControllerTest {
    @Mock
    private StarredRepoService starredRepoService;

    @InjectMocks
    private StarredRepoController starredRepoController;

    private List<StarredRepo> mockedStarredRepos;
    @BeforeEach
    void setUp(){
        // Mock data
        mockedStarredRepos = new ArrayList<>();
        mockedStarredRepos.add(new StarredRepo(
                "https://github.com/lllyasviel/IC-Light",
                100,
                "Python",
                "More relighting!",
                "IC-Light"));
    }

    @Test
    void testStarredRepos() throws URISyntaxException {

        // Mock service layer behavior
        when(starredRepoService.getStarredRepos(anyInt())).thenReturn(mockedStarredRepos);

        // Call the controller method
        List<StarredRepo> result = starredRepoController.starredRepos(5);

        // Assertion
        assertEquals(mockedStarredRepos, result);
    }

    @Test
    void testStarredRepos_InvalidParameter() {
        // Call the controller method with an invalid parameter
        assertThrows(IllegalArgumentException.class, () -> starredRepoController.starredRepos(0));
    }
}