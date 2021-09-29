package com.dev.shop.pl.ecommerce.warehouse.adapter.api;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WarehouseEndpoint {

    @GetMapping("/warehouse/search")
    public List<String> findProducts() {
        return List.of("AAA", "BBB", "CCC");
    }
}
