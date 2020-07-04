package com.apnatriangle.marketdataservice;

import com.apnatriangle.marketdataservice.entity.MarketPrice;
import com.apnatriangle.marketdataservice.entity.MarketPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StockPriceController {

    @Autowired
    private MarketPriceRepository marketPriceRepository;

    @GetMapping("/price/{symbol}")
    public MarketPrice currentPrice(@PathVariable String symbol) {
        Optional<MarketPrice> marketPrice = marketPriceRepository.findById(symbol);
        if (marketPrice.isPresent()) {
            return marketPrice.get();
        } else {
            throw new IllegalArgumentException("Symbol not found");
        }
    }
}
