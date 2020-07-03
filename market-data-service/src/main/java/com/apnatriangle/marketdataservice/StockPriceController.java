package com.apnatriangle.marketdataservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockPriceController {
    @GetMapping("/price/{symbol}")
    public Double currentPrice(@PathVariable String symbol) {
        return 0.0d;
    }
}
