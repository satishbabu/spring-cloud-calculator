package com.apnatriangle.calculatorservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "market-data-service", url = "localhost:8090")
public interface MarketDataProxy {

    @GetMapping("/price/{symbol}")
    public BigDecimal currentPrice(@PathVariable("symbol") String symbol);

}
