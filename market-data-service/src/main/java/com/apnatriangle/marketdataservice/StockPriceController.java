package com.apnatriangle.marketdataservice;

import com.apnatriangle.marketdataservice.entity.MarketPrice;
import com.apnatriangle.marketdataservice.entity.MarketPriceRepository;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class StockPriceController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MarketPriceRepository marketPriceRepository;

    @Timed(value = "currentSymbolPrice")
    @GetMapping("/price/{symbol}")
    public BigDecimal currentPrice(@PathVariable String symbol) {
        logger.info("Market Price for Symbol: {}", symbol);
        Optional<MarketPrice> marketPrice = marketPriceRepository.findById(symbol);
        if (marketPrice.isPresent()) {
            return marketPrice.get().getPrice();
        } else {
            throw new IllegalArgumentException("Symbol not found");
        }
    }


}
