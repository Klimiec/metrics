package com.dev.shop.pl.ecommerce.catalog.domain;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@AllArgsConstructor
public class FindingProduct {

    private final Random random = new Random();
    private final RestTemplateBuilder restTemplateBuilder;

    @SneakyThrows
    public String search() {
        int sleepTime = random.nextInt(1000);
        Thread.sleep(sleepTime);

        if (sleepTime >= 980) {
            log.error("Error. Sleep time {} ms", sleepTime);
            throw new IllegalStateException();
        } else if (sleepTime > 700 && sleepTime < 979) {
            log.warn("Warning. Sleep time {} ms", sleepTime);
        } else {
            log.info("Info. Sleep time {} ms. Make REST CALL", sleepTime);
            ResponseEntity<String> response
                    = restTemplateBuilder.build()
                    .getForEntity("http://localhost:8081//warehouse/search", String.class);
        }

        return "Product";
    }

}
