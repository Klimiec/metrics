package com.dev.shop.pl.ecommerce.catalog.adapters.api;


import com.dev.shop.pl.ecommerce.catalog.domain.FindingProduct;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CatalogEndpoint {

    private final FindingProduct findingProduct;
    private final MeterRegistry meterRegistry;

    @GetMapping("/catalog/find")
    public String findProducts() {

        meterRegistry.counter("api_catalog_get", "tag_A", "AAA").increment();

        Timer.Sample sample = Timer.start(meterRegistry);
        final String result = findingProduct.search();
        sample.stop(meterRegistry.timer("api_catalog_get_time", "response", result));

        return result;
    }
}
