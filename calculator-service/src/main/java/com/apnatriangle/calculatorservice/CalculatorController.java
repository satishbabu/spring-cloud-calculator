package com.apnatriangle.calculatorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculatePrice")
    public Double calculatePrice(@RequestParam String symbol, @RequestParam int quantity) {
        return Double.valueOf(quantity);
    }

}
