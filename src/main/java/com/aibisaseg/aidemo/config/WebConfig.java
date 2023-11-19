package com.aibisaseg.aidemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig  {

    @Bean
    WebClient webClient() {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();

        return WebClient.builder().baseUrl("https://api.chatpdf.com/v1/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("x-api-key", "sec_A7pt4J83cvAAcJqUv4OJeMFyuW1W8FNE")
                .exchangeStrategies(strategies)
                .build();
    }
}
