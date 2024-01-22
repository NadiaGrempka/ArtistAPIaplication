package com.example.artistsapi;

import ch.qos.logback.classic.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

public class ExternalApiService {

    RestClient restClient;
    public ExternalApiService(){
        restClient = RestClient.create();
    }

    public Iterable<Department> getAllDeprtmentsFromMOMA() {
        List<Department> departments = restClient
                .get()
                .uri("https://collectionapi.metmuseum.org/public/collection/v1/departments")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return departments;
    }

}
