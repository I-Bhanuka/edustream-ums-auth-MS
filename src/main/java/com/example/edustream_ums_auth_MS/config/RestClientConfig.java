package com.example.edustream_ums_auth_MS.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import org.springframework.http.HttpHeaders;


@Configuration
@Getter
@Slf4j
public class RestClientConfig {

    // Base URL for the User Microservice
    @Value("${services.user.url}")
    private String userBackendUrl;

    // Create a separate RestClient for User Microservice

    @Bean
    @Qualifier("userRestClient")
    public RestClient userRestClient() {
        return RestClient.builder()
                .baseUrl(userBackendUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // Set the default return type to JSON
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE) // Set the default accept header
                .build();
    }


}
