package com.apnatriangle.calculatorservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MarketDataProxy marketDataProxy;

    @GetMapping("/calculatePrice/{symbol}/{quantity}")
    public BigDecimal calculatePrice(@PathVariable String symbol, @PathVariable int quantity) {
        logger.info("calculatePrice for symbol {} for quantity {}", symbol, quantity);
        BigDecimal price = marketDataProxy.currentPrice(symbol);
        return price.multiply(new BigDecimal(quantity));
    }
}
