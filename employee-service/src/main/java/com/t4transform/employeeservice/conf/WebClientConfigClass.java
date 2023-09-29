package com.t4transform.employeeservice.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigClass {
    @Bean
    public WebClient createWebClient() {
        return WebClient.builder().build();
    }
}
