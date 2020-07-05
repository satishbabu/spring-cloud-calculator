package com.apnatriangle.calculatorservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "api-gateway-server", url = "localhost:8765/market-data-service")
public interface MarketDataProxy {

    @GetMapping("/price/{symbol}")
    public BigDecimal currentPrice(@PathVariable("symbol") String symbol);

}
