package com.telstra.codechallenge;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MicroserviceApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(MicroserviceApplicationTests.class);
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testHealth() throws RestClientException, MalformedURLException {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("user", "password");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate
            .exchange(
                new URL("http://localhost:" + port + "/actuator/health").toString(),
                HttpMethod.GET,
                entity, String.class);
        logger.info("response: " + response);
        assertEquals("{\"status\":\"UP\"}", response.getBody());
    }
}