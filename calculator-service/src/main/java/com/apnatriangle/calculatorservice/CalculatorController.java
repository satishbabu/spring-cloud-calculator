package com.apnatriangle.calculatorservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {

    @GetMapping("/calculatePrice/{symbol}/{quantity}")
    public BigDecimal calculatePrice(@PathVariable String symbol, @PathVariable int quantity) {

        Map<String, String> uriParameters = new HashMap<String, String>();
        uriParameters.put("symbol", symbol);

        ResponseEntity<BigDecimal> responseEntity =
                new RestTemplate().getForEntity(
                        "http://localhost:8090/price/{symbol}",
                        BigDecimal.class,
                        uriParameters);

        BigDecimal price =  responseEntity.getBody();
        return price.multiply(new BigDecimal(quantity));
    }

}
