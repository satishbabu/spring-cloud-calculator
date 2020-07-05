package com.apnatriangle.calculatorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorController {
    @Autowired
    private MarketDataProxy marketDataProxy;

    @GetMapping("/calculatePrice/{symbol}/{quantity}")
    public BigDecimal calculatePrice(@PathVariable String symbol, @PathVariable int quantity) {

        BigDecimal price = marketDataProxy.currentPrice(symbol);
        return price.multiply(new BigDecimal(quantity));
    }
}
